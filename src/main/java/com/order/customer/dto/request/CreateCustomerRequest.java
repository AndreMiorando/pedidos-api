package com.order.customer.dto.request;

public record CreateCustomerRequest(
        String name,
        String cpf,
        CreateCustomerAddressRequest address,
        String phone
        ) {
}
