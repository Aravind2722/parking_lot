package org.example.repositories;

import org.example.models.Payment;

import java.util.List;

public interface IPaymentRepository {
    Payment save(Payment payment);
    List<Payment> findAllByBillId(Long billId);
}
