package com.tcs.food.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.food.client.BookingServiceClient;
import com.tcs.food.dto.BookingDTO;
import com.tcs.food.dto.FoodOrderRequestDTO;
import com.tcs.food.dto.FoodOrderResponseDTO;
import com.tcs.food.dto.OrderItemDTO;
import com.tcs.food.dto.OrderItemResponseDTO;
import com.tcs.food.exception.FoodItemNotFoundException;
import com.tcs.food.exception.InvalidBookingException;
import com.tcs.food.model.FoodItem;
import com.tcs.food.model.FoodOrder;
import com.tcs.food.model.OrderItem;
import com.tcs.food.model.OrderStatus;
import com.tcs.food.repository.FoodItemRepository;
import com.tcs.food.repository.FoodOrderRepository;

@Service
public class FoodOrderService {

    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private BookingServiceClient bookingServiceClient;

    @Transactional
    public FoodOrderResponseDTO placeOrder(FoodOrderRequestDTO requestDTO) {
        // 1. Validate booking
        BookingDTO booking = validateBooking(requestDTO.getBookingId());

        // 2. Create and save the order
        FoodOrder foodOrder = new FoodOrder();
        foodOrder.setBookingId(requestDTO.getBookingId());
        foodOrder.setCustomerId(requestDTO.getCustomerId());
        foodOrder.setOrderDate(LocalDateTime.now());
        foodOrder.setStatus(OrderStatus.PENDING);

        List<OrderItem> orderItems = new ArrayList<>();
        double totalAmount = 0.0;

        for (OrderItemDTO itemDTO : requestDTO.getItems()) {
            FoodItem foodItem = foodItemRepository.findById(itemDTO.getFoodItemId())
                    .orElseThrow(() -> new FoodItemNotFoundException("Food item not found with id: " + itemDTO.getFoodItemId()));

            if (!foodItem.isAvailable()) {
                throw new FoodItemNotFoundException("Food item is not available: " + foodItem.getName());
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setFoodItem(foodItem);
            orderItem.setQuantity(itemDTO.getQuantity());
            orderItem.setPrice(foodItem.getPrice() * itemDTO.getQuantity());
            orderItem.setOrder(foodOrder);
            orderItems.add(orderItem);

            totalAmount += orderItem.getPrice();
        }

        foodOrder.setOrderItems(orderItems);
        foodOrder.setTotalAmount(totalAmount);

        FoodOrder savedOrder = foodOrderRepository.save(foodOrder);
        savedOrder.setStatus(OrderStatus.CONFIRMED);
        savedOrder.setEstimatedDeliveryTime(LocalDateTime.now().plusHours(1)); // Example time
        foodOrderRepository.save(savedOrder);

        return mapToResponseDTO(savedOrder);
    }

    public FoodOrderResponseDTO getOrderById(Long orderId) {
        FoodOrder foodOrder = foodOrderRepository.findById(orderId)
                .orElseThrow(() -> new FoodItemNotFoundException("Order not found with id: " + orderId));
        return mapToResponseDTO(foodOrder);
    }

    public List<FoodOrderResponseDTO> getOrderHistory(Long customerId) {
        return foodOrderRepository.findByCustomerId(customerId).stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    private BookingDTO validateBooking(Long bookingId) {
        try {
            com.tcs.food.dto.ApiResponse<BookingDTO> response = bookingServiceClient.getBookingById(bookingId);
            if (response == null || response.getData() == null) {
                throw new InvalidBookingException("Booking not found with id: " + bookingId);
            }
            BookingDTO booking = response.getData();
            if (!"CONFIRMED".equalsIgnoreCase(booking.getStatus())) {
                throw new InvalidBookingException("Booking is not confirmed. Current status: " + booking.getStatus());
            }
            if (booking.getTravelDate().isBefore(LocalDate.now())) {
                throw new InvalidBookingException("Cannot order for a past travel date.");
            }
            return booking;
        } catch (Exception e) {
            throw new InvalidBookingException("Error validating booking: " + e.getMessage());
        }
    }

    private FoodOrderResponseDTO mapToResponseDTO(FoodOrder foodOrder) {
        FoodOrderResponseDTO responseDTO = new FoodOrderResponseDTO();
        responseDTO.setId(foodOrder.getId());
        responseDTO.setBookingId(foodOrder.getBookingId());
        responseDTO.setCustomerId(foodOrder.getCustomerId());
        responseDTO.setTotalAmount(foodOrder.getTotalAmount());
        responseDTO.setStatus(foodOrder.getStatus());
        responseDTO.setOrderDate(foodOrder.getOrderDate());
        responseDTO.setEstimatedDeliveryTime(foodOrder.getEstimatedDeliveryTime());

        List<OrderItemResponseDTO> itemResponseDTOs = foodOrder.getOrderItems().stream().map(orderItem -> {
            OrderItemResponseDTO itemDTO = new OrderItemResponseDTO();
            itemDTO.setFoodItemName(orderItem.getFoodItem().getName());
            itemDTO.setQuantity(orderItem.getQuantity());
            itemDTO.setPrice(orderItem.getPrice());
            return itemDTO;
        }).collect(Collectors.toList());

        responseDTO.setOrderItems(itemResponseDTOs);

        return responseDTO;
    }
}
