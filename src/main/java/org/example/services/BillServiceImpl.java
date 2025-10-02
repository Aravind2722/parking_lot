package org.example.services;

import org.example.exceptions.BillNotFoundException;
import org.example.exceptions.InvalidGateIdException;
import org.example.exceptions.TicketNotFoundException;
import org.example.models.*;
import org.example.repositories.IBillRepository;
import org.example.repositories.IGateRepository;
import org.example.repositories.IPaymentRepository;
import org.example.repositories.ITicketRepository;
import org.example.strategies.BillAmountCalculationStrategy;

import java.util.*;

public class BillServiceImpl implements IBillService {
    private final IBillRepository billRepository;
    private final IPaymentRepository paymentRepository;
    private final ITicketRepository ticketRepository;
    private final IGateRepository gateRepository;
    private final BillAmountCalculationStrategy billAmountCalculationStrategy;

    public BillServiceImpl(
            IBillRepository billRepository,
            IPaymentRepository paymentRepository,
            ITicketRepository ticketRepository,
            IGateRepository gateRepository, BillAmountCalculationStrategy billAmountCalculationStrategy
    ) {
        this.billRepository = billRepository;
        this.paymentRepository = paymentRepository;
        this.ticketRepository = ticketRepository;
        this.gateRepository = gateRepository;
        this.billAmountCalculationStrategy = billAmountCalculationStrategy;
    }
    @Override
    public Bill generateBill(Long ticketId, Long gateId) throws TicketNotFoundException, InvalidGateIdException {
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if (ticketOptional.isEmpty()) throw new TicketNotFoundException("Ticket '" + ticketId + "' not found.");

        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if (gateOptional.isEmpty()) throw new InvalidGateIdException("Gate '" + gateId + "' not found.");

        Bill bill = new Bill();
        bill.setTicket(ticketOptional.get());
        bill.setGate(gateOptional.get());
        bill.setOperator(gateOptional.get().getOperator());
        bill.setExitTime(new Date());
        bill.setBillNumber(new Random().nextInt());
        bill.setAmount(billAmountCalculationStrategy.calculateBillAmount(bill));
        bill.setBillStatus(BillStatus.PENDING);
        bill.setPaymentLink("https://payment.test.com/pay/" + UUID.randomUUID().toString());

        return billRepository.save(bill);
    }

    @Override
    public Payment payBill(Long billId, Double amount, PaymentMode paymentMode, PaymentStatus paymentStatus) throws BillNotFoundException {
        Optional<Bill> billOptional = billRepository.findById(billId);
        if (billOptional.isEmpty()) throw new BillNotFoundException("Bill '" + billId + "' not found.");

        Payment payment = new Payment();
        payment.setBill(billOptional.get());
        payment.setAmount(amount);
        payment.setPaymentMode(paymentMode);
        payment.setPaymentStatus(paymentStatus);
        payment.setTime(new Date());
        payment.setReferenceNumber(UUID.randomUUID().toString());
        Payment savedPayment = paymentRepository.save(payment);

        List<Payment> paymentsToBill = paymentRepository.findAllByBillId(billId);
        double totalPayment = paymentsToBill.stream().mapToDouble(Payment::getAmount).sum();
        boolean anyPending = paymentsToBill.stream().anyMatch(p -> p.getPaymentStatus().equals(PaymentStatus.PENDING));

        if (totalPayment >= billOptional.get().getAmount()) {
            billOptional.get().setBillStatus(BillStatus.PAID);
            billRepository.save(billOptional.get());
        }else if (!anyPending) {
            billOptional.get().setBillStatus(BillStatus.UNPAID);
            billRepository.save(billOptional.get());
        }

        return savedPayment;
    }

}
