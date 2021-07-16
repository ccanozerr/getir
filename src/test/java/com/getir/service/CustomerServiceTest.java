package com.getir.service;

import com.getir.entity.Book;
import com.getir.entity.Customer;
import com.getir.entity.Order;
import com.getir.model.request.BookCreateRequest;
import com.getir.model.request.CustomerCreateRequest;
import com.getir.model.request.CustomerParameterRequest;
import com.getir.repository.BookRepository;
import com.getir.repository.CustomerRepository;
import com.getir.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private OrderRepository orderRepository;

    @Test
    public void it_should_save_customer() {

        CustomerCreateRequest request = new CustomerCreateRequest();
        request.setName("name");
        request.setSurname("surname");
        request.setEmail("ccanozerr@gmail.com");
        request.setOrderList(new ArrayList<>());

        customerService.createCustomer(request);

    }

    @Test
    public void it_should_get_customer() {

        Customer customer = new Customer();
        customer.setOrderList(new ArrayList<>());

        Mockito.when(customerRepository.findById(1L)).thenReturn(java.util.Optional.of(customer));

        customerService.getCustomer(1L);

    }

    @Test
    public void it_should_get_customer_orders() {

        CustomerParameterRequest request = new CustomerParameterRequest();
        request.setId(1L);
        request.setPage(0);
        request.setSize(3);

        Book book = new Book();
        book.setId(1L);
        book.setName("The Silmarillion");
        book.setDescription("The Silmarillion is a collection of mythopoeic stories.");
        book.setWriter("J. R. R. Tolkien");
        book.setPrice(new BigDecimal(15));
        book.setRemainingStock(10L);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        Order order = new Order();
        order.setId(1L);
        order.setDateCreated(new Date(1995, Calendar.JULY,7));
        order.setTotalPrice(new BigDecimal(15));
        order.setCustomerId(1L);
        order.setBookList(bookList);

        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order);
        orders.add(order);

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        Mockito.when(orderRepository.findByCustomerId(request.getId(), pageable)).thenReturn(orders);

        customerService.getCustomerOrders(request);

    }

    @Test
    public void it_should_get_customer_orders_empty() {

        CustomerParameterRequest request = new CustomerParameterRequest();
        request.setId(1L);
        request.setPage(0);
        request.setSize(3);

        List<Order> orders = new ArrayList<>();

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        Mockito.when(orderRepository.findByCustomerId(request.getId(), pageable)).thenReturn(orders);

        customerService.getCustomerOrders(request);

    }
}
