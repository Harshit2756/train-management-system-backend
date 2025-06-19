package com.tcs.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.booking.dto.BookingRequestDTO;
import com.tcs.booking.dto.SeatSelectionDTO;
import com.tcs.booking.model.Seat;
import com.tcs.booking.model.SeatStatus;
import com.tcs.booking.model.SeatType;
import com.tcs.booking.repository.SeatRepository;

@Service
public class SeatAllotmentService {

    @Autowired
    private SeatRepository seatRepository;

    public List<SeatSelectionDTO> allocateSeats(BookingRequestDTO dto) {
        // Fetch all seats for the train, class, and date
        List<Seat> allSeats = seatRepository.findByTrainIdAndSeatClassAndStatusAndTravelDate(
                dto.getTrainId(),
                dto.getSeatSelections().get(0).getSeatClass(),
                SeatStatus.CONFIRMED,
                dto.getTravelDate()
        );
        // Filter out already booked seats for the date
        List<String> bookedSeatNumbers = seatRepository.findBookedSeatNumbers(
                dto.getTrainId(),
                dto.getTravelDate()
        );
        List<Seat> availableSeats = allSeats
                .stream()
                .filter(seat -> !bookedSeatNumbers.contains(seat.getSeatNumber()))
                .collect(Collectors.toList());
        // Senior citizen logic: prioritize lower berths
        List<SeatSelectionDTO> result = new ArrayList<>();
        int count = 0;
        for (Long passengerId : dto.getPassengerIds()) {
            // For demo, assume every 3rd passenger is senior (should fetch age from DB)
            boolean isSenior = (count % 3 == 0);
            Seat seat = availableSeats
                    .stream()
                    .filter(s -> isSenior ? s.getSeatType() == SeatType.LOWER : true)
                    .findFirst()
                    .orElse(null);
            if (seat == null && !availableSeats.isEmpty()) {
                seat = availableSeats.get(0);
            }
            if (seat != null) {
                SeatSelectionDTO sel = new SeatSelectionDTO();
                sel.setPassengerId(passengerId);
                sel.setSeatType(seat.getSeatType());
                sel.setSeatClass(seat.getSeatClass());
                sel.setSeatNumber(seat.getSeatNumber());
                sel.setFare(seat.getFare());
                result.add(sel);
                availableSeats.remove(seat);
            }
            count++;
        }
        return result;
    }
}
