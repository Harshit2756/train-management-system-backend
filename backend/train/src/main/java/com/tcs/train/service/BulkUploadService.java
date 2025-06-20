package com.tcs.train.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tcs.train.dto.BulkUploadResponseDTO;
import com.tcs.train.dto.TrainDTO;

@Service
public class BulkUploadService {

  @Autowired
  private TrainService trainService;

  @Autowired
  private CsvParsingService csvParsingService;

  public BulkUploadResponseDTO bulkUploadTrains(MultipartFile file) {
    int successCount = 0;
    int failureCount = 0;
    List<String> errorMessages = new ArrayList<>();
    try (
      BufferedReader reader = new BufferedReader(
        new InputStreamReader(file.getInputStream())
      )
    ) {
      List<TrainDTO> trainDTOs = csvParsingService.parseTrainsCsv(reader);
      for (TrainDTO dto : trainDTOs) {
        try {
          trainService.addTrain(dto);
          successCount++;
        } catch (Exception e) {
          failureCount++;
          errorMessages.add(
            "Failed to add train: " +
            dto.getTrainNumber() +
            ", reason: " +
            e.getMessage()
          );
        }
      }
    } catch (Exception e) {
      failureCount++;
      errorMessages.add("Failed to process file: " + e.getMessage());
    }
    BulkUploadResponseDTO response = new BulkUploadResponseDTO(failureCount, failureCount);
    response.setSuccessCount(successCount);
    response.setFailureCount(failureCount);
    response.setErrorMessages(errorMessages);
    return response;
  }
}
