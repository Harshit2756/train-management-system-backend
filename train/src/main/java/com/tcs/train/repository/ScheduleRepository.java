package com.tcs.train.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.train.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
} 