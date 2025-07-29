package org.example.models;

import java.util.List;

public class ParkingSpot extends BaseModel {
    // Columns:
    // id, parking_spot_number, parking_floor_id(fk), vehicle_id(fk), parking_spot_status(enum)
//    private int id;
    private int parkingSpotNumber;
    private List<VehicleType> supportedVehicleTypes;
    // this relationship might need a separate table
    // 1 spot can support multiple types (1 : m)
    // 1 type can be supported by multiple spots (1 : m)
    // Hence cardinality => m : m
    // columns:
    // id (might not be needed), parking_spot_id, vehicle_type(enum)
    private ParkingSpotStatus parkingSpotStatus;
    private ParkingFloor parkingFloor;
    private Vehicle vehicle;

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
// this is needed, as we have to know if spot is filled, which vehicle is parked


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
