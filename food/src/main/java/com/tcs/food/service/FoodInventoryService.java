package com.tcs.food.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.food.dto.FoodInventoryDTO;
import com.tcs.food.model.FoodInventory;
import com.tcs.food.repository.FoodInventoryRepository;

@Service
public class FoodInventoryService  {

  @Autowired
  private FoodInventoryRepository foodInventoryRepository;

  private FoodInventoryDTO toDTO(FoodInventory entity) {
    FoodInventoryDTO dto = new FoodInventoryDTO();
    dto.setInventoryId(entity.getInventoryId());
    dto.setPantryId(entity.getPantryId());
    dto.setFoodItemId(entity.getFoodItemId());
    dto.setAvailableQuantity(entity.getAvailableQuantity());
    dto.setInventoryDate(entity.getInventoryDate());
    dto.setLastUpdated(entity.getLastUpdated());
    return dto;
  }

  private FoodInventory toEntity(FoodInventoryDTO dto) {
    FoodInventory entity = new FoodInventory();
    entity.setInventoryId(dto.getInventoryId());
    entity.setPantryId(dto.getPantryId());
    entity.setFoodItemId(dto.getFoodItemId());
    entity.setAvailableQuantity(dto.getAvailableQuantity());
    entity.setInventoryDate(dto.getInventoryDate());
    entity.setLastUpdated(java.time.LocalDateTime.now());
    return entity;
  }

  public FoodInventoryDTO updateInventory(FoodInventoryDTO inventoryDTO) {
    FoodInventory entity = toEntity(inventoryDTO);
    entity.setLastUpdated(java.time.LocalDateTime.now());
    FoodInventory saved = foodInventoryRepository.save(entity);
    return toDTO(saved);
  }

  public List<FoodInventoryDTO> getInventoryByPantry(Long pantryId) {
    return foodInventoryRepository
      .findAll()
      .stream()
      .filter(inv -> inv.getPantryId().equals(pantryId))
      .map(this::toDTO)
      .collect(Collectors.toList());
  }
}
