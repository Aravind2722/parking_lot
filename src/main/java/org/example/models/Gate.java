package org.example.models;

public class Gate extends BaseModel {
    // Columns:
    // id, gateNumber, parking_lot_id(fk), operator_id(fk), gate_status(enum), gate_type(enum)

    // We don't need separate entities for entry and exit gates
    // All the attributes are going to be same, but the behaviour.
    // Ticket generation happens at entry gate, payments happen at exit gates..
    // In an Entity based design, we should have to code the behaviours inside relevant models
    // In software system, it is the service class that is going to take care of the behaviors. So 2 entities are not needed
//    private int id;
    private int gateNumber;
    private Operator operator;
    private GateStatus gateStatus;
    private GateType gateType;

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
