package org.example.models;

import java.util.Date;

public class Payment {
    private int id;
    private String refernceNumber;
    private double amount;
    private Bill bill;
    private PaymentMode paymentMode;
    private Date time;
    private PaymentStatus paymentStatus;
}
