package com.tcs.booking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.booking.client.TrainServiceClient;
import com.tcs.booking.dto.ApiResponse;
import com.tcs.booking.dto.TrainDTO;
import com.tcs.booking.model.Seat;
import com.tcs.booking.model.SeatClass;
import com.tcs.booking.repository.SeatRepository;

@Service
public class SeatReservationService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TrainServiceClient trainServiceClient;

    public List<Seat> getAvailableSeats(Long trainId, LocalDate travelDate, SeatClass seatClass) {
        // 1. Get train details to find out total seats
        ApiResponse<TrainDTO> trainResponse = trainServiceClient.getTrainById(trainId);
        TrainDTO train = trainResponse.getData();
        if (train == null) {
            throw new RuntimeException("Train not found");
        }

        int totalSeatsInClass = 0;
        String seatPrefix = "";
        switch (seatClass) {
            case AC_1:
                totalSeatsInClass = train.getAcSeats();
                seatPrefix = "A";
                break;
            case AC_2:
                totalSeatsInClass = train.getAcSeats();
                seatPrefix = "A";
                break;
            case AC_3:
                totalSeatsInClass = train.getAcSeats();
                seatPrefix = "A";
                break;
            case SLEEPER:
                totalSeatsInClass = train.getSleeperSeats();
                seatPrefix = "S";
                break;
            case GENERAL:
                totalSeatsInClass = train.getGeneralSeats();
                seatPrefix = "G";
                break;
        }

        // 2. Get booked seat numbers
        List<String> bookedSeatNumbers = seatRepository.findBookedSeatNumbers(trainId, travelDate);

        // 3. Generate all possible seat numbers for the class
        final String finalSeatPrefix = seatPrefix;
        List<String> allSeatNumbersInClass = IntStream.rangeClosed(1, totalSeatsInClass)
                .mapToObj(num -> finalSeatPrefix + num)
                .collect(Collectors.toList());

        // 4. Filter out booked seats
        List<String> availableSeatNumbers = allSeatNumbersInClass.stream()
                .filter(seatNum -> !bookedSeatNumbers.contains(seatNum))
                .collect(Collectors.toList());

        // 5. Create transient Seat objects to return
        List<Seat> availableSeats = new ArrayList<>();
        for (String seatNumber : availableSeatNumbers) {
            Seat seat = new Seat();
            seat.setSeatNumber(seatNumber);
            seat.setSeatClass(seatClass);
            // Set other properties as needed, e.g., fare, type.
            // This might require more info from the train service.
            // For now, we'll just return the number and class.
            availableSeats.add(seat);
        }

        return availableSeats;
    }

    public List<Seat> reserveSeats(List<Seat> seats) {
        // This method is likely called after payment to persist the chosen seats.
        // The current implementation is a dummy. A real implementation would need
        // to handle concurrency and ensure seats are not double-booked.
        return seatRepository.saveAll(seats);
    }
}
