package org.example.controllers;


import org.example.dtos.GenerateBillRequestDto;
import org.example.dtos.GenerateBillResponseDto;
import org.example.dtos.PayBillRequestDto;
import org.example.dtos.PayBillResponseDto;
import org.example.models.Bill;
import org.example.models.Payment;
import org.example.models.PaymentStatus;
import org.example.models.ResponseStatus;
import org.example.services.IBillService;

public class BillController {
    private final IBillService billService;

    public BillController(IBillService billService) {
        this.billService = billService;
    }

    public GenerateBillResponseDto generateBill(GenerateBillRequestDto requestDto) {
        GenerateBillResponseDto responseDto = new GenerateBillResponseDto();
        try {
            Bill bill = billService.generateBill(requestDto.getTicketId(), requestDto.getGateId());
            responseDto.setBillNumber(bill.getBillNumber());
            responseDto.setAmount(bill.getAmount());
            responseDto.setExitTime(bill.getExitTime());
            responseDto.setOperatorId(bill.getOperator().getId());
            responseDto.setPaymentLink(bill.getPaymentLink());
            responseDto.setTicketId(bill.getTicket().getId());
            responseDto.setResponsestatus(ResponseStatus.SUCCESS);
            responseDto.setMessage("Bill generated successfully.");
        }catch (Exception e) {
            responseDto.setResponsestatus(ResponseStatus.FAILURE);
            responseDto.setMessage(e.getMessage());
        }
        return responseDto;
    }

    public PayBillResponseDto payBill(PayBillRequestDto requestDto) {
        PayBillResponseDto responseDto = new PayBillResponseDto();
        try {
            Payment payment = billService.payBill(requestDto.getBillId(), requestDto.getAmount(), requestDto.getPaymentMode(), requestDto.getPaymentStatus());
            responseDto.setAmount(payment.getAmount());
            responseDto.setBillId(payment.getBill().getId());
            responseDto.setPaymentId(payment.getId());
            responseDto.setPaymentMode(payment.getPaymentMode());
            responseDto.setReferenceNumber(payment.getReferenceNumber());
            responseDto.setPaymentStatus(payment.getPaymentStatus());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setMessage("Payment " + responseDto.getPaymentStatus().toString());
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setMessage(e.getMessage());
        }

        return responseDto;
    }
}

