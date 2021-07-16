package com.getir.controller;

import com.getir.constants.ApiEndPoints;
import com.getir.model.request.CustomerCreateRequest;
import com.getir.model.request.CustomerParameterRequest;
import com.getir.model.response.CustomerPageResponse;
import com.getir.model.response.CustomerResponse;
import com.getir.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = ApiEndPoints.GETIR_CUSTOMER_API, produces = ApiEndPoints.RESPONSE_CONTENT_TYPE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@Api
@SwaggerDefinition(tags = {
        @Tag(name = "getir-customer-api", description = "Getir Customer Api")
})
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Create Customer", notes = "Create Customer")
    public CustomerResponse createCustomer(@Valid @RequestBody CustomerCreateRequest request){
        logger.info("Creating customer started for request {}", request);
        return customerService.createCustomer(request);
    }

    @GetMapping(value = "/{id}", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Customer", notes = "Get Customer")
    public CustomerResponse getCustomer(@PathVariable Long id){
        logger.info("Get customer started for customer id {}", id);
        return customerService.getCustomer(id);
    }

    @PostMapping(value = "/order")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Customer Orders", notes = "Get Customer Orders")
    public CustomerPageResponse getCustomerOrders(@Valid @RequestBody CustomerParameterRequest request){
        logger.info("Get customer orders started for request {}", request);
        return customerService.getCustomerOrders(request);
    }
}
