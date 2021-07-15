package com.getir.model.dto;

import com.getir.entity.Customer;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerLightDTOTest {

    @Test
    public void it_should_convert_to_string_properly() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Can");
        customer.setSurname("Özer");
        customer.setEmail("ccanozerr@gmail.com");
        customer.setOrderList(new ArrayList<>());

        CustomerLightDTO dto = customer.toLightDTO(customer);
        String customerStringValue = dto.toString();

        assertThat(customerStringValue).isEqualTo("CustomerLightDTO{name='Can', surname='Özer', email='ccanozerr@gmail.com'}");

    }
}
