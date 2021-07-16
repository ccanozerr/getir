package com.getir.model.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderDetailDTOTest {

    @Test
    public void it_should_convert_to_string_properly() {

        OrderDetailDTO dto = new OrderDetailDTO();
        dto.setBookID(1L);
        dto.setOrderCount(2L);

        String dtoStringValue = dto.toString();

        assertThat(dtoStringValue).isEqualTo("OrderDetailDTO{bookID=1, orderCount=2}");
    }
}
