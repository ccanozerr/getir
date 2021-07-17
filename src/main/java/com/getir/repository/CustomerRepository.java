package com.getir.repository;

import com.getir.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

    Customer getCustomerByOrderListId(Long id);

    Customer getCustomerByEmail(String email);
}
