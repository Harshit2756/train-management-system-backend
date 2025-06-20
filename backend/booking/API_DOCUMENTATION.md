# Booking Service API Documentation

This document provides details about the API endpoints available in the Booking microservice.

## 1. Booking Endpoints

Base Path: `/api/booking`

### 1.1. Create Booking

- **Endpoint:** `POST /`
- **Description:** Creates a new booking for a train journey. It orchestrates seat allocation, payment processing, and ticket generation.
- **Request Body:** `BookingRequestDTO`
  ```json
  {
    "customerId": 1,
    "trainId": 101,
    "fromStationId": 1,
    "toStationId": 5,
    "travelDate": "2024-12-25",
    "departureTime": "10:00:00",
    "arrivalTime": "18:00:00",
    "totalPassengers": 2,
    "totalAmount": 1500.0,
    "passengers": [
      {
        "passengerId": 1,
        "seatNumber": "A1",
        "seatType": "WINDOW",
        "seatClass": "AC"
      },
      {
        "passengerId": 2,
        "seatNumber": "A2",
        "seatType": "AISLE",
        "seatClass": "AC"
      }
    ]
  }
  ```
- **Responses:**
  - `200 OK`: Returns a `BookingResponseDTO` with the details of the created booking, including allocated seats and generated tickets.
  - `404 Not Found`: If the specified train is not found.
  - `400 Bad Request`: If the input is invalid (e.g., zero passengers).
  - `500 Internal Server Error`: For payment failures or other server-side issues.

### 1.2. Get Booking Details

- **Endpoint:** `GET /{bookingId}`
- **Description:** Retrieves the details of a specific booking by its ID.
- **Path Variable:**
  - `bookingId` (Long): The unique identifier of the booking.
- **Responses:**
  - `200 OK`: Returns the `Booking` object.
  - `404 Not Found`: If no booking is found with the given ID.

### 1.3. Cancel Booking

- **Endpoint:** `PUT /{bookingId}/cancel`
- **Description:** Cancels an existing booking.
- **Path Variable:**
  - `bookingId` (Long): The unique identifier of the booking to be canceled.
- **Responses:**
  - `200 OK`: Returns the updated `Booking` object with the `CANCELLED` status.
  - `404 Not Found`: If no booking is found with the given ID.

---

## 2. Booking Status Endpoint

Base Path: `/api`

### 2.1. Get Booking Status by PNR

- **Endpoint:** `GET /booking_status/{pnr}`
- **Description:** Fetches the current status of a booking using the PNR number.
- **Path Variable:**
  - `pnr` (String): The Passenger Name Record number of the booking.
- **Responses:**
  - `200 OK`: Returns the booking status as a string (e.g., "CONFIRMED", "CANCELLED", "PENDING"). Returns "NOT_FOUND" if the PNR does not exist.

---

## 3. Payment Endpoints

Base Path: `/api`

### 3.1. Process Payment

- **Endpoint:** `POST /payment`
- **Description:** Processes a payment for a booking.
- **Request Body:** `Payment` object
  ```json
  {
    "bookingId": 1,
    "amount": 1500.0,
    "paymentMethod": "UPI"
  }
  ```
- **Responses:**
  - `200 OK`: Returns the `Payment` object with the transaction details and status.

### 3.2. Get Payment Status

- **Endpoint:** `GET /payment/status/{transactionId}`
- **Description:** Retrieves the status of a payment by its transaction ID.
- **Path Variable:**
  - `transactionId` (String): The unique identifier of the payment transaction.
- **Responses:**
  - `200 OK`: Returns the `Payment` object.

---

## 4. Ticket Endpoint

Base Path: `/api`

### 4.1. Get Ticket Details

- **Endpoint:** `GET /fetch_ticket_details/{ticketId}`
- **Description:** Retrieves the details of a specific ticket by its ID.
- **Path Variable:**
  - `ticketId` (Long): The unique identifier of the ticket.
- **Responses:**
  - `200 OK`: Returns the `Ticket` object.
  - `404 Not Found`: If no ticket is found with the given ID.
