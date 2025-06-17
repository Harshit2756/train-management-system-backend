package com.tcs.train.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.train.model.Station;

public interface StationRepository extends JpaRepository<Station, Long> {}
