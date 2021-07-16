package com.getir.service;

import com.getir.entity.Book;
import com.getir.entity.Customer;
import com.getir.entity.Order;
import com.getir.exception.EntityNotExistException;
import com.getir.model.dto.OrderDTO;
import com.getir.model.dto.OrderLightDTO;
import com.getir.model.request.OrderByDateRequest;
import com.getir.model.request.OrderRequest;
import com.getir.model.response.OrderResponse;
import com.getir.repository.BookRepository;
import com.getir.repository.CustomerRepository;
import com.getir.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final BookRepository bookRepository;

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    public OrderService(BookRepository bookRepository, CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    public OrderResponse createOrder(OrderRequest request) {

        Customer customer = customerRepository.getById(request.getCustomerID());

        List<Book> books = bookRepository.findAllById(request.getBookIDs());

        Order order = new Order();
        order.setBookList(books);
        order.setTotalPrice(calculatePrice(books));
        order.setDateCreated(new Date());
        order.setCustomerId(request.getCustomerID());
        customer.getOrderList().add(order);

        customerRepository.save(customer);

        updateStockInformation(books);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrder(order.toLightDTO(order));
        orderResponse.setCustomer(customer.toLightDTO(customer));

        logger.info("Order created successfully! {}", orderResponse);

        return orderResponse;
    }

    private void updateStockInformation(List<Book> books) {

        books.forEach(book -> {
            book.setRemainingStock(book.getRemainingStock() - 1);
        });

        logger.info("Stocks updated successfully for books! {}", books);

    }

    private BigDecimal calculatePrice(List<Book> books) {

        logger.info("Price calculate started for books {}!", books);

        return books.stream().map(Book::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public OrderResponse getOrderById(Long id) {

        Customer customer = customerRepository.getCustomerByOrderListId(id);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setCustomer(customer.toLightDTO(customer));

        OrderLightDTO orderLightDTO = new OrderLightDTO();

        Order order = customer.getOrderList()
                .stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElse(null);

        if(order!=null)
            orderLightDTO = order.toLightDTO(order);
        else
            throw new EntityNotExistException("No order found for customer.");

        orderResponse.setOrder(orderLightDTO);

        logger.info("Order response is ready for customer {}, response {}", customer.toLightDTO(customer), orderResponse);

        return orderResponse;

    }

    public List<OrderDTO> getOrderByDateInterval(OrderByDateRequest request) {

        List<Order> orderList = orderRepository.getAllByDateCreatedBetween(request.getStartDate(), request.getEndDate());
        List<OrderDTO> orderDTOS = new ArrayList<>();

        orderList.forEach(order -> orderDTOS.add(order.toDTO(order)));

        logger.info("Orders get successfully for dates between [{}-{}]", request.getStartDate(), request.getEndDate());

        return orderDTOS;
    }
}
