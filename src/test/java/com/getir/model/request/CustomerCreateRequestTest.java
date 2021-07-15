package com.getir.model.request;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerCreateRequestTest {

    @Test
    public void it_should_convert_to_string_properly() {

        CustomerCreateRequest request = new CustomerCreateRequest();
        request.setEmail("email");
        request.setName("name");
        request.setSurname("surname");
        request.setOrderList(new ArrayList<>());

        String requestStringValue = request.toString();

        assertThat(requestStringValue).isEqualTo("CustomerCreateRequest{name='name', surname='surname', email='email', orderList=[]}");
    }
}
