package com.getir.repository;

import com.getir.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Customer getById(Long id);

    Customer getCustomerByOrderListId(Long id);

    Customer getCustomerByEmail(String email);
}
