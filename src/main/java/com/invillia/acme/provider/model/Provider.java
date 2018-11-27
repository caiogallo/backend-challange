package com.invillia.acme.provider.model;

import com.invillia.acme.address.model.Address;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("provider")
@Data
@NoArgsConstructor
public class Provider {
    private String id;
    private String name;
    private Address address;

    public Provider(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Provider(String name) {
        this.name = name;
    }

    public Provider(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
