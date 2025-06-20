# Train Microservice API Documentation

This document provides a comprehensive overview of the Train Microservice API, which is responsible for managing train data, schedules, and administrative operations.

## Base URL

All API endpoints are prefixed with `/api`.

## Standard Response Format

All API responses follow a standardized JSON format, which includes details about the success status, a message, a corresponding code, and the requested data.

### Success Response

```json
{
  "success": true,
  "message": "Operation completed successfully",
  "code": "SUCCESS",
  "data": {
    // Response data will be here
  },
  "timestamp": "2023-10-27T10:00:00.000Z"
}
```

### Error Response

```json
{
  "success": false,
  "message": "An error occurred",
  "code": "ERROR_CODE",
  "data": null,
  "timestamp": "2023-10-27T10:00:00.000Z"
}
```

---

## 1. Train Endpoints

These endpoints are used for searching and retrieving train information.

### 1.1 Get All Trains

- **Endpoint**: `GET /api/trains`
- **Description**: Retrieves a list of all available trains.
- **Success Response (200 OK)**:
  ```json
  {
    "success": true,
    "message": "Operation completed successfully",
    "code": "SUCCESS",
    "data": [
      {
        "trainId": 1,
        "trainNumber": "1202",
        "trainName": "Express",
        "trainType": "Superfast",
        "totalSeats": 500,
        "acSeats": 100,
        "sleeperSeats": 200,
        "generalSeats": 200,
        "status": "ACTIVE"
      }
    ],
    "timestamp": "2023-10-27T10:00:00.000Z"
  }
  ```

### 1.2 Search Trains

- **Endpoint**: `GET /api/trains/search`
- **Description**: Searches for trains based on query parameters.
- **Query Parameters**:
  - `trainNumber` (string, optional)
  - `trainName` (string, optional)
  - `trainType` (string, optional)
- **Success Response (200 OK)**:
  ```json
  {
    "success": true,
    "message": "Operation completed successfully",
    "code": "SUCCESS",
    "data": [
      {
        "trainId": 1,
        "trainNumber": "1202",
        "trainName": "Express",
        "trainType": "Superfast",
        "totalSeats": 500,
        "acSeats": 100,
        "sleeperSeats": 200,
        "generalSeats": 200,
        "status": "ACTIVE"
      }
    ],
    "timestamp": "2023-10-27T10:00:00.000Z"
  }
  ```

### 1.3 Get Train by ID

- **Endpoint**: `GET /api/trains/{trainId}`
- **Description**: Retrieves a specific train by its ID.
- **Success Response (200 OK)**:
  ```json
  {
    "success": true,
    "message": "Operation completed successfully",
    "code": "SUCCESS",
    "data": {
      "trainId": 1,
      "trainNumber": "1202",
      "trainName": "Express",
      "trainType": "Superfast",
      "totalSeats": 500,
      "acSeats": 100,
      "sleeperSeats": 200,
      "generalSeats": 200,
      "status": "ACTIVE"
    },
    "timestamp": "2023-10-27T10:00:00.000Z"
  }
  ```
- **Error Response (404 Not Found)**: If the train is not found.

---

## 2. Schedule Endpoints

These endpoints are used for retrieving train schedules.

### 2.1 Get Schedule for a Train on a Specific Date

- **Endpoint**: `GET /api/schedule/{trainId}/{date}`
- **Description**: Retrieves the schedule for a specific train on a given date.
- **Path Parameters**:
  - `trainId` (long): The ID of the train.
  - `date` (string): The travel date in `YYYY-MM-DD` format.
- **Success Response (200 OK)**:
  ```json
  {
    "success": true,
    "message": "Operation completed successfully",
    "code": "SUCCESS",
    "data": {
      "scheduleId": 1,
      "trainId": 1,
      "travelDate": "2023-12-25",
      "availableAcSeats": 50,
      "availableSleeperSeats": 100,
      "availableGeneralSeats": 150,
      "status": "SCHEDULED"
    },
    "timestamp": "2023-10-27T10:00:00.000Z"
  }
  ```
- **Error Response (404 Not Found)**: If the schedule is not found.

---

## 3. Admin Endpoints

These endpoints are restricted to administrators and are used for managing train data and schedules.

### 3.1 Add a New Train

