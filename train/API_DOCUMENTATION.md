# 🚄 Train Microservice API Documentation

**Base URL:**
`http://<host>:8082/api`

---

## 1. Get All Trains

**Endpoint:**  
`GET /trains`

**Description:**  
Fetch all available trains.

**Response:**

```json
[
  {
    "trainId": 1,
    "trainNumber": "12345",
    "trainName": "Express",
    "trainType": "Superfast",
    "totalSeats": 1000,
    "acSeats": 200,
    "sleeperSeats": 500,
    "generalSeats": 300,
    "status": "ACTIVE"
  }
]
```

---

## 2. Search Trains

**Endpoint:**  
`GET /trains/search?trainNumber={trainNumber}&trainName={trainName}&trainType={trainType}`

**Description:**  
Search trains by number, name, or type. All parameters are optional.

**Response:**  
Same as above (array of TrainDTO).

---

## 3. Get Train by ID

**Endpoint:**  
`GET /trains/{trainId}`

**Description:**  
Fetch details of a specific train.

**Response:**  
Same as above (single TrainDTO).

---

## 4. Add New Train (Admin)

**Endpoint:**  
`POST /admin/trains`

**Description:**  
Add a new train.

**Request:**

```json
{
  "trainNumber": "12345",
  "trainName": "Express",
  "trainType": "Superfast",
  "totalSeats": 1000,
  "acSeats": 200,
  "sleeperSeats": 500,
  "generalSeats": 300,
  "status": "ACTIVE"
}
```

**Response:**  
Created TrainDTO (with `trainId`).

---

## 5. Update Train (Admin)

**Endpoint:**  
`PUT /admin/trains/{trainId}`

**Description:**  
Update details of an existing train.

**Request:**  
Same as Add New Train.

**Response:**  
Updated TrainDTO.

---

## 6. Delete Train (Admin)

**Endpoint:**  
`DELETE /admin/trains/{trainId}`

**Description:**  
Delete a train.

**Response:**

```json
"Train deleted successfully"
```

---

## 7. Bulk Upload Trains (Admin)

**Endpoint:**  
`POST /admin/active_trains/upload`

**Description:**  
Bulk upload trains via CSV file.

**Request:**

- `multipart/form-data` with a file field named `file`
- CSV header:  
  `trainNumber,trainName,trainType,totalSeats,acSeats,sleeperSeats,generalSeats,status`

**Response:**

```json
{
  "successCount": 5,
  "failureCount": 1,
  "errorMessages": [
    "Failed to add train: 54321, reason: Duplicate train number"
  ]
}
```

---

## 8. Get Train Schedule for a Date

**Endpoint:**  
`GET /schedule/{trainId}/{date}`

**Description:**  
Get the schedule for a specific train on a specific date.

**Path Variables:**

- `trainId`: Train ID
- `date`: Date in `YYYY-MM-DD` format

**Response:**

```json
{
  "scheduleId": 10,
  "trainId": 1,
  "travelDate": "2024-07-01",
  "availableAcSeats": 100,
  "availableSleeperSeats": 300,
  "availableGeneralSeats": 200,
  "status": "SCHEDULED"
}
```

---

## 9. Create Schedule (Admin)

**Endpoint:**  
`POST /admin/schedule`

**Description:**  
Create a new schedule for a train.

**Request:**

```json
{
  "trainId": 1,
  "travelDate": "2024-07-01",
  "availableAcSeats": 100,
  "availableSleeperSeats": 300,
  "availableGeneralSeats": 200,
  "status": "SCHEDULED"
}
```

**Response:**  
Created ScheduleDTO (with `scheduleId`).

---

## 10. Update Schedule (Admin)

**Endpoint:**  
`PUT /admin/schedule/{scheduleId}`

**Description:**  
Update an existing schedule.

**Request:**  
Same as Create Schedule.

**Response:**  
Updated ScheduleDTO.

---

# 📄 Data Models

## TrainDTO

```json
{
  "trainId": 1,
  "trainNumber": "12345",
  "trainName": "Express",
  "trainType": "Superfast",
  "totalSeats": 1000,
  "acSeats": 200,
  "sleeperSeats": 500,
  "generalSeats": 300,
  "status": "ACTIVE"
}
```

## ScheduleDTO

```json
{
  "scheduleId": 10,
  "trainId": 1,
  "travelDate": "2024-07-01",
  "availableAcSeats": 100,
  "availableSleeperSeats": 300,
  "availableGeneralSeats": 200,
  "status": "SCHEDULED"
}
```

## BulkUploadResponseDTO

```json
{
  "successCount": 5,
  "failureCount": 1,
  "errorMessages": [
    "Failed to add train: 54321, reason: Duplicate train number"
  ]
}
```

---

# 🛑 Error Responses

- **404 Not Found:**
  ```json
  { "error": "Train not found with id: 99" }
  ```
- **400 Bad Request:**
  ```json
  { "error": "Invalid CSV format" }
  ```
- **409 Conflict:**
  ```json
  { "error": "Schedule conflict" }
  ```
- **500 Internal Server Error:**
  ```json
  { "error": "Internal server error: <details>" }
  ```

---

If you need documentation for routes, stations, or want to add authentication, let me know!
