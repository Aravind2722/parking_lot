package org.example.models;

import jdk.incubator.vector.VectorOperators;

public class Gate {
    // We dont need separate enitties for entry and exit gates
    // All the atributes are gonna be same, but the behaviour.
    // Ticket generation happens at entry gate, paymnets happen at exit gates..
    // In an Entity based design, we should have to code the behaviours insidde relevant models
    // In software system, it is the service class that is gonna take care of the behavious. So 2 enitites are not needed
    private int id;
    private int gateNumber;
    private Operator operator;
    private GateStatus gateStatus;
    private GateType gateType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }
}
