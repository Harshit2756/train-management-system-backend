package com.tcs.train.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tcs.train.model.Train;

public interface TrainRepository extends JpaRepository<Train, Long> {

    @Query(
            "SELECT t FROM Train t WHERE (:trainNumber IS NULL OR t.trainNumber = :trainNumber) "
            + "AND (:trainName IS NULL OR t.trainName LIKE %:trainName%) "
            + "AND (:trainType IS NULL OR t.trainType = :trainType)"
    )
    List<Train> searchTrains(
            @Param("trainNumber") String trainNumber,
            @Param("trainName") String trainName,
            @Param("trainType") String trainType
    );

    Optional<Train> findByTrainNumber(String trainNumber);
}
