package org.example.services;

import org.example.exceptions.InvalidGateIdException;
import org.example.exceptions.InvalidParkingLotException;
import org.example.exceptions.NoAvailableParkingSpotException;
import org.example.models.*;
import org.example.repositories.*;
import org.example.strategies.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

public class TicketServiceImpl implements ITicketService{
    private IGateRepository gateRepository;
    private IParkingLotRepository parkingLotRepository;
    private IVehicleRepository vehicleRepository;
    private ITicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    public TicketServiceImpl(
            IGateRepository gateRepository,
            IParkingLotRepository parkingLotRepository,
            IVehicleRepository vehicleRepository,
            SpotAssignmentStrategy spotAssignmentStrategy,
            ITicketRepository ticketRepository
    ) {
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }
    @Override
    public Ticket generateTicket(Long gateId, String vehicleNumber, VehicleType vehicleType) throws InvalidGateIdException, InvalidParkingLotException, NoAvailableParkingSpotException {
        // Check if gate id is valid, if not throw an exception
        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if (gateOptional.isEmpty()) throw new InvalidGateIdException("Gate Not Found!");
        Gate gate = gateOptional.get();

        // Get operator using the gate id
        Operator operator = gate.getOperator();

        // Get parking Lot by using the gate id
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.getParkingLotByGate(gate);
        if (parkingLotOptional.isEmpty()) throw new InvalidParkingLotException("Parking Lot Not Found!");
        ParkingLot parkingLot = parkingLotOptional.get();

        // if vehicle already registered, get use it, otherwise register the vehicle
        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByVehicleNumber(vehicleNumber);
        Vehicle vehicle;
        if (vehicleOptional.isPresent()) vehicle = vehicleOptional.get();
        else {
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle = vehicleRepository.save(vehicle);
        }

        // Use RandomParkingSpotAssignmentStrategy to get the parkingSpot
        Optional<ParkingSpot> parkingSpotOptional = spotAssignmentStrategy.findSpot(parkingLot, vehicleType);
        if (parkingSpotOptional.isEmpty()) throw new NoAvailableParkingSpotException("Parking Spot Currently Unavailable!");
        ParkingSpot parkingSpot = parkingSpotOptional.get();

        // set all the attributes and return the Ticket.
        Ticket ticket = new Ticket();
        ticket.setTickeNumber(new Random().nextInt());
        ticket.setEntryTime(new Date());
        ticket.setGate(gate);
        ticket.setOperator(operator);
        ticket.setVehicle(vehicle);
        ticket.setParkingFloor(parkingSpot.getParkingFloor());
        ticket.setParkingSpot(parkingSpot);

        return ticketRepository.save(ticket);
    }
}
