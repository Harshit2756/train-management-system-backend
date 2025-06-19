# 👤 User Microservice API Documentation

**Base URL:**
`http://<host>:8081/api`

---

## 1. Customer Registration

**Endpoint:**  
`POST /register`

**Description:**  
Register a new customer.

**Request:**

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123",
  "contactNumber": "1234567890",
  "address": "123 Main St"
}
```

**Response:**

```json
"User registered successfully"
```

---

## 2. Admin Registration

**Endpoint:**  
`POST /admin/register`

**Description:**  
Register a new admin.

**Request:**

```json
{
  "name": "Admin User",
  "email": "admin@example.com",
  "password": "adminpass",
  "contactNumber": "9876543210",
  "address": "456 Admin Ave"
}
```

**Response:**

```json
"Admin registered successfully"
```

---

## 3. User Authentication (Login)

**Endpoint:**  
`POST /login`

**Description:**  
Authenticate a user and receive a JWT token.

**Request:**

```json
{
  "email": "john@example.com",
  "password": "password123"
}
```

**Response:**

```json
"<JWT_TOKEN>"
```

---

## 4. Get User Profile

**Endpoint:**  
`GET /profile?email={email}`

**Description:**  
Get the profile of a user by email.

**Response:**

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "contactNumber": "1234567890",
  "address": "123 Main St"
}
```

---

## 5. Update User Profile

**Endpoint:**  
`PUT /profile?email={email}`

**Description:**  
Update the profile of a user by email.

**Request:**

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "contactNumber": "1234567890",
  "address": "123 Main St"
}
```

**Response:**

```json
"Profile updated successfully"
```

---

## 6. Get Booking History

**Endpoint:**  
`GET /history?email={email}`

**Description:**  
Get the booking history for a user (dummy data).

**Response:**

```json
["Booking1", "Booking2"]
```

---

## 7. Get Upcoming Journeys

**Endpoint:**  
`GET /journey?email={email}`

**Description:**  
Get the upcoming journeys for a user (dummy data).

**Response:**

```json
["Journey1", "Journey2"]
```

---

## 8. Add Passenger Details

**Endpoint:**  
`POST /passenger_details?customerId={customerId}`

**Description:**  
Add passenger details for a customer.

**Request:**

```json
{
  "fullName": "Jane Doe",
  "age": 30,
  "gender": "FEMALE",
  "idProofType": "Aadhar",
  "idProofNumber": "XXXX-YYYY-ZZZZ",
  "nationality": "Indian"
}
```

**Response:**

```json
"Passenger added successfully"
```

---

## 9. Get Passenger Details

**Endpoint:**  
`GET /passenger_details?customerId={customerId}`

**Description:**  
Get all passenger details for a customer.

**Response:**

```json
[
  {
    "fullName": "Jane Doe",
    "age": 30,
    "gender": "FEMALE",
    "idProofType": "Aadhar",
    "idProofNumber": "XXXX-YYYY-ZZZZ",
    "nationality": "Indian"
  }
]
```

---

## 10. Update Passenger Details

**Endpoint:**  
`PUT /passenger_details/{id}`

**Description:**  
Update passenger details by passenger ID.

**Request:**

```json
{
  "fullName": "Jane Doe",
  "age": 31,
  "gender": "FEMALE",
  "idProofType": "Aadhar",
  "idProofNumber": "XXXX-YYYY-ZZZZ",
  "nationality": "Indian"
}
```

**Response:**

```json
"Passenger updated successfully"
```

---

## 11. Delete Passenger Details

**Endpoint:**  
`DELETE /passenger_details/{id}`

**Description:**  
Delete passenger details by passenger ID.

**Response:**

```json
"Passenger deleted successfully"
```

---

# 📄 Data Models

## UserRegistrationDTO / AdminRegistrationDTO

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123",
  "contactNumber": "1234567890",
  "address": "123 Main St"
}
```

## LoginDTO

```json
{
  "email": "john@example.com",
  "password": "password123"
}
```

## UserProfileDTO

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "contactNumber": "1234567890",
  "address": "123 Main St"
}
```

## PassengerDetailsDTO

```json
{
  "fullName": "Jane Doe",
  "age": 30,
  "gender": "FEMALE",
  "idProofType": "Aadhar",
  "idProofNumber": "XXXX-YYYY-ZZZZ",
  "nationality": "Indian"
}
```

---

# 🛑 Error Responses

- **400 Bad Request:**
  ```json
  { "error": "Invalid email format: ..." }
  ```
- **409 Conflict:**
  ```json
  { "error": "User already exists with email: ..." }
  ```
- **404 Not Found:**
  ```json
  { "error": "Passenger not found with id: ..." }
  ```
- **500 Internal Server Error:**
  ```json
  { "error": "Internal server error: <details>" }
  ```

---

If you need documentation for admin/dashboard or want to add authentication/authorization details, let me know!
