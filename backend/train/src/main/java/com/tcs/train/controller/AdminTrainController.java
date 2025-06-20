package com.tcs.train.controller;

import java.util.List;

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

import com.tcs.train.dto.ApiResponse;
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
    public ResponseEntity<ApiResponse<TrainDTO>> addTrain(@RequestBody TrainDTO dto) {
        return ResponseEntity.ok(ApiResponse.success(trainService.addTrain(dto)));
    }

    @PutMapping("/trains/{trainId}")
    public ResponseEntity<ApiResponse<TrainDTO>> updateTrain(
            @PathVariable Long trainId,
            @RequestBody TrainDTO dto
    ) {
        return ResponseEntity.ok(ApiResponse.success(trainService.updateTrain(trainId, dto)));
    }

    @DeleteMapping("/trains/{trainId}")
    public ResponseEntity<ApiResponse<String>> deleteTrain(@PathVariable Long trainId) {
        trainService.deleteTrain(trainId);
        return ResponseEntity.ok(ApiResponse.success("Train deleted successfully"));
    }

    @PostMapping("/trains/bulkupload/json")
    public ResponseEntity<ApiResponse<BulkUploadResponseDTO>> bulkUploadFromJson(@RequestBody List<TrainDTO> trainDTOs) {
        BulkUploadResponseDTO response = trainService.bulkUploadTrainsFromJson(trainDTOs);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @PostMapping("/active_trains/upload")
    public ResponseEntity<ApiResponse<BulkUploadResponseDTO>> bulkUpload(
            @RequestParam("file") MultipartFile file
    ) {
        BulkUploadResponseDTO response = bulkUploadService.bulkUploadTrains(file);
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
