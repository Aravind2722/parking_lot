package org.example.repositories;

import org.example.models.Payment;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PaymentRepositoryImpl implements IPaymentRepository {

    private final Map<Long, Payment> payments = new TreeMap<>();
    private Long autoId = 0L;

    @Override
    public Payment save(Payment payment) {
        if (payment.getId() == null || payment.getId() == 0) payment.setId(++autoId);
        payments.put(payment.getId(), payment);
        return payment;
    }

    public List<Payment> findAllByBillId(Long billId) {
        return payments.values().stream().filter(payment -> (long)payment.getBill().getId() == (long)billId).toList();
    }
}
