package com.invillia.acme.order.model;

import com.invillia.acme.address.model.Address;
import com.invillia.acme.payment.model.Payment;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    private Date confirmationDate;
    private OrderStatus status;
    private Address address;
    private List<Item> itens;
    private Payment payment;
}
