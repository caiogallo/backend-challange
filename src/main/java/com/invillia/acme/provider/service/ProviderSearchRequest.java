package com.invillia.acme.provider.service;

import com.invillia.acme.address.model.service.AddressSearchRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class ProviderSearchRequest {
    private String name;
    private AddressSearchRequest address;
}
