package com.invillia.acme.provider.controller.v1.response;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class ProviderResponse implements Serializable {
    private String id;
    private String name;

}
