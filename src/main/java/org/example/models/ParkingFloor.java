package org.example.models;

import java.util.List;

public class ParkingFloor extends BaseModel {
    // Columns:
    // id, parking_floor_number, parking_lot_id(fk)
//    private int id;
    private int parkingFloorNumber;
    // We cannot use ID as the floor number. generally Id is only for unique identification in table
    // Also, if we are persisting data for multiple parking lots, 2 or more floors can have the same floor number
    // as they belong to different parking lots. So it is important to have one more column for the floor number.
    private List<ParkingSpot> parkingSpots;
    // I tried removing the above, as I was adding parking floor reference at parking spot class
    // But faced problems while coding RandomSpotAssignmentStrategy

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
