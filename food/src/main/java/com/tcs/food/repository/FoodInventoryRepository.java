package com.tcs.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.food.model.FoodInventory;

@Repository
public interface FoodInventoryRepository extends JpaRepository<FoodInventory, Long> {
} 