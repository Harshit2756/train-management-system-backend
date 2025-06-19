package com.tcs.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.food.model.FoodOrder;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
} 