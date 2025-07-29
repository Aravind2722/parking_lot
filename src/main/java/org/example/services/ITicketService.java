package org.example.services;

import org.example.exceptions.InvalidGateIdException;
import org.example.exceptions.InvalidParkingLotException;
import org.example.exceptions.NoAvailableParkingSpotException;
import org.example.models.Ticket;
import org.example.models.VehicleType;

public interface ITicketService {
    Ticket generateTicket(Long gateId, String vehicleNumber, VehicleType vehicleType) throws InvalidGateIdException, InvalidParkingLotException, NoAvailableParkingSpotException;
}
