package com.invillia.acme.address.model.service;

import lombok.Builder;

@Builder
public class AddressSearchRequest {
    private String street;
    private String number;
    private String zipCode;
}
