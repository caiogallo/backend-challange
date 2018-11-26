package com.invillia.acme.order.model;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Item {
    private String description;
    private BigInteger price;
    private Long quantitiy;
}
