package com.tcs.food.service;

import com.tcs.food.dto.FoodOrderDTO;
import com.tcs.food.model.FoodOrder;
import com.tcs.food.repository.FoodOrderRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodOrderService {

  @Autowired
  private FoodOrderRepository foodOrderRepository;

  private FoodOrderDTO toDTO(FoodOrder entity) {
    FoodOrderDTO dto = new FoodOrderDTO();
    dto.setOrderId(entity.getOrderId());
    dto.setOrderNumber(entity.getOrderNumber());
    dto.setCustomerId(entity.getCustomerId());
    dto.setPnr(entity.getPnr());
    dto.setSeatNumber(entity.getSeatNumber());
    dto.setTrainId(entity.getTrainId());
    dto.setTotalAmount(entity.getTotalAmount());
    dto.setStatus(entity.getStatus());
    dto.setOrderTime(entity.getOrderTime());
    dto.setDeliveryTime(entity.getDeliveryTime());
    dto.setSpecialInstructions(entity.getSpecialInstructions());
    return dto;
  }

  private FoodOrder toEntity(FoodOrderDTO dto) {
    FoodOrder entity = new FoodOrder();
    entity.setOrderId(dto.getOrderId());
    entity.setOrderNumber(dto.getOrderNumber());
    entity.setCustomerId(dto.getCustomerId());
    entity.setPnr(dto.getPnr());
    entity.setSeatNumber(dto.getSeatNumber());
    entity.setTrainId(dto.getTrainId());
    entity.setTotalAmount(dto.getTotalAmount());
    entity.setStatus(dto.getStatus());
    entity.setOrderTime(dto.getOrderTime());
    entity.setDeliveryTime(dto.getDeliveryTime());
    entity.setSpecialInstructions(dto.getSpecialInstructions());
    return entity;
  }

  public FoodOrderDTO placeOrder(FoodOrderDTO orderDTO) {
    FoodOrder entity = toEntity(orderDTO);
    entity.setOrderTime(java.time.LocalDateTime.now());
    entity.setStatus(com.tcs.food.model.OrderStatus.PLACED);
    FoodOrder saved = foodOrderRepository.save(entity);
    return toDTO(saved);
  }

  public FoodOrderDTO getOrderById(Long orderId) {
    Optional<FoodOrder> optional = foodOrderRepository.findById(orderId);
    return optional.map(this::toDTO).orElse(null);
  }

  public List<FoodOrderDTO> getOrdersByCustomer(Long customerId) {
    return foodOrderRepository
      .findAll()
      .stream()
      .filter(order -> order.getCustomerId().equals(customerId))
      .map(this::toDTO)
      .collect(Collectors.toList());
  }

  public void cancelOrder(Long orderId) {
    Optional<FoodOrder> optional = foodOrderRepository.findById(orderId);
    if (optional.isPresent()) {
      FoodOrder order = optional.get();
      order.setStatus(com.tcs.food.model.OrderStatus.CANCELLED);
      foodOrderRepository.save(order);
    }
  }
}
