package com.getir.model.response;

import com.getir.entity.Customer;
import com.getir.model.dto.CustomerLightDTO;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerResponseTest {

    @Test
    public void it_should_convert_to_string_properly() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Can");
        customer.setSurname("Özer");
        customer.setEmail("ccanozerr@gmail.com");
        customer.setOrderList(new ArrayList<>());

        CustomerLightDTO dto = customer.toLightDTO(customer);

        CustomerResponse response = new CustomerResponse();
        response.setCustomer(dto);
        response.setOrderList(new ArrayList<>());

        String responseStringValue = response.toString();

        assertThat(responseStringValue).isEqualTo("CustomerResponse{customer=CustomerLightDTO{name='Can', surname='Özer', email='ccanozerr@gmail.com'}, orderList=[]}");
    }
}
