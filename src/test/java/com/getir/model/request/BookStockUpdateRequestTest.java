package com.getir.model.request;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class BookStockUpdateRequestTest {

    @Test
    public void it_should_convert_to_string_properly() {

        BookStockUpdateRequest request = new BookStockUpdateRequest();
        request.setId(1L);
        request.setSoldStock(10L);

        String requestStringValue = request.toString();

        assertThat(requestStringValue).isEqualTo("BookStockUpdateRequest{id=1, soldStock=10}");

    }
}
