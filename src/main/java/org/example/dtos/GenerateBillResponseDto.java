package org.example.dtos;

import org.example.models.ResponseStatus;

import java.util.Date;

public class GenerateBillResponseDto {
    private int billNumber;
    private Long ticketId;
    private Date exitTime;
    private String paymentLink;
    private Double amount;
    private Long operatorId;
    private ResponseStatus responsestatus;
    private String message;

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public String getPaymentLink() {
        return paymentLink;
    }

    public void setPaymentLink(String paymentLink) {
        this.paymentLink = paymentLink;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public ResponseStatus getResponsestatus() {
        return responsestatus;
    }

    public void setResponsestatus(ResponseStatus responsestatus) {
        this.responsestatus = responsestatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
