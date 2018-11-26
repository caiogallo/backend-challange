package com.invillia.acme.provider.service;

import com.invillia.acme.address.model.service.AddressServiceRequest;
import lombok.Builder;

@Builder
public class ProviderServiceRequest {
    private String name;
    private AddressServiceRequest address;
}
