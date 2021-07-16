package com.getir.model.dto;

import com.getir.entity.Book;
import com.getir.entity.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderDTOTest {

    @Test
    public void it_should_convert_to_string_properly() {

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

        OrderDTO dto = order.toDTO(order);
        String orderStringValue = dto.toString();

        assertThat(orderStringValue).isEqualTo("OrderDTO{id=1, customerId=1, totalPrice=15, dateCreated=Sun Jul 07 00:00:00 TRT 3895, bookList=[BookDTO{id=1, name='The Silmarillion', description='The Silmarillion is a collection of mythopoeic stories.', writer='J. R. R. Tolkien', price=15, remainingStock=10}]}");
    }
}
