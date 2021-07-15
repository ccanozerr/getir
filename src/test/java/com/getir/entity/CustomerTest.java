package com.getir.entity;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    @Test
    public void it_should_convert_to_string_properly() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Can");
        customer.setSurname("Özer");
        customer.setEmail("ccanozerr@gmail.com");
        customer.setOrderList(new ArrayList<>());

        String customerStringValue = customer.toString();

        assertThat(customerStringValue).isEqualTo("Customer{name='Can', surname='Özer', email='ccanozerr@gmail.com', orderList=[]}");
        assertThat(1L).isEqualTo(customer.getId());

    }
}
