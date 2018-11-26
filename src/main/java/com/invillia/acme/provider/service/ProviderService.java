package com.invillia.acme.provider.service;

import com.invillia.acme.provider.model.Provider;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProviderService {
    public Provider create(Provider provider) {
        provider.setId(1l);
        return provider;
    }

    public Provider update(Provider provider) {
        return provider;
    }


    public Provider get(Long id) {
        Provider provider = new Provider();
        provider.setId(id);
        return provider;
    }

    public List<Provider> find(ProviderSearchRequest providerRequest) {
        return Arrays.asList(new Provider());
    }
}
