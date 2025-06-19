package com.tcs.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.food.model.Pantry;

@Repository
public interface PantryRepository extends JpaRepository<Pantry, Long> {}
