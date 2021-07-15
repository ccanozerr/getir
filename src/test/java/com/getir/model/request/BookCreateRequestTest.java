package com.getir.model.request;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class BookCreateRequestTest {

    @Test
    public void it_should_convert_to_string_properly() {

        BookCreateRequest request = new BookCreateRequest();
        request.setName("name");
        request.setDescription("description");
        request.setWriter("writer");
        request.setPrice(new BigDecimal(1));
        request.setRemainingStock(1L);

        String requestStringValue = request.toString();

        assertThat(requestStringValue).isEqualTo("BookCreateRequest{name='name', description='description', writer='writer', price=1, remainingStock=1}");

    }
}
