package com.tcs.train.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(TrainNotFoundException.class)
  public ResponseEntity<String> handleTrainNotFoundException(
    TrainNotFoundException ex
  ) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(InvalidCsvFormatException.class)
  public ResponseEntity<String> handleInvalidCsvFormatException(
    InvalidCsvFormatException ex
  ) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ScheduleConflictException.class)
  public ResponseEntity<String> handleScheduleConflictException(
    ScheduleConflictException ex
  ) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleGenericException(Exception ex) {
    return new ResponseEntity<>(
      "Internal server error: " + ex.getMessage(),
      HttpStatus.INTERNAL_SERVER_ERROR
    );
  }
}
