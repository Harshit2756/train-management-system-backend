package com.tcs.train.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.train.dto.ScheduleDTO;
import com.tcs.train.exception.TrainNotFoundException;
import com.tcs.train.model.Schedule;
import com.tcs.train.repository.ScheduleRepository;

@Service
public class ScheduleService {

  @Autowired
  private ScheduleRepository scheduleRepository;

  public ScheduleDTO getScheduleForTrainAndDate(
    Long trainId,
    LocalDate travelDate
  ) {
    Schedule schedule = scheduleRepository
      .findAll()
      .stream()
      .filter(s ->
        s.getTrainId().equals(trainId) && s.getTravelDate().equals(travelDate)
      )
      .findFirst()
      .orElseThrow(() ->
        new TrainNotFoundException(
          "Schedule not found for trainId: " +
          trainId +
          " and date: " +
          travelDate
        )
      );
    return toDTO(schedule);
  }

  public ScheduleDTO createSchedule(ScheduleDTO dto) {
    Schedule schedule = toEntity(dto);
    Schedule saved = scheduleRepository.save(schedule);
    return toDTO(saved);
  }

  public ScheduleDTO updateSchedule(Long scheduleId, ScheduleDTO dto) {
    Schedule schedule = scheduleRepository
      .findById(scheduleId)
      .orElseThrow(() ->
        new TrainNotFoundException("Schedule not found with id: " + scheduleId)
      );
    schedule.setAvailableAcSeats(dto.getAvailableAcSeats());
    schedule.setAvailableSleeperSeats(dto.getAvailableSleeperSeats());
    schedule.setAvailableGeneralSeats(dto.getAvailableGeneralSeats());
    schedule.setStatus(dto.getStatus());
    Schedule saved = scheduleRepository.save(schedule);
    return toDTO(saved);
  }

  private ScheduleDTO toDTO(Schedule schedule) {
    ScheduleDTO dto = new ScheduleDTO();
    dto.setScheduleId(schedule.getScheduleId());
    dto.setTrainId(schedule.getTrainId());
    dto.setTravelDate(schedule.getTravelDate());
    dto.setAvailableAcSeats(schedule.getAvailableAcSeats());
    dto.setAvailableSleeperSeats(schedule.getAvailableSleeperSeats());
    dto.setAvailableGeneralSeats(schedule.getAvailableGeneralSeats());
    dto.setStatus(schedule.getStatus());
    return dto;
  }

  private Schedule toEntity(ScheduleDTO dto) {
    Schedule schedule = new Schedule();
    schedule.setScheduleId(dto.getScheduleId());
    schedule.setTrainId(dto.getTrainId());
    schedule.setTravelDate(dto.getTravelDate());
    schedule.setAvailableAcSeats(dto.getAvailableAcSeats());
    schedule.setAvailableSleeperSeats(dto.getAvailableSleeperSeats());
    schedule.setAvailableGeneralSeats(dto.getAvailableGeneralSeats());
    schedule.setStatus(dto.getStatus());
    return schedule;
  }
}
