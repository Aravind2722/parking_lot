package org.example.models;

import java.util.List;

public class ParkingFloor {
    private int id;
    private int parkingFloorNumber;
    // We cannot use ID as the floor number. generally Id is only for unique identification in table
    // Also, if we are persisting data for multiple parking lots, 2 or more floors can have the same floor number
    // as they belong to different parking lots. So it is important to have one more column for the floor number.
    private List<ParkingSpot> parkingSpots;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParkingFloorNumber() {
        return parkingFloorNumber;
    }

    public void setParkingFloorNumber(int parkingFloorNumber) {
        this.parkingFloorNumber = parkingFloorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
