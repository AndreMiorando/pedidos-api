package com.order.customer.repository;

import com.order.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    boolean existsByCpf(String cpf);

    
}
