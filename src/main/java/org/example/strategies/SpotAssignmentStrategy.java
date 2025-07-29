package org.example.strategies;

import org.example.models.ParkingLot;
import org.example.models.ParkingSpot;
import org.example.models.VehicleType;

import java.util.Optional;

public interface SpotAssignmentStrategy {
    Optional<ParkingSpot> findSpot(ParkingLot parkingLot, VehicleType vehicleType);
}
