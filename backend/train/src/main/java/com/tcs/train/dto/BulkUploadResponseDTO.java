package com.tcs.train.dto;

import java.util.List;

public class BulkUploadResponseDTO {

  private int successCount;
  private int failureCount;
  private List<String> errorMessages;

  public BulkUploadResponseDTO() {
  }

  public int getSuccessCount() {
    return successCount;
  }

  public void setSuccessCount(int successCount) {
    this.successCount = successCount;
  }

  public int getFailureCount() {
    return failureCount;
  }

  public void setFailureCount(int failureCount) {
    this.failureCount = failureCount;
  }

  public List<String> getErrorMessages() {
    return errorMessages;
  }

  public void setErrorMessages(List<String> errorMessages) {
    this.errorMessages = errorMessages;
  }

  
}
