package com.invillia.acme.address.model.controller.v1.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
public class AddressRequest {
    private String id;
    @NotNull
    private String street;
    private Integer number;
    @NotNull
    @Pattern(regexp = "[0-9]{8}")
    private Integer zipCode;
    private String complement;
}
