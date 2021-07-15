package com.getir.model.dto;

import com.getir.entity.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class BookLightDTOTest {

    @Test
    public void it_should_convert_to_string_properly() {

        Book book = new Book();
        book.setId(1L);
        book.setName("The Silmarillion");
        book.setDescription("The Silmarillion is a collection of mythopoeic stories.");
        book.setWriter("J. R. R. Tolkien");
        book.setPrice(new BigDecimal(15));
        book.setRemainingStock(10L);

        BookLightDTO dto = book.toLightDTO(book);

        String bookStringValue = dto.toString();

        assertThat(bookStringValue).isEqualTo("BookLightDTO{name='The Silmarillion', writer='J. R. R. Tolkien', price=J. R. R. Tolkien}");
        assertThat(1L).isEqualTo(book.getId());
    }
}
