package org.example;

import org.example.controllers.TicketController;
import org.example.repositories.*;
import org.example.services.ITicketService;
import org.example.services.TicketServiceImpl;
import org.example.strategies.RandomSpotAssignmentStrategy;
import org.example.strategies.SpotAssignmentStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        IGateRepository gateRepository = new GateRepositoryImpl();
        IVehicleRepository vehicleRepository = new VehicleRepositoryImpl();
        IParkingLotRepository parkingLotRepository = new ParkingLotRepositoryImpl();
        ITicketRepository ticketRepository = new TicketRepositoryImpl();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy();

        ITicketService ticketService = new TicketServiceImpl(
                gateRepository, parkingLotRepository, vehicleRepository, spotAssignmentStrategy, ticketRepository
        );

        TicketController ticketController = new TicketController(ticketService);
        System.out.println("Application Started Successfully!");
    }
}