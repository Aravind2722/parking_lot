package org.example.models;

import java.util.List;

public class ParkingSpot {
    private int id;
    private int parkingSpotNumber;
    private List<VehicleType> supportedVehicleTypes;
    private ParkingSpotStatus parkingSpotStatus;
    private Vehicle vehicle;
    // this is needed, as we have to know if spot is filled, which vehicle is parked


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(int parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
