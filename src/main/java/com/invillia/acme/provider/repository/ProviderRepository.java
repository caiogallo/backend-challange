package com.invillia.acme.provider.repository;

import com.invillia.acme.provider.model.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProviderRepository extends MongoRepository<Provider, Long> {

}
