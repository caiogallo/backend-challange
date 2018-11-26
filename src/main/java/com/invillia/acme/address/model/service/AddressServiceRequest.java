package com.invillia.acme.address.model.service;

import lombok.Builder;

@Builder
public class AddressServiceRequest {
    private String street;
    private String number;
    private String zipCode;
}
