package com.tcs.booking.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcs.booking.dto.ApiResponse;
import com.tcs.booking.dto.TrainDTO;

@FeignClient(name = "train-service", path = "/api/trains")
public interface TrainServiceClient {

    @GetMapping("/{trainId}")
    ApiResponse<TrainDTO> getTrainById(@PathVariable("trainId") Long trainId);

}
