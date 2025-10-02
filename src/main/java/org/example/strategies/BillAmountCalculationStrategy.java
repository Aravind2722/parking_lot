package org.example.strategies;

import org.example.models.Bill;

public interface BillAmountCalculationStrategy {
    Double calculateBillAmount(Bill bill);
}
