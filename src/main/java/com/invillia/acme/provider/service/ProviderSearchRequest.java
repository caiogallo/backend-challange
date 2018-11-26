package com.invillia.acme.provider.service;

import com.invillia.acme.address.model.service.AddressSearchRequest;
import lombok.Builder;

@Builder
public class ProviderSearchRequest {
    private String name;
    private AddressSearchRequest address;
}
