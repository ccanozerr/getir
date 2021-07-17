package com.getir.service;

import com.getir.entity.Book;
import com.getir.entity.Order;
import com.getir.repository.BookRepository;
import com.getir.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsServiceTest {

    @InjectMocks
    private StatisticsService statisticsService;

    @Mock
    private OrderRepository orderRepository;

    @Test
    public void it_should_get_customer_statistics(){

        Book book = new Book();
        book.setId(1L);
        book.setName("The Silmarillion");
        book.setDescription("The Silmarillion is a collection of mythopoeic stories.");
        book.setWriter("J. R. R. Tolkien");
        book.setPrice(new BigDecimal(15));
        book.setRemainingStock(10L);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        Order order1 = new Order();
        order1.setId(1L);
        order1.setDateCreated(new Date(1995, Calendar.MARCH,7));
        order1.setTotalPrice(new BigDecimal(15));
        order1.setCustomerId(1L);
        order1.setBookList(bookList);
        order1.setTotalBookCount(1L);

        Order order2 = new Order();
        order2.setId(1L);
        order2.setDateCreated(new Date(1995, Calendar.DECEMBER,7));
        order2.setTotalPrice(new BigDecimal(15));
        order2.setCustomerId(1L);
        order2.setBookList(bookList);
        order2.setTotalBookCount(1L);

        Order order3 = new Order();
        order3.setId(1L);
        order3.setDateCreated(new Date(1995, Calendar.SEPTEMBER,7));
        order3.setTotalPrice(new BigDecimal(15));
        order3.setCustomerId(1L);
        order3.setBookList(bookList);
        order3.setTotalBookCount(1L);

        Order order4 = new Order();
        order4.setId(1L);
        order4.setDateCreated(new Date(1995, Calendar.JULY,7));
        order4.setTotalPrice(new BigDecimal(15));
        order4.setCustomerId(1L);
        order4.setBookList(bookList);
        order4.setTotalBookCount(1L);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);

        Mockito.when(orderRepository.findByCustomerId(1L)).thenReturn(orderList);

        statisticsService.getCustomerStatistics(1L);

    }
}
