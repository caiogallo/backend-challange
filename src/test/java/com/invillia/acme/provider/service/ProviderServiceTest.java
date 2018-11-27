package com.invillia.acme.provider.service;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.invillia.acme.address.model.Address;
import com.invillia.acme.address.model.service.AddressSearchRequest;
import com.invillia.acme.provider.model.Provider;
import com.invillia.acme.provider.repository.ProviderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderServiceTest {
    @Autowired
    private ProviderService providerService;

    @Autowired
    private ProviderRepository repository;

    @BeforeClass
    public static void setUpClass(){
        FixtureFactoryLoader.loadTemplates("com.invillia.acme.fixtures");
    }

    @Before
    public void setUp(){
        repository.deleteAll();

        Address address = new Address("Av Ipiranga", 123, 18099000);
        repository.save(new Provider("My Provider"));
        repository.save(Fixture.from(Provider.class).gimme("valid"));
        repository.save(Fixture.from(Provider.class).gimme("valid"));
        repository.save(Fixture.from(Provider.class).gimme("valid"));
        repository.save(new Provider("Provider 1", address));
        repository.save(new Provider("Provider 2", address));
        repository.save(new Provider("Provider 3", address));
        repository.save(new Provider("1", "Provider One"));
    }

    @Test
    public void when_create_new_provider_return_success(){
        Provider createdProvider = providerService.create(Fixture.from(Provider.class).gimme("valid-without-id"));

        Assert.assertNotNull(createdProvider);
        Assert.assertNotNull(createdProvider.getId());
    }

    @Test
    public void when_update_provider_by_id_1_return_success(){
        String providerName = "updated provider";
        Provider provider = Fixture.from(Provider.class).gimme("valid");
        provider.setName(providerName);
        Provider updatedProvider = providerService.update(provider);

        Assert.assertNotNull(updatedProvider);
        Assert.assertNotNull(updatedProvider.getId());
        Assert.assertNotNull(providerName, updatedProvider.getName());
    }

    @Test
    public void when_find_provider_by_id_1_return_notnull(){
        Provider foundProvider = providerService.get("1");
        Assert.assertNotNull(foundProvider);
        Assert.assertNotNull(foundProvider.getId());
    }

    @Test
    public void when_find_by_name_and_return_one_provider(){
        String providerName = "My Provider";
            List<Provider> foundProviders = providerService.find(
                ProviderSearchRequest
                        .builder()
                        .name(providerName)
                        .build());

        Assert.assertNotNull(foundProviders);
        Assert.assertEquals(1, foundProviders.size());
    }

    @Test
    public void when_find_by_address_and_return_success(){
        String streetName = "Av Ipiranga";
        Integer zipCode = 18099000;

        List<Provider> providers = providerService.find(
                ProviderSearchRequest
                        .builder()
                        .address(
                                AddressSearchRequest
                                        .builder()
                                        .street(streetName)
                                        .zipCode(zipCode)
                                        .build())
                        .build());

        Assert.assertNotNull(providers);
        Assert.assertEquals(3, providers.size());

    }
}