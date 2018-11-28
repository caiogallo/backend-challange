package com.invillia.acme.provider.service;

import com.google.common.base.Strings;
import com.invillia.acme.address.model.Address;
import com.invillia.acme.exception.NotFoundException;
import com.invillia.acme.provider.controller.v1.request.ProviderRequest;
import com.invillia.acme.provider.model.Provider;
import com.invillia.acme.provider.repository.ProviderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
@Slf4j
public class ProviderService {
    @Autowired
    private ProviderRepository providerRepository;

    public Provider create(Provider provider) {
        return providerRepository.save(provider);
    }

    public Provider get(String id) {
        Provider providerById = new Provider();
        providerById.setId(id);
        Example<Provider> findByIdExample = Example.of(providerById);
        Provider provider = providerRepository
                .findOne(findByIdExample)
                .orElseThrow(() -> {log.info("Get provider by id {} not found", id); return new NotFoundException();});
        log.info("Get provider by id {} returned {}", id, provider);
        return provider;
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

        if(providers == null || providers.size() == 0){
            log.info("Find providers with parameters {} returned no rows", providerRequest);
            throw new NotFoundException();
        }

        log.info("Find providers with parameters {} returned {}", providerRequest, provider);
        return providers;
    }

    public boolean delete(String id){
        Provider provider = get(id);
        if (provider == null) {
            log.info("unable to delete provider with id {}, not found", id);
            throw new NotFoundException();
        }
        providerRepository.delete(provider);
        log.info("delete provider with id {} success", id);
        return true;
    }

    public boolean update(String id, Provider provider) {
        provider.setId(id);
        providerRepository.save(provider);
        log.info("update provider with id {} and data success", id, provider);
        return true;
    }
}
