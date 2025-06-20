package com.tcs.booking.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.booking.client.TrainServiceClient;
import com.tcs.booking.dto.ApiResponse;
import com.tcs.booking.dto.BookingRequestDTO;
import com.tcs.booking.dto.SeatSelectionDTO;
import com.tcs.booking.dto.TrainDTO;
import com.tcs.booking.exception.BookingNotFoundException;
import com.tcs.booking.exception.PaymentFailedException;
import com.tcs.booking.exception.SeatNotAvailableException;
import com.tcs.booking.exception.TrainNotFoundException;
import com.tcs.booking.model.Booking;
import com.tcs.booking.model.BookingStatus;
import com.tcs.booking.model.Payment;
import com.tcs.booking.model.PaymentStatus;
import com.tcs.booking.model.Seat;
import com.tcs.booking.repository.BookingRepository;
import com.tcs.booking.repository.SeatRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SeatAllotmentService seatAllotmentService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TrainServiceClient trainServiceClient;

    @Transactional
    public Booking createBooking(BookingRequestDTO dto) {
        // 0. Validate Train
        try {
            ApiResponse<TrainDTO> trainResponse = trainServiceClient.getTrainById(dto.getTrainId());
            if (trainResponse == null || trainResponse.getData() == null) {
                throw new TrainNotFoundException("Train with ID " + dto.getTrainId() + " not found.");
            }
        } catch (Exception e) {
            throw new TrainNotFoundException("Error validating train: " + e.getMessage());
        }

        // 1. Validate input (basic validation, can be extended)
        if (dto.getTotalPassengers() == null || dto.getTotalPassengers() <= 0) {
            throw new IllegalArgumentException(
                    "Total passengers must be greater than 0"
            );
        }
        // 2. Seat allocation
        List<SeatSelectionDTO> allocatedSeats = seatAllotmentService.allocateSeats(
                dto
        );
        if (allocatedSeats == null || allocatedSeats.size() < dto.getTotalPassengers()) {
            throw new SeatNotAvailableException(
                    "Not enough seats available for booking"
            );
        }
        // 3. Create booking (PENDING)
        Booking booking = new Booking();
        booking.setPnr("PNR" + System.currentTimeMillis());
        booking.setCustomerId(dto.getCustomerId());
        booking.setTrainId(dto.getTrainId());
        booking.setFromStationId(dto.getFromStationId());
        booking.setToStationId(dto.getToStationId());
        booking.setTravelDate(dto.getTravelDate());
        booking.setDepartureTime(dto.getDepartureTime());
        booking.setArrivalTime(dto.getArrivalTime());
        booking.setTotalPassengers(dto.getTotalPassengers());
        booking.setTotalAmount(dto.getTotalAmount());
        booking.setStatus(BookingStatus.PENDING);
        booking.setBookingDate(LocalDateTime.now());
        booking.setCreatedAt(LocalDateTime.now());
        booking = bookingRepository.save(booking);
        // 4. Process payment
        Payment payment = new Payment();
        payment.setBookingId(booking.getBookingId());
        payment.setAmount(dto.getTotalAmount());
        payment.setPaymentMethod(com.tcs.booking.model.PaymentMethod.UPI); // Example
        payment.setTransactionId("TXN" + System.currentTimeMillis());
        payment.setPaymentDate(LocalDateTime.now());
        payment = paymentService.processPayment(payment);
        if (payment.getStatus() != PaymentStatus.SUCCESS) {
            booking.setStatus(BookingStatus.CANCELLED);
            bookingRepository.save(booking);
            throw new PaymentFailedException("Payment failed. Booking cancelled.");
        }
        // 5. Confirm booking
        booking.setStatus(BookingStatus.CONFIRMED);
        booking = bookingRepository.save(booking);
        // 6. Assign seats
        List<Seat> savedSeats = new ArrayList<>();
        for (SeatSelectionDTO seatSel : allocatedSeats) {
            Seat seat = new Seat();
            seat.setBookingId(booking.getBookingId());
            seat.setPassengerId(seatSel.getPassengerId());
            seat.setSeatNumber(seatSel.getSeatNumber());
            seat.setSeatType(seatSel.getSeatType());
            seat.setSeatClass(seatSel.getSeatClass());
            seat.setFare(seatSel.getFare());
            seat.setStatus(com.tcs.booking.model.SeatStatus.CONFIRMED);
            seat.setCreatedAt(LocalDateTime.now());
            savedSeats.add(seatRepository.save(seat));
        }
        // 7. Generate tickets
        List<Long> passengerIds = new ArrayList<>();
        for (Seat seat : savedSeats) {
            passengerIds.add(seat.getPassengerId());
        }
        ticketService.generateTickets(
                booking.getBookingId(),
                passengerIds,
                dto.getTravelDate()
        );
        return booking;
    }

    public Booking getBooking(Long bookingId) {
        return bookingRepository
                .findById(bookingId)
                .orElseThrow(()
                        -> new BookingNotFoundException("Booking not found with id: " + bookingId)
                );
    }

    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepository
                .findById(bookingId)
                .orElseThrow(()
                        -> new BookingNotFoundException("Booking not found with id: " + bookingId)
                );
        booking.setStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(booking);
    }

    public Booking getBookingByPnr(String pnr) {
        Booking booking = bookingRepository.findByPnr(pnr);
        if (booking == null) {
            throw new BookingNotFoundException("Booking not found with PNR: " + pnr);
        }
        return booking;
    }
}
