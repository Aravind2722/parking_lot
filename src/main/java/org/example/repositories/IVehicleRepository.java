package org.example.repositories;

import org.example.models.Vehicle;

import java.util.Optional;

public interface IVehicleRepository {
    Optional<Vehicle> findVehicleByVehicleNumber(String vehicleNumber);
    Vehicle save(Vehicle vehicle);
}
