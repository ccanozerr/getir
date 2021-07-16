package com.getir.model;

import com.getir.model.dto.BookDTO;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderDetailTest {

    @Test
    public void it_should_convert_to_string_properly() {

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setBook(new BookDTO());
        orderDetail.setOrderCount(1L);

        String orderDetailStringValue = orderDetail.toString();

        assertThat(orderDetailStringValue).isEqualTo("OrderDetail{book=BookDTO{id=null, name='null', description='null', writer='null', price=null, remainingStock=null}, orderCount=1}");

    }

}
