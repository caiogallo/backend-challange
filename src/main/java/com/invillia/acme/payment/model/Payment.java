package com.invillia.acme.payment.model;

import lombok.Data;

import java.util.Date;

@Data
public class Payment {
    private PaymentStatus status;
    private String creditCardNumber;
    private Date paymentDate;
}
