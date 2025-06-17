package com.tcs.train.service;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tcs.train.dto.TrainDTO;
import com.tcs.train.model.TrainStatus;

@Service
public class CsvParsingService {

  public List<TrainDTO> parseTrainsCsv(BufferedReader reader) throws Exception {
    List<TrainDTO> trains = new ArrayList<>();
    String line;
    boolean isFirst = true;
    while ((line = reader.readLine()) != null) {
      if (isFirst) {
        isFirst = false;
        continue;
      } // skip header
      String[] parts = line.split(",");
      if (parts.length < 8) continue;
      TrainDTO dto = new TrainDTO();
      dto.setTrainNumber(parts[0]);
      dto.setTrainName(parts[1]);
      dto.setTrainType(parts[2]);
      dto.setTotalSeats(Integer.valueOf(parts[3]));
      dto.setAcSeats(Integer.valueOf(parts[4]));
      dto.setSleeperSeats(Integer.valueOf(parts[5]));
      dto.setGeneralSeats(Integer.valueOf(parts[6]));
      dto.setStatus(TrainStatus.valueOf(parts[7].toUpperCase()));
      trains.add(dto);
    }
    return trains;
  }
}
