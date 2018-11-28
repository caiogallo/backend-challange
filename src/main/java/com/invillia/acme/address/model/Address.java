package com.invillia.acme.address.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Address {
    private String id;
    private String street;
    private Integer number;
    private Integer zipCode;
    private String complement;

    public Address(String street, Integer number, Integer zipCode) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
    }
}
