package com.order.customer.dto.request;

public record CreateCustomerAddressRequest(
        String street,
        String number,
        String complement,
        String city,
        String state,
        String cep
) {
}
