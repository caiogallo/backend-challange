package com.invillia.acme.provider.service;

import com.invillia.acme.provider.model.Provider;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {
    public Provider create(Provider provider) {
        provider.setId(1l);
        return provider;
    }

    public Provider update(Provider provider) {
        return provider;
    }
}
