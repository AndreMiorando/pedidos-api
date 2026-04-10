package com.order.customer.dto.response;

public record CustomerAddressResponse(
        String street,
        String number,
        String complement,
        String city,
        String state,
        String cep
) {
}
