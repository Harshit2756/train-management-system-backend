package com.tcs.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.food.model.FoodOrderItem;

@Repository
public interface FoodOrderItemRepository
  extends JpaRepository<FoodOrderItem, Long> {}
