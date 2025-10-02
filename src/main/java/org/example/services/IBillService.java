package org.example.services;

import org.example.exceptions.BillNotFoundException;
import org.example.exceptions.InvalidGateIdException;
import org.example.exceptions.TicketNotFoundException;
import org.example.models.Bill;
import org.example.models.Payment;
import org.example.models.PaymentMode;
import org.example.models.PaymentStatus;

public interface IBillService {
    Bill generateBill(Long ticketId, Long gateId) throws TicketNotFoundException, InvalidGateIdException;
    Payment payBill(Long billId, Double amount, PaymentMode paymentMode, PaymentStatus paymentStatus) throws BillNotFoundException;
}
