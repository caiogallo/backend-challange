package com.invillia.acme.fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.invillia.acme.address.model.Address;
import com.invillia.acme.provider.model.Provider;

public class ProviderFixture implements TemplateLoader {
    public void load(){
        Fixture.of(Provider.class).addTemplate("valid-without-id", new Rule(){{
            add("name", random("Provider 1, Provider 2"));
            add("address", one(Address.class, "valid-without-id"));
        }});

        Fixture.of(Provider.class).addTemplate("valid").inherits("valid-without-id", new Rule(){{
            add("id", random("100", "101", "102"));
            add("address", one(Address.class, "valid"));
        }});
    }
}
