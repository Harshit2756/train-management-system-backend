package com.tcs.train.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.train.model.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
} 