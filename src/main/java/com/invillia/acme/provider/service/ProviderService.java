package com.invillia.acme.provider.service;

import com.google.common.base.Strings;
import com.invillia.acme.address.model.Address;
import com.invillia.acme.provider.model.Provider;
import com.invillia.acme.provider.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository providerRepository;

    public Provider create(Provider provider) {
        return providerRepository.save(provider);
    }

    public Provider update(Provider provider) {
        return provider;
    }


    public Provider get(String id) {
        Provider providerById = new Provider();
        providerById.setId(id);
        Example<Provider> findByIdExample = Example.of(providerById);
        return providerRepository.findOne(findByIdExample).get();
    }

    public List<Provider> find(ProviderSearchRequest providerRequest) {
        Provider provider = new Provider();
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues();

        if(!Strings.isNullOrEmpty(providerRequest.getName())){
            provider.setName(providerRequest.getName());
            matcher = matcher.withMatcher("name", exact());
        }

        if (providerRequest.getAddress() != null) {
            Address address = new Address();
            if(!Strings.isNullOrEmpty(providerRequest.getAddress().getStreet())){
                address.setStreet(providerRequest.getAddress().getStreet());
                matcher = matcher.withMatcher("address.street", exact());
            }
            if (providerRequest.getAddress().getNumber() != null) {
                address.setNumber(providerRequest.getAddress().getNumber());
                matcher = matcher.withMatcher("address.number", exact());
            }
            if (providerRequest.getAddress().getZipCode() != null) {
                address.setZipCode(providerRequest.getAddress().getZipCode());
                matcher = matcher.withMatcher("address.zipCode", exact());
            }
            provider.setAddress(address);
        }
        Example<Provider> example = Example.of(provider, matcher);
        List<Provider> providers = providerRepository.findAll(example);
        return providers;
    }
}
