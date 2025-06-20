# Food Service API Documentation

This document provides details about the API endpoints available in the Food microservice.

## 1. Food Item Endpoints

Base Path: `/api/food/items`

### 1.1. Get Available Food Items

- **Endpoint:** `GET /`
- **Description:** Retrieves a list of all food items that are currently available for ordering.
- **Responses:**
  - `200 OK`: Returns a list of `FoodItem` objects.

### 1.2. Add a New Food Item

- **Endpoint:** `POST /`
- **Description:** Adds a new food item to the menu. This is typically an admin-only operation.
- **Request Body:** `FoodItem`
  ```json
  {
    "name": "Samosa",
    "description": "A fried pastry with a savory filling, including ingredients such as spiced potatoes, onions, and peas.",
    "price": 50.0,
    "available": true
  }
  ```
- **Responses:**
  - `200 OK`: Returns the newly created `FoodItem` object.

---

## 2. Food Order Endpoints

Base Path: `/api/food/orders`

### 2.1. Place a Food Order

- **Endpoint:** `POST /`
- **Description:** Places a new food order for a passenger with a valid, upcoming train booking.
- **Request Body:** `FoodOrderRequestDTO`
  ```json
  {
    "customerId": 1,
    "bookingId": 123,
    "items": [
      {
        "foodItemId": 1,
        "quantity": 2
      },
      {
        "foodItemId": 3,
        "quantity": 1
      }
    ]
  }
  ```
- **Responses:**
  - `200 OK`: Returns a `FoodOrderResponseDTO` with the details of the newly created order.
  - `400 Bad Request`: If the booking ID is invalid, the booking is not confirmed, or the travel date is in the past.
  - `404 Not Found`: If a specified food item is not found or is unavailable.

### 2.2. Get Order by ID

- **Endpoint:** `GET /{orderId}`
- **Description:** Retrieves the details of a specific food order by its ID.
- **Path Variable:**
  - `orderId` (Long): The unique identifier of the food order.
- **Responses:**
  - `200 OK`: Returns a `FoodOrderResponseDTO`.
  - `404 Not Found`: If no order is found with the given ID.

### 2.3. Get Order History for a Customer

- **Endpoint:** `GET /history/{customerId}`
- **Description:** Retrieves the entire food order history for a specific customer.
- **Path Variable:**
  - `customerId` (Long): The unique identifier of the customer.
- **Responses:**
  - `200 OK`: Returns a list of `FoodOrderResponseDTO` objects.
