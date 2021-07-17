package com.getir.service;

import com.getir.entity.Customer;
import com.getir.entity.Order;
import com.getir.exception.EntityNotExistException;
import com.getir.exception.MailAlreadyTakenException;
import com.getir.model.dto.OrderDTO;
import com.getir.model.enums.Status;
import com.getir.model.request.CustomerCreateRequest;
import com.getir.model.request.CustomerParameterRequest;
import com.getir.model.response.CustomerPageResponse;
import com.getir.model.response.CustomerResponse;
import com.getir.repository.CustomerRepository;
import com.getir.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    public CustomerService(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    public CustomerResponse createCustomer(CustomerCreateRequest request) {

        validateEmail(request.getEmail());

        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setSurname(request.getSurname());
        customer.setEmail(request.getEmail());
        customer.setOrderList(request.getOrderList());

        customerRepository.save(customer);

        logger.info("Customer saved successfully! {}", customer);

        CustomerResponse response = new CustomerResponse();
        response.setStatus(Status.SUCCESS);
        response.setCustomer(customer.toDTO(customer));

        return response;
    }

    private void validateEmail(String email) {

        Customer customer = customerRepository.getCustomerByEmail(email);

        if(customer != null)
            throw new MailAlreadyTakenException(email);
    }

    public CustomerResponse getCustomer(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotExistException(String.valueOf(id)));

        CustomerResponse response = new CustomerResponse();
        response.setStatus(Status.SUCCESS);
        response.setCustomer(customer.toDTO(customer));

        logger.info("Customer get successfully! {}", response);

        return response;
    }

    public CustomerPageResponse getCustomerOrders(CustomerParameterRequest request) {

        CustomerPageResponse customerPageResponse = new CustomerPageResponse();

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        List<Order> orders = orderRepository.findByCustomerId(request.getId(), pageable);

        if(orders.isEmpty()){
            customerPageResponse.setOrderDTOS(new PageImpl<>(Collections.emptyList()));
            logger.warn("Customer page is empty for request! {}", request);
            return customerPageResponse;
        }

        List<OrderDTO> dtoList = new ArrayList<>();

        orders.forEach(order -> dtoList.add(order.toDTO(order)));

        customerPageResponse.setOrderDTOS(new PageImpl<>(dtoList, PageRequest.of(request.getPage(), request.getSize()), customerRepository.count()));

        logger.info("Customer page is ready! {}", customerPageResponse);

        return customerPageResponse;

    }
}
