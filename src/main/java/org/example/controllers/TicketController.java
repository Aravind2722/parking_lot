package org.example.controllers;

import org.example.dtos.GenerateTicketRequestDto;
import org.example.dtos.GenerateTicketResponseDto;
import org.example.models.ResponseStatus;
import org.example.models.Ticket;
import org.example.services.ITicketService;

public class TicketController {
    private ITicketService ticketService;
    public TicketController(ITicketService ticketService) {
        this.ticketService = ticketService;
    }


    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto) {
//        Use DTO only for data transfer out to in or in to out data transfer...
        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        Ticket ticket;
        try {
            ticket = ticketService.generateTicket(
                    requestDto.getGateId(), requestDto.getVehicleNumber(), requestDto.getVehicleType()
            );
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setMessage("Ticket Generated Successfully!");
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setMessage(e.getMessage());
            return responseDto;
        }


        responseDto.setTicketId(ticket.getId());
        responseDto.setEntrytime(ticket.getEntryTime());
        responseDto.setFloorNumber(ticket.getParkingFloor().getParkingFloorNumber());
        responseDto.setGateId(ticket.getGate().getId());
        responseDto.setOperatorId(ticket.getOperator().getId());
        responseDto.setSpotNumber(ticket.getParkingSpot().getParkingSpotNumber());
        return responseDto;
    }
}
