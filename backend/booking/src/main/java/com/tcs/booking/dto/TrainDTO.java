package com.tcs.booking.dto;

public class TrainDTO {

    private Long trainId;
    private String trainNumber;
    private String trainName;
    private String trainType;
    private Integer totalSeats;
    private Integer acSeats;
    private Integer sleeperSeats;
    private Integer generalSeats;
    private String status;

    // Getters and setters
    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Integer getAcSeats() {
        return acSeats;
    }

    public void setAcSeats(Integer acSeats) {
        this.acSeats = acSeats;
    }

    public Integer getSleeperSeats() {
        return sleeperSeats;
    }

    public void setSleeperSeats(Integer sleeperSeats) {
        this.sleeperSeats = sleeperSeats;
    }

    public Integer getGeneralSeats() {
        return generalSeats;
    }

    public void setGeneralSeats(Integer generalSeats) {
        this.generalSeats = generalSeats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
