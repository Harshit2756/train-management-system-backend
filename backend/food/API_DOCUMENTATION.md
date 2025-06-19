# Food & Pantry Service API Documentation

Base URL: `/api`

## Food Menu

### Get All Food Items

- **GET** `/food_cart`
- **Response:** 200 OK

```
[
  {
    "foodItemId": 1,
    "itemName": "Paneer Tikka",
    "description": "Spicy grilled paneer cubes",
    "category": "SNACKS",
    "price": 120.0,
    "imageUrl": "http://...",
    "isVegetarian": true,
    "isAvailable": true,
    "preparationTime": 15
  },
  ...
]
```

### Get Food Items for Specific Train

- **GET** `/food_cart/{trainId}`
- **Response:** 200 OK (same as above)

### Add New Food Item (Admin)

- **POST** `/food_cart/admin/food_items`
- **Request Body:**

```
{
  "itemName": "Paneer Tikka",
  "description": "Spicy grilled paneer cubes",
  "category": "SNACKS",
  "price": 120.0,
  "imageUrl": "http://...",
  "isVegetarian": true,
  "isAvailable": true,
  "preparationTime": 15
}
```

- **Response:** 201 Created (returns created item)

### Update Food Item (Admin)

- **PUT** `/food_cart/admin/food_items/{itemId}`
- **Request Body:** (same as above)
- **Response:** 200 OK (returns updated item)

### Delete Food Item (Admin)

- **DELETE** `/food_cart/admin/food_items/{itemId}`
- **Response:** 204 No Content

## Food Orders

### Place Food Order

- **POST** `/food_order`
- **Request Body:**

```
{
  "orderNumber": "ORD123456",
  "customerId": 1,
  "pnr": "PNR123",
  "seatNumber": "A1-12",
  "trainId": 101,
  "totalAmount": 250.0,
  "specialInstructions": "Less spicy"
}
```

- **Response:** 201 Created (returns created order)

### Get Order Details

- **GET** `/food_order/{orderId}`
- **Response:** 200 OK (returns order details)

### Cancel Food Order

- **PUT** `/food_order/{orderId}/cancel`
- **Response:** 204 No Content

### Get Customer's Food Orders

- **GET** `/food_order/customer/{customerId}`
- **Response:** 200 OK (returns list of orders)

## Pantry Management (Admin)

### Add Pantry

- **POST** `/admin/pantry`
- **Request Body:**

```
{
  "trainId": 101,
  "pantryName": "Main Pantry",
  "contactNumber": "9876543210",
  "isActive": true,
  "serviceStartTime": "07:00:00",
  "serviceEndTime": "22:00:00"
}
```

- **Response:** 201 Created (returns created pantry)

### Get All Pantries

- **GET** `/admin/pantries`
- **Response:** 200 OK (returns list of pantries)

### Update Food Inventory

- **PUT** `/admin/inventory`
- **Request Body:**

```
{
  "pantryId": 1,
  "foodItemId": 2,
  "availableQuantity": 50,
  "inventoryDate": "2024-06-01",
  "lastUpdated": "2024-06-01T10:00:00"
}
```

- **Response:** 200 OK (returns updated inventory)

### Get Pantry by ID

- **GET** `/admin/pantry/{id}`
- **Response:** 200 OK (returns pantry details) or 404 Not Found

### Get Food Inventory by Pantry

- **GET** `/food_order/inventory/{pantryId}`
- **Response:** 200 OK (returns list of inventory items)

## Error Codes

- 400 Bad Request: Invalid input or order
- 404 Not Found: Resource not found
- 500 Internal Server Error: Unexpected error
