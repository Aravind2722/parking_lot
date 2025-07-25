package org.example.models;

import java.util.Date;

public class Bill {
    private int id;
    private int billNumber;
    private Ticket ticket;
    private Date exitTime;
    private double amount;
    private Gate gate;
    private Operator operator;
    private String paymentLink; // using which user pays online.

//    private List<Payment> payments;
    // Using list of payments has advantages...
    //  1. If a particular payment failed, and the user tries again, and the 2nd payment passed,
    //      Had we maintained only one payment attribute, the failed payment's information would have gotten lost
    //      using a List, maintains the history of payments. So that refunds can happen.
    //  2. We can support partial payments too. {cash, UPI, Cashback, promocode, wallet}
    //  3. Incase of e-commerce platforms, users would cancel the order. In that case if we maintain history of payments and
    //      cashbacks, refunds and retakes will be easy....
    // If we store Bill attribute in the payment class, we dont need to store a list<payment> here..
}
