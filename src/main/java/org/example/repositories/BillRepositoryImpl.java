package org.example.repositories;

import org.example.models.Bill;
import org.example.models.Payment;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class BillRepositoryImpl implements IBillRepository {


    private final Map<Long, Bill> bills = new TreeMap<>();
    private Long autoId = 0L;

    @Override
    public Bill save(Bill bill) {
        if (bill.getId() == null || bill.getId() == 0) bill.setId(++autoId);
        bills.put(bill.getId(), bill);
        return bill;
    }

    public Optional<Bill> findById(Long id) {
        return Optional.ofNullable(bills.get(id));
    }
}
