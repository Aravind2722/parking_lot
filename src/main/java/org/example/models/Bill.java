package org.example.models;

import java.util.Date;

public class Bill extends BaseModel {
    // Columns:
    // id, bill_number, amount, payment_link, exit_time, ticket_id(fk), gate_id(fk), operator_id(fk), bill_status(enum)
//    private int id;
    private int billNumber;
    private Ticket ticket;
    private Date exitTime;
    private Double amount;
    private Gate gate;
    private Operator operator;
    private String paymentLink; // using which user pays online.
    private BillStatus billStatus;

//    private List<Payment> payments;
    // Using list of payments has advantages...
    //  1. If a particular payment failed, and the user tries again, and the 2nd payment passed,
    //      Had we maintained only one payment attribute, the failed payment's information would have gotten lost
    //      using a List, maintains the history of payments. So that refunds can happen.
    //  2. We can support partial payments too. {cash, UPI, Cashback, promocode, wallet}
    //  3. Incase of e-commerce platforms, users would cancel the order. In that case if we maintain history of payments and
    //      cashbacks, refunds and retakes will be easy....
    // If we store Bill attribute in the payment class, we dont need to store a list<payment> here..


    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public String getPaymentLink() {
        return paymentLink;
    }

    public void setPaymentLink(String paymentLink) {
        this.paymentLink = paymentLink;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}

