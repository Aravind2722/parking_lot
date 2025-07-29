package org.example.repositories;

import org.example.models.Gate;
import org.example.models.ParkingLot;
import org.example.models.ParkingLotStatus;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepositoryImpl implements IParkingLotRepository {
    private final Map<Long, ParkingLot> parkingLots = new TreeMap <>();
    @Override
    public Optional<ParkingLot> getParkingLotByGate(Gate gate) {
        return parkingLots.values().stream().filter(parkingLot -> parkingLot.getGates().contains(gate)).findFirst();
    }
}
