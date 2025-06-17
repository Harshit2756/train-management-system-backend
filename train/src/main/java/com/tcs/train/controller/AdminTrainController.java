package com.tcs.train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tcs.train.dto.BulkUploadResponseDTO;
import com.tcs.train.dto.TrainDTO;
import com.tcs.train.service.BulkUploadService;
import com.tcs.train.service.TrainService;

@RestController
@RequestMapping("/api/admin")
public class AdminTrainController {

  @Autowired
  private TrainService trainService;

  @Autowired
  private BulkUploadService bulkUploadService;

  @PostMapping("/trains")
  public ResponseEntity<TrainDTO> addTrain(@RequestBody TrainDTO dto) {
    return ResponseEntity.ok(trainService.addTrain(dto));
  }

  @PutMapping("/trains/{trainId}")
  public ResponseEntity<TrainDTO> updateTrain(
    @PathVariable Long trainId,
    @RequestBody TrainDTO dto
  ) {
    return ResponseEntity.ok(trainService.updateTrain(trainId, dto));
  }

  @DeleteMapping("/trains/{trainId}")
  public ResponseEntity<String> deleteTrain(@PathVariable Long trainId) {
    trainService.deleteTrain(trainId);
    return ResponseEntity.ok("Train deleted successfully");
  }

  @PostMapping("/active_trains/upload")
  public ResponseEntity<BulkUploadResponseDTO> bulkUpload(
    @RequestParam("file") MultipartFile file
  ) {
    BulkUploadResponseDTO response = bulkUploadService.bulkUploadTrains(file);
    return ResponseEntity.ok(response);
  }
}
