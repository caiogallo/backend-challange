package com.invillia.acme.provider.model;

import com.invillia.acme.address.model.Address;
import lombok.Data;

@Data
public class Provider {
    private Long id;
    private String name;
    private Address address;
}
