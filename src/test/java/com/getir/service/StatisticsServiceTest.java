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

        Order order = new Order();
        order.setId(1L);
        order.setDateCreated(new Date(1995, Calendar.JULY,7));
        order.setTotalPrice(new BigDecimal(15));
        order.setCustomerId(1L);
        order.setBookList(bookList);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        order.setDateCreated(new Date(1995, Calendar.JULY,7));
        orderList.add(order);
        order.setDateCreated(new Date(1995, Calendar.MARCH,7));
        orderList.add(order);
        order.setDateCreated(new Date(1995, Calendar.JULY,7));
        orderList.add(order);
        order.setDateCreated(new Date(1995, Calendar.MARCH,7));

        Mockito.when(orderRepository.findByCustomerId(1L)).thenReturn(orderList);

        statisticsService.getCustomerStatistics(1L);

    }
}
