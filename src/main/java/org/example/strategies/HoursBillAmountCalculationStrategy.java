package org.example.strategies;

import org.example.models.Bill;

import java.time.Duration;

public class HoursBillAmountCalculationStrategy implements BillAmountCalculationStrategy{
    private static final long MILLIS_PER_HOUR = 3_600_000L;
    private static final double PRICE_PER_HOUR = 21.5;
    @Override
    public Double calculateBillAmount(Bill bill) {

        long millis = Duration.between(bill.getTicket().getEntryTime().toInstant(), bill.getExitTime().toInstant()).toMillis();
        long hours = (millis + MILLIS_PER_HOUR - 1) / MILLIS_PER_HOUR;

        return hours * PRICE_PER_HOUR;
    }
}
