package com.invillia.acme.fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.invillia.acme.address.model.Address;

public class AddressFixture implements TemplateLoader {
    public void load(){
        Fixture.of(Address.class).addTemplate("valid-without-id", new Rule(){{
            add("street", random("Rua Pernambuco", "Av Paulista"));
            add("number", random(100, 200));
            add("zipCode", random("101000", "120000"));
            add("complement", random("ao lado do correio", "próximo ao shopping"));
        }});

        Fixture.of(Address.class).addTemplate("valid").inherits("valid-without-id", new Rule(){{
            add("id", random("10", "20", "30"));
        }});
    }
}
