package com.tcs.food.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.food.dto.FoodItemDTO;
import com.tcs.food.model.FoodItem;
import com.tcs.food.repository.FoodItemRepository;

@Service
public class FoodMenuService  {

  @Autowired
  private FoodItemRepository foodItemRepository;

  private FoodItemDTO toDTO(FoodItem entity) {
    FoodItemDTO dto = new FoodItemDTO();
    dto.setFoodItemId(entity.getFoodItemId());
    dto.setItemName(entity.getItemName());
    dto.setDescription(entity.getDescription());
    dto.setCategory(entity.getCategory());
    dto.setPrice(entity.getPrice());
    dto.setImageUrl(entity.getImageUrl());
    dto.setIsVegetarian(entity.getIsVegetarian());
    dto.setIsAvailable(entity.getIsAvailable());
    dto.setPreparationTime(entity.getPreparationTime());
    return dto;
  }

  private FoodItem toEntity(FoodItemDTO dto) {
    FoodItem entity = new FoodItem();
    entity.setFoodItemId(dto.getFoodItemId());
    entity.setItemName(dto.getItemName());
    entity.setDescription(dto.getDescription());
    entity.setCategory(dto.getCategory());
    entity.setPrice(dto.getPrice());
    entity.setImageUrl(dto.getImageUrl());
    entity.setIsVegetarian(dto.getIsVegetarian());
    entity.setIsAvailable(dto.getIsAvailable());
    entity.setPreparationTime(dto.getPreparationTime());
    entity.setCreatedAt(java.time.LocalDateTime.now());
    entity.setUpdatedAt(java.time.LocalDateTime.now());
    return entity;
  }

  public List<FoodItemDTO> getAllFoodItems() {
    return foodItemRepository
      .findAll()
      .stream()
      .map(this::toDTO)
      .collect(Collectors.toList());
  }

  public List<FoodItemDTO> getFoodItemsByTrain(Long trainId) {
    // Stub: No trainId in FoodItem, return all for now
    return getAllFoodItems();
  }

  public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
    FoodItem entity = toEntity(foodItemDTO);
    entity.setCreatedAt(java.time.LocalDateTime.now());
    entity.setUpdatedAt(java.time.LocalDateTime.now());
    FoodItem saved = foodItemRepository.save(entity);
    return toDTO(saved);
  }

  public FoodItemDTO updateFoodItem(Long itemId, FoodItemDTO foodItemDTO) {
    Optional<FoodItem> optional = foodItemRepository.findById(itemId);
    if (optional.isPresent()) {
      FoodItem entity = optional.get();
      entity.setItemName(foodItemDTO.getItemName());
      entity.setDescription(foodItemDTO.getDescription());
      entity.setCategory(foodItemDTO.getCategory());
      entity.setPrice(foodItemDTO.getPrice());
      entity.setImageUrl(foodItemDTO.getImageUrl());
      entity.setIsVegetarian(foodItemDTO.getIsVegetarian());
      entity.setIsAvailable(foodItemDTO.getIsAvailable());
      entity.setPreparationTime(foodItemDTO.getPreparationTime());
      entity.setUpdatedAt(java.time.LocalDateTime.now());
      FoodItem saved = foodItemRepository.save(entity);
      return toDTO(saved);
    }
    throw new RuntimeException("Food item not found");
  }

  public void deleteFoodItem(Long itemId) {
    foodItemRepository.deleteById(itemId);
  }
}
