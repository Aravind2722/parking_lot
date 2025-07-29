package org.example.repositories;

import org.example.models.Gate;
import org.example.models.ParkingLot;

import java.util.Optional;

public interface IParkingLotRepository {
    Optional<ParkingLot> getParkingLotByGate(Gate gate);
}