- **Endpoint**: `POST /api/admin/trains`
- **Description**: Adds a new train to the system.
- **Request Body**:
  ```json
  {
    "trainNumber": "1203",
    "trainName": "New Express",
    "trainType": "Express",
    "totalSeats": 600,
    "acSeats": 150,
    "sleeperSeats": 250,
    "generalSeats": 200,
    "status": "ACTIVE"
  }
  ```
- **Success Response (200 OK)**:
  ```json
  {
    "success": true,
    "message": "Operation completed successfully",
    "code": "SUCCESS",
    "data": {
      "trainId": 2
      // ... other train details ...
    },
    "timestamp": "2023-10-27T10:00:00.000Z"
  }
  ```

### 3.2 Update a Train

- **Endpoint**: `PUT /api/admin/trains/{trainId}`
- **Description**: Updates an existing train's details.
- **Request Body**:
  ```json
  {
    "trainNumber": "1203",
    "trainName": "Updated Express",
    "trainType": "Superfast"
    // ... other fields ...
  }
  ```
- **Success Response (200 OK)**: Returns the updated train object.
- **Error Response (404 Not Found)**: If the train to update is not found.

### 3.3 Delete a Train

- **Endpoint**: `DELETE /api/admin/trains/{trainId}`
- **Description**: Deletes a train from the system.
- **Success Response (200 OK)**:
  ```json
  {
    "success": true,
    "message": "Train deleted successfully",
    "code": "SUCCESS",
    "data": "Train deleted successfully",
    "timestamp": "2023-10-27T10:00:00.000Z"
  }
  ```
- **Error Response (404 Not Found)**: If the train to delete is not found.

### 3.4 Bulk Upload Trains (CSV)

- **Endpoint**: `POST /api/admin/active_trains/upload`
- **Description**: Bulk uploads train data from a CSV file.
- **Request**: `multipart/form-data` with the file attached to the `file` key.
- **Success Response (200 OK)**:
  ```json
  {
    "success": true,
    "message": "Operation completed successfully",
    "code": "SUCCESS",
    "data": {
      "successCount": 50,
      "failureCount": 2,
      "errorMessages": ["Error on line 3", "Error on line 12"]
    },
    "timestamp": "2023-10-27T10:00:00.000Z"
  }
  ```

### 3.5 Bulk Upload Trains (JSON)

- **Endpoint**: `POST /api/admin/trains/bulkupload/json`
- **Description**: Bulk uploads train data from a JSON array.
- **Request Body**:
  ```json
  [
    {
      "trainNumber": "1204",
      "trainName": "JSON Express 1",
      "trainType": "Express",
      "totalSeats": 500,
      "acSeats": 100,
      "sleeperSeats": 200,
      "generalSeats": 200,
      "status": "ACTIVE"
    },
    {
      "trainNumber": "1205",
      "trainName": "JSON Express 2",
      "trainType": "Superfast",
      "totalSeats": 600,
      "acSeats": 150,
      "sleeperSeats": 250,
      "generalSeats": 200,
      "status": "ACTIVE"
    }
  ]
  ```
- **Success Response (200 OK)**:
  ```json
  {
    "success": true,
    "message": "Operation completed successfully",
    "code": "SUCCESS",
    "data": {
      "successCount": 2,
      "failureCount": 0,
      "errorMessages": []
    },
    "timestamp": "2023-10-27T10:00:00.000Z"
  }
  ```

### 3.6 Create a Schedule

- **Endpoint**: `POST /api/admin/schedule`
- **Description**: Creates a new schedule for a train.
- **Request Body**:
  ```json
  {
    "trainId": 1,
    "travelDate": "2024-01-10",
    "availableAcSeats": 100,
    "availableSleeperSeats": 200,
    "availableGeneralSeats": 200,
    "status": "SCHEDULED"
  }
  ```
- **Success Response (200 OK)**: Returns the created schedule object.

### 3.7 Update a Schedule

- **Endpoint**: `PUT /api/admin/schedule/{scheduleId}`
- **Description**: Updates an existing schedule.
- **Request Body**:
  ```json
  {
    "availableAcSeats": 90,
    "status": "RESCHEDULED"
    // ... other fields ...
  }
  ```
- **Success Response (200 OK)**: Returns the updated schedule object.
- **Error Response (404 Not Found)**: If the schedule to update is not found.
