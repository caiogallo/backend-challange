package com.invillia.acme.address.model;

import lombok.Data;

@Data
public class Address {
    private Long id;
    private String street;
    private Integer number;
    private Integer zipCode;
    private String complement;

}
