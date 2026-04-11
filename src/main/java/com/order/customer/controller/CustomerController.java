package com.order.customer.controller;

import com.order.customer.application.CustomerService;
import com.order.customer.dto.request.CreateCustomerRequest;
import com.order.customer.dto.response.CustomerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerResponse create(@RequestBody CreateCustomerRequest request) {
        return service.createCustomer(request);
    }
}


