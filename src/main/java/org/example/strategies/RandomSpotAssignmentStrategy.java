package org.example.strategies;

import org.example.models.*;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {
    @Override
    public Optional<ParkingSpot> findSpot(ParkingLot parkingLot, VehicleType vehicleType) {
        for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
            for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                if (
                        parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY) &&
                                parkingSpot.getSupportedVehicleTypes().contains(vehicleType)
                ) {
                    return Optional.of(parkingSpot);
                }
            }
        }
        return Optional.empty();
    }
}
