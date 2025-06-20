package com.tcs.train.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.train.dto.ApiResponse;
import com.tcs.train.dto.TrainDTO;
import com.tcs.train.service.TrainService;

@RestController
@RequestMapping("/api/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<TrainDTO>>> getAllTrains() {
        return ResponseEntity.ok(ApiResponse.success(trainService.getAllTrains()));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<TrainDTO>>> searchTrains(
            @RequestParam(required = false) String trainNumber,
            @RequestParam(required = false) String trainName,
            @RequestParam(required = false) String trainType
    ) {
        return ResponseEntity.ok(ApiResponse.success(
                trainService.searchTrains(trainNumber, trainName, trainType))
        );
    }

    @GetMapping("/{trainId}")
    public ResponseEntity<ApiResponse<TrainDTO>> getTrainById(@PathVariable Long trainId) {
        return ResponseEntity.ok(ApiResponse.success(trainService.getTrainById(trainId)));
    }
}
