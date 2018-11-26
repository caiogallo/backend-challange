package com.invillia.acme.provider.service;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.invillia.acme.address.model.service.AddressSearchRequest;
import com.invillia.acme.provider.model.Provider;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProviderServiceTest {
    @InjectMocks
    private ProviderService providerService;

    @BeforeClass
    public static void setUp(){
        FixtureFactoryLoader.loadTemplates("com.invillia.acme.fixtures");
    }

    @Test
    public void when_create_new_provider_return_success(){
        Provider createdProvider = providerService.create(Fixture.from(Provider.class).gimme("valid-without-id"));

        Assert.assertNotNull(createdProvider);
        Assert.assertNotNull(createdProvider.getId());
        Assert.assertEquals(1l, createdProvider.getId().longValue());
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
        Provider foundProvider = providerService.get(1l);

        Assert.assertNotNull(foundProvider);
        Assert.assertNotNull(foundProvider.getId());
        Assert.assertEquals(1, foundProvider.getId().longValue());
    }

    @Test
    public void when_find_by_name_and_return_one_provider(){
        String providerName = "Provider 1";
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
        String zipCode = "18099000";

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