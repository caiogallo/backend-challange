package com.invillia.acme.provider.controller.v1;

import com.invillia.acme.address.model.service.AddressSearchRequest;
import com.invillia.acme.exception.NotFoundException;
import com.invillia.acme.provider.controller.v1.request.ProviderRequest;
import com.invillia.acme.provider.controller.v1.response.ProviderResponse;
import com.invillia.acme.provider.model.Provider;
import com.invillia.acme.provider.service.ProviderSearchRequest;
import com.invillia.acme.provider.service.ProviderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/provider")
@Api("/v1/provider")
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
                consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("Create a new provider")
    public HttpEntity<ProviderResponse> create(@Valid @RequestBody ProviderRequest providerRequest) {
        Provider provider = providerService.create(providerRequest.buildProvider());
        return ResponseEntity.ok(ProviderResponse.builder().id(provider.getId()).name(provider.getName()).build());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("Retrieve providers with parameters")
    public HttpEntity<List<ProviderResponse>> find(@RequestParam(required = false) String name,
                                                   @RequestParam(required = false) String streetName,
                                                   @RequestParam(required = false) Integer streetNumber,
                                                   @RequestParam(required = false) Integer zipCode){
        try {
            ProviderSearchRequest searchRequest =
                    ProviderSearchRequest
                            .builder()
                            .name(name)
                            .address(AddressSearchRequest.builder()
                                    .street(streetName)
                                    .number(streetNumber)
                                    .zipCode(zipCode)
                                    .build())
                            .build();
            List<Provider> providers = providerService.find(searchRequest);
            List<ProviderResponse> providerResponses = providers
                    .stream()
                    .map(provider -> ProviderResponse.builder().name(provider.getName()).id(provider.getId()).build())
                    .collect(Collectors.toList());
            return ResponseEntity.ok(providerResponses);
        }catch(NotFoundException notFound){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("Retireve provider by id")
    public HttpEntity<ProviderResponse> get(@PathVariable(name = "id") String id) {
        try {
            Provider provider = providerService.get(id);
            return ResponseEntity.ok(ProviderResponse.builder().id(provider.getId()).name(provider.getName()).build());
        } catch (NotFoundException notFound) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Delete provider by id")
    public HttpEntity delete(@PathVariable(name = "id") String id){
        try {
            providerService.delete(id);
            return ResponseEntity.ok().build();
        } catch (NotFoundException notFound) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("Update all data for provider specified by id")
    public HttpEntity put(@PathVariable(name = "id") String id, @RequestBody @Valid ProviderRequest providerRequest) {
        try {
            providerService.update(id, providerRequest.buildProvider());
            return ResponseEntity.ok().build();
        } catch (NotFoundException notFound) {
            return ResponseEntity.notFound().build();
        }
    }
}
