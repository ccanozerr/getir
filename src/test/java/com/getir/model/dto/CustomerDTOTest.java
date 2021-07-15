package com.getir.model.dto;

import com.getir.entity.Book;
import com.getir.entity.Customer;
import com.getir.entity.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerDTOTest {

    @Test
    public void it_should_convert_to_string_properly() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Can");
        customer.setSurname("Özer");
        customer.setEmail("ccanozerr@gmail.com");
        customer.setOrderList(new ArrayList<>());

        CustomerDTO dto = customer.toDTO(customer);
        String customerStringValue = dto.toString();

        assertThat(customerStringValue).isEqualTo("CustomerDTO{id=1, name='Can', surname='Özer', email='ccanozerr@gmail.com', orderList=[]}");

    }
}
