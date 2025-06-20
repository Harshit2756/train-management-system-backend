# Train Microservice API Documentation

This document provides a comprehensive overview of the Train Microservice API, which is responsible for managing train data, schedules, and administrative operations.

## Base URL

All API endpoints are prefixed with `/api/train`.

## Standard Response Format

All API responses follow a standardized JSON format, which includes details about the success status, a message, and the requested data.

### Success Response

```json
{
    "success": true,
    "message": "Operation completed successfully",
    "data": {  }
}
```

### Error Response

```json
{
  "success": false,
  "message": "An error occurred",
  "data": null
}
```

---

## 1. Train Endpoints

These endpoints are used for searching and retrieving train information.

### 1.1 Get All Trains

- **Endpoint**: `GET /api/train`
- **Description**: Retrieves a list of all available trains.
- **Success Response (200 OK)**:
  ```json
  {
    "success": true,
    "message": "Operation completed successfully",
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
    ]
  }
  ```

### 1.2 Search Trains

- **Endpoint**: `GET /api/train/search`
- **Description**: Searches for trains based on query parameters.
- **Query Parameters**:
  - `trainNumber` (string, optional)
  - `trainName` (string, optional)
  - `trainType` (string, optional)
- **Success Response (200 OK)**: Returns a list of `TrainDTO` objects matching the search criteria.

### 1.3 Get Train by ID

- **Endpoint**: `GET /api/train/{trainId}`
- **Description**: Retrieves a specific train by its ID.
- **Success Response (200 OK)**: Returns the `TrainDTO` for the specified `trainId`.
- **Error Response (404 Not Found)**: If the train is not found.

---

## 2. Schedule Endpoints

These endpoints are used for retrieving train schedules.

### 2.1 Get Schedule for a Train on a Specific Date

- **Endpoint**: `GET /api/train/schedule/{trainId}/{date}`
- **Description**: Retrieves the schedule for a specific train on a given date.
- **Path Parameters**:
  - `trainId` (long): The ID of the train.
  - `date` (string): The travel date in `YYYY-MM-DD` format.
- **Success Response (200 OK)**:
  ```json
  {
    "success": true,
    "message": "Operation completed successfully",
    "data": {
      "scheduleId": 1,
      "trainId": 1,
      "travelDate": "2023-12-25",
      "availableAcSeats": 50,
      "availableSleeperSeats": 100,
      "availableGeneralSeats": 150,
      "status": "SCHEDULED"
    }
  }
  ```
- **Error Response (404 Not Found)**: If the schedule is not found.

---

## 3. Admin Endpoints

These endpoints are restricted to administrators and are used for managing train data and schedules.

### 3.1 Add a New Train

- **Endpoint**: `POST /api/train/admin/trains`
- **Description**: Adds a new train to the system.
- **Request Body**: `TrainDTO` object.
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
- **Success Response (200 OK)**: Returns the created `TrainDTO` object with its new `trainId`.

### 3.2 Update a Train

- **Endpoint**: `PUT /api/train/admin/trains/{trainId}`
- **Description**: Updates an existing train's details.
- **Request Body**: `TrainDTO` object with the fields to be updated.
- **Success Response (200 OK)**: Returns the updated `TrainDTO` object.
- **Error Response (404 Not Found)**: If the train to update is not found.

### 3.3 Delete a Train

- **Endpoint**: `DELETE /api/train/admin/trains/{trainId}`
- **Description**: Deletes a train from the system.
- **Success Response (200 OK)**:
  ```json
  {
    "success": true,
    "message": "Operation completed successfully",
    "data": "Train deleted successfully"
  }
  ```
- **Error Response (404 Not Found)**: If the train to delete is not found.

### 3.4 Bulk Upload Trains (CSV)

- **Endpoint**: `POST /api/train/admin/active_trains/upload`
- **Description**: Bulk uploads train data from a CSV file.
- **Request**: `multipart/form-data` with the file attached to the `file` key.
- **Success Response (200 OK)**: Returns a `BulkUploadResponseDTO`.
  ```json
  {
    "success": true,
    "message": "Operation completed successfully",
    "data": {
      "successCount": 50,
      "failureCount": 2,
      "errorMessages": ["Error on line 3", "Error on line 12"]
    }
  }
  ```

### 3.5 Bulk Upload Trains (JSON)

- **Endpoint**: `POST /api/train/admin/trains/bulkupload/json`
- **Description**: Bulk uploads train data from a JSON array.
- **Request Body**: A list of `TrainDTO` objects.
- **Success Response (200 OK)**: Returns a `BulkUploadResponseDTO`.

### 3.6 Create a Schedule

- **Endpoint**: `POST /api/train/admin/schedule`
- **Description**: Creates a new schedule for a train.
- **Request Body**: `ScheduleDTO` object.
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
- **Success Response (200 OK)**: Returns the created `ScheduleDTO` object.

### 3.7 Update a Schedule

- **Endpoint**: `PUT /api/train/admin/schedule/{scheduleId}`
- **Description**: Updates an existing schedule.
- **Request Body**: `ScheduleDTO` object with fields to be updated.
- **Success Response (200 OK)**: Returns the updated `ScheduleDTO` object.
- **Error Response (404 Not Found)**: If the schedule to update is not found.
