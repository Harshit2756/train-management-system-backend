# 🎟️ Booking Microservice API Documentation

**Base URL:**
`http://<host>:8083/api`

---

## 1. Create New Booking

**Endpoint:**  
`POST /booking`

**Description:**  
Create a new booking.

**Request:**

```json
{
  "customerId": 1,
  "trainId": 101,
  "fromStationId": 10,
  "toStationId": 20,
  "travelDate": "2024-07-01",
  "departureTime": "10:00:00",
  "arrivalTime": "18:00:00",
  "totalPassengers": 2,
  "passengerIds": [1001, 1002],
  "seatSelections": [
    {
      "passengerId": 1001,
      "seatType": "LOWER",
      "seatClass": "AC_2",
      "seatNumber": "A1-1",
      "fare": 1200.0
    },
    {
      "passengerId": 1002,
      "seatType": "UPPER",
      "seatClass": "AC_2",
      "seatNumber": "A1-2",
      "fare": 1200.0
    }
  ],
  "totalAmount": 2400.0
}
```

**Response:**

```json
{
  "bookingId": 1,
  "pnr": "PNR1234567890",
  "customerId": 1,
  "trainId": 101,
  "fromStationId": 10,
  "toStationId": 20,
  "travelDate": "2024-07-01",
  "departureTime": "10:00:00",
  "arrivalTime": "18:00:00",
  "totalPassengers": 2,
  "totalAmount": 2400.0,
  "status": "CONFIRMED",
  "bookingDate": "2024-06-01T12:00:00",
  "createdAt": "2024-06-01T12:00:00"
}
```

---

## 2. Get Booking Details

**Endpoint:**  
`GET /booking/{bookingId}`

**Description:**  
Get details of a booking by booking ID.

**Response:**
Same as above (Booking object).

---

## 3. Cancel Booking

**Endpoint:**  
`PUT /booking/{bookingId}/cancel`

**Description:**  
Cancel a booking by booking ID.

**Response:**
Same as above (Booking object with status `CANCELLED`).

---

## 4. Get Available Seats

**Endpoint:**  
`GET /seats/{trainId}/{date}`

**Description:**  
Get available seats for a train on a specific date.

**Response:**

```json
[
  {
    "seatId": 1,
    "bookingId": 1,
    "passengerId": 1001,
    "seatNumber": "A1-1",
    "seatType": "LOWER",
    "seatClass": "AC_2",
    "fare": 1200.0,
    "status": "CONFIRMED",
    "createdAt": "2024-06-01T12:00:00"
  }
]
```

---

## 5. Reserve Seats

**Endpoint:**  
`POST /seats/reserve`

**Description:**  
Reserve seats for passengers.

**Request:**

```json
[
  {
    "bookingId": 1,
    "passengerId": 1001,
    "seatNumber": "A1-1",
    "seatType": "LOWER",
    "seatClass": "AC_2",
    "fare": 1200.0,
    "status": "CONFIRMED",
    "createdAt": "2024-06-01T12:00:00"
  }
]
```

**Response:**
Same as above (array of Seat objects).

---

## 6. Get Booking Status by PNR

**Endpoint:**  
`GET /booking_status/{pnr}`

**Description:**  
Get the status of a booking by PNR.

**Response:**

```json
"CONFIRMED"
```

---

## 7. Get Ticket Details

**Endpoint:**  
`GET /fetch_ticket_details/{ticketId}`

**Description:**  
Get ticket details by ticket ID.

**Response:**

```json
{
  "ticketId": 1,
  "bookingId": 1,
  "passengerId": 1001,
  "startDate": "2024-07-01",
  "endDate": "2024-07-01",
  "status": "ACTIVE",
  "createdAt": "2024-06-01T12:00:00"
}
```

---

## 8. Process Payment

**Endpoint:**  
`POST /payment`

**Description:**  
Process a payment for a booking.

**Request:**

```json
{
  "bookingId": 1,
  "transactionId": "TXN123456",
  "amount": 2400.0,
  "paymentMethod": "UPI",
  "status": "PENDING",
  "paymentDate": "2024-06-01T12:00:00",
  "gatewayResponse": "Success"
}
```

**Response:**

```json
{
  "paymentId": 1,
  "bookingId": 1,
  "transactionId": "TXN123456",
  "amount": 2400.0,
  "paymentMethod": "UPI",
  "status": "SUCCESS",
  "paymentDate": "2024-06-01T12:00:00",
  "gatewayResponse": "Success"
}
```

---

## 9. Get Payment Status

**Endpoint:**  
`GET /payment/status/{transactionId}`

**Description:**  
Get the status of a payment by transaction ID.

**Response:**
Same as above (Payment object).

---

# 📄 Data Models

## BookingRequestDTO

```json
{
  "customerId": 1,
  "trainId": 101,
  "fromStationId": 10,
  "toStationId": 20,
  "travelDate": "2024-07-01",
  "departureTime": "10:00:00",
  "arrivalTime": "18:00:00",
  "totalPassengers": 2,
  "passengerIds": [1001, 1002],
  "seatSelections": [
    {
      "passengerId": 1001,
      "seatType": "LOWER",
      "seatClass": "AC_2",
      "seatNumber": "A1-1",
      "fare": 1200.0
    },
    {
      "passengerId": 1002,
      "seatType": "UPPER",
      "seatClass": "AC_2",
      "seatNumber": "A1-2",
      "fare": 1200.0
    }
  ],
  "totalAmount": 2400.0
}
```

## SeatSelectionDTO

```json
{
  "passengerId": 1001,
  "seatType": "LOWER",
  "seatClass": "AC_2",
  "seatNumber": "A1-1",
  "fare": 1200.0
}
```

## TicketDTO

```json
{
  "ticketId": 1,
  "bookingId": 1,
  "passengerId": 1001,
  "startDate": "2024-07-01",
  "endDate": "2024-07-01",
  "status": "ACTIVE"
}
```

## PaymentDTO

```json
{
  "paymentId": 1,
  "bookingId": 1,
  "transactionId": "TXN123456",
  "amount": 2400.0,
  "paymentMethod": "UPI",
  "status": "SUCCESS",
  "paymentDate": "2024-06-01T12:00:00",
  "gatewayResponse": "Success"
}
```

---

# 🛑 Error Responses

- **400 Bad Request:**
  ```json
  { "error": "Seat not available" }
  ```
- **404 Not Found:**
  ```json
  { "error": "Booking not found with id: ..." }
  ```
- **402 Payment Required:**
  ```json
  { "error": "Payment failed" }
  ```
- **500 Internal Server Error:**
  ```json
  { "error": "Internal server error: <details>" }
  ```

---

If you need documentation for more advanced booking flows, let me know!
