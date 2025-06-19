package com.tcs.train.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.train.dto.TrainDTO;
import com.tcs.train.exception.TrainNotFoundException;
import com.tcs.train.model.Train;
import com.tcs.train.repository.TrainRepository;

@Service
public class TrainService {

  @Autowired
  private TrainRepository trainRepository;

  public List<TrainDTO> getAllTrains() {
    return trainRepository
      .findAll()
      .stream()
      .map(this::toDTO)
      .collect(Collectors.toList());
  }

  public TrainDTO getTrainById(Long trainId) {
    Train train = trainRepository
      .findById(trainId)
      .orElseThrow(() ->
        new TrainNotFoundException("Train not found with id: " + trainId)
      );
    return toDTO(train);
  }

  public List<TrainDTO> searchTrains(
    String trainNumber,
    String trainName,
    String trainType
  ) {
    return trainRepository
      .searchTrains(trainNumber, trainName, trainType)
      .stream()
      .map(this::toDTO)
      .collect(Collectors.toList());
  }

  public TrainDTO addTrain(TrainDTO dto) {
    Train train = toEntity(dto);
    train.setCreatedAt(LocalDateTime.now());
    train.setUpdatedAt(LocalDateTime.now());
    Train saved = trainRepository.save(train);
    return toDTO(saved);
  }

  public TrainDTO updateTrain(Long trainId, TrainDTO dto) {
    Train train = trainRepository
      .findById(trainId)
      .orElseThrow(() ->
        new TrainNotFoundException("Train not found with id: " + trainId)
      );
    train.setTrainNumber(dto.getTrainNumber());
    train.setTrainName(dto.getTrainName());
    train.setTrainType(dto.getTrainType());
    train.setTotalSeats(dto.getTotalSeats());
    train.setAcSeats(dto.getAcSeats());
    train.setSleeperSeats(dto.getSleeperSeats());
    train.setGeneralSeats(dto.getGeneralSeats());
    train.setStatus(dto.getStatus());
    train.setUpdatedAt(LocalDateTime.now());
    Train saved = trainRepository.save(train);
    return toDTO(saved);
  }

  public void deleteTrain(Long trainId) {
    if (!trainRepository.existsById(trainId)) {
      throw new TrainNotFoundException("Train not found with id: " + trainId);
    }
    trainRepository.deleteById(trainId);
  }

  private TrainDTO toDTO(Train train) {
    TrainDTO dto = new TrainDTO();
    dto.setTrainId(train.getTrainId());
    dto.setTrainNumber(train.getTrainNumber());
    dto.setTrainName(train.getTrainName());
    dto.setTrainType(train.getTrainType());
    dto.setTotalSeats(train.getTotalSeats());
    dto.setAcSeats(train.getAcSeats());
    dto.setSleeperSeats(train.getSleeperSeats());
    dto.setGeneralSeats(train.getGeneralSeats());
    dto.setStatus(train.getStatus());
    return dto;
  }

  private Train toEntity(TrainDTO dto) {
    Train train = new Train();
    train.setTrainId(dto.getTrainId());
    train.setTrainNumber(dto.getTrainNumber());
    train.setTrainName(dto.getTrainName());
    train.setTrainType(dto.getTrainType());
    train.setTotalSeats(dto.getTotalSeats());
    train.setAcSeats(dto.getAcSeats());
    train.setSleeperSeats(dto.getSleeperSeats());
    train.setGeneralSeats(dto.getGeneralSeats());
    train.setStatus(dto.getStatus());
    return train;
  }
}
