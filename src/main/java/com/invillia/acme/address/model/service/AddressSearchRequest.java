package com.invillia.acme.address.model.service;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class AddressSearchRequest {
    public AddressSearchRequest(String street, Integer number, Integer zipCode) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
    }

    private String street;
    private Integer number;
    private Integer zipCode;
}
