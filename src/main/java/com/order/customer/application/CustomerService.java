package com.order.customer.application;

import com.order.customer.dto.request.CreateCustomerAddressRequest;
import com.order.customer.dto.request.CreateCustomerRequest;
import com.order.customer.dto.response.CustomerResponse;

public class CustomerService {

    public CustomerResponse createCustomer(CreateCustomerRequest request) {
        validateRequest(request);
        String normalizedCpf = normalizeCpf(request.cpf());
        String normalizedCep = normalizeCep(request.address().cep());
        String normalizedPhone = normalizePhone(request.phone());


    }

    private void validateRequest(CreateCustomerRequest request) {
        if (request == null) {
            throw new RuntimeException("Request não pode ser nulo");
        }

        if (request.name() == null || request.name().isBlank()) {
            throw new RuntimeException("Nome é obrigatório");
        }

        if (request.cpf() == null || request.cpf().isBlank()) {
            throw new RuntimeException("CPF é obrigatório");
        }

        validateAddressRequest(request.address());

        if (request.phone() == null || request.phone().isBlank()) {
            throw new RuntimeException("Telefone é obrigatório");
        }
    }

    private void validateAddressRequest(CreateCustomerAddressRequest request) {
        if (request == null) {
            throw new RuntimeException("Endereço é obrigatório");
        }

        if (request.street() == null || request.street().isBlank()) {
            throw new RuntimeException("Rua é obrigatória");
        }

        if (request.number() == null || request.number().isBlank()) {
            throw new RuntimeException("Numero é obrigatório");
        }

        if (request.city() == null || request.city().isBlank()) {
            throw new RuntimeException("Cidade é obrigatória");
        }

        if (request.state() == null || request.state().isBlank()) {
            throw new RuntimeException("Estado é obrigatório");
        }

        if (request.cep() == null || request.cep().isBlank()) {
            throw new RuntimeException("CEP é obrigatório");
        }
    }

    private String normalizeCpf(String cpf) {
        return cpf.replaceAll("[^0-9]", "");
    }

    private String normalizeCep(String cep) {
        return cep.replaceAll("[^0-9]", "");
    }

    private String normalizePhone(String phone) {
        return phone.replaceAll("[^0-9]", "");
    }

    private void valideteCpfLength(String cpf) {

    }
}
