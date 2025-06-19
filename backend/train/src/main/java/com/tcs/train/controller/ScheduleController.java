package com.tcs.train.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.train.dto.ScheduleDTO;
import com.tcs.train.service.ScheduleService;

@RestController
@RequestMapping("/api")
public class ScheduleController {

  @Autowired
  private ScheduleService scheduleService;

  @GetMapping("/schedule/{trainId}/{date}")
  public ResponseEntity<ScheduleDTO> getScheduleForTrainAndDate(
    @PathVariable Long trainId,
    @PathVariable String date
  ) {
    LocalDate travelDate = LocalDate.parse(date);
    return ResponseEntity.ok(
      scheduleService.getScheduleForTrainAndDate(trainId, travelDate)
    );
  }

  @PostMapping("/admin/schedule")
  public ResponseEntity<ScheduleDTO> createSchedule(
    @RequestBody ScheduleDTO dto
  ) {
    return ResponseEntity.ok(scheduleService.createSchedule(dto));
  }

  @PutMapping("/admin/schedule/{scheduleId}")
  public ResponseEntity<ScheduleDTO> updateSchedule(
    @PathVariable Long scheduleId,
    @RequestBody ScheduleDTO dto
  ) {
    return ResponseEntity.ok(scheduleService.updateSchedule(scheduleId, dto));
  }
}
