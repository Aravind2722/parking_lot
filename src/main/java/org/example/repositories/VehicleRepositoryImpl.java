package org.example.repositories;

import org.example.models.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepositoryImpl implements IVehicleRepository {
    private final Map<Long, Vehicle> vehicles = new TreeMap <>();
    private long autoIncId = 0;
    @Override
    public Optional<Vehicle> findVehicleByVehicleNumber(String vehicleNumber) {
        return vehicles.values().stream().filter(vehicle -> vehicle.getVehicleNumber().equals(vehicleNumber)).findFirst();
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        if (vehicle.getId() == 0) vehicle.setId(++autoIncId);
        vehicles.put(vehicle.getId(), vehicle);
        return vehicles.get(vehicle.getId());
    }
}
