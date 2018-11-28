package com.invillia.acme.provider.controller.v1.request;

import com.invillia.acme.address.model.Address;
import com.invillia.acme.address.model.controller.v1.request.AddressRequest;
import com.invillia.acme.provider.model.Provider;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class ProviderRequest {
    private String id;
    @NotNull
    private String name;
    private AddressRequest address;

    public Provider buildProvider() {
        Provider provider = new Provider(id, name);
        if (address != null) {
            Address addr = new Address(address.getStreet(), address.getNumber(), address.getZipCode());
            addr.setComplement(address.getComplement());
            addr.setId(address.getId());
            provider.setAddress(addr);
        }
        return provider;
    }
}
