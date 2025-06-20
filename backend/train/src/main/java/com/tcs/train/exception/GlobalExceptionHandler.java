package com.tcs.train.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tcs.train.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Hidden;

@RestControllerAdvice
@Hidden
public class GlobalExceptionHandler {

    @ExceptionHandler(TrainNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleTrainNotFoundException(
            TrainNotFoundException ex
    ) {
        return new ResponseEntity<>(ApiResponse.error("TRAIN_NOT_FOUND", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCsvFormatException.class)
    public ResponseEntity<ApiResponse<Object>> handleInvalidCsvFormatException(
            InvalidCsvFormatException ex
    ) {
        return new ResponseEntity<>(ApiResponse.error("INVALID_CSV_FORMAT", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ScheduleConflictException.class)
    public ResponseEntity<ApiResponse<Object>> handleScheduleConflictException(
            ScheduleConflictException ex
    ) {
        return new ResponseEntity<>(ApiResponse.error("SCHEDULE_CONFLICT", ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGenericException(Exception ex) {
        return new ResponseEntity<>(
                ApiResponse.error("INTERNAL_SERVER_ERROR", "Internal server error: " + ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
