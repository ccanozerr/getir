package com.getir.model.response;

import com.getir.entity.Customer;
import com.getir.entity.Order;
import com.getir.model.dto.CustomerLightDTO;
import com.getir.model.dto.OrderLightDTO;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderResponseTest {

    @Test
    public void it_should_convert_to_string_properly() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Can");
        customer.setSurname("Özer");
        customer.setEmail("ccanozerr@gmail.com");
        customer.setOrderList(new ArrayList<>());

        CustomerLightDTO customerLightDTO = customer.toLightDTO(customer);

        Order order = new Order();
        order.setId(1L);
        order.setDateCreated(new Date(1995, Calendar.JULY,7));
        order.setTotalPrice(new BigDecimal(15));
        order.setCustomerId(1L);
        order.setBookList(new ArrayList<>());

        OrderLightDTO orderLightDTO = order.toLightDTO(order);

        OrderResponse response = new OrderResponse();
        response.setOrder(orderLightDTO);
        response.setCustomer(customerLightDTO);

        String responseStringValue = response.toString();

        assertThat(responseStringValue).isEqualTo("OrderResponse{customer=CustomerLightDTO{name='Can', surname='Özer', email='ccanozerr@gmail.com'}, order=OrderLightDTO{totalPrice=15, dateCreated=Sun Jul 07 00:00:00 TRT 3895, bookList=[]}}");
    }
}
