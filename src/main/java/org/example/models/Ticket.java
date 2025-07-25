package org.example.models;

import java.util.Date;

public class Ticket {
    private int id;
    private int tickeNumber;
    private ParkingFloor parkingFloor;
    private ParkingSpot parkingSpot;
    private Gate gate;
    private Operator operator;
    // Operator attribute is needed. We cannot directly get it from Gate attribute.
    // Reason: Gate class maintains the information of the operator who is currently present.
    // But we want to store the info of the operator who served this ticket.
    private Vehicle vehicle;
    private Date entryTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTickeNumber() {
        return tickeNumber;
    }

    public void setTickeNumber(int tickeNumber) {
        this.tickeNumber = tickeNumber;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
}
