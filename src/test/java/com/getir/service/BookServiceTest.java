package com.getir.service;

import com.getir.entity.Book;
import com.getir.exception.EntityNotExistException;
import com.getir.model.request.BookCreateRequest;
import com.getir.model.request.BookStockUpdateRequest;
import com.getir.model.request.BookUpdateRequest;
import com.getir.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void it_should_save_book() {

        BookCreateRequest request = new BookCreateRequest();
        request.setName("name");
        request.setDescription("description");
        request.setWriter("writer");
        request.setPrice(new BigDecimal(1));
        request.setRemainingStock(1L);

        bookService.createBook(request);

    }

    @Test
    public void it_should_update_book(){

        Book book = new Book();
        book.setId(1L);

        Mockito.when(bookRepository.findById(book.getId())).thenReturn(java.util.Optional.of(book));

        BookUpdateRequest request = new BookUpdateRequest();
        request.setId(1L);
        request.setName("name");
        request.setDescription("description");
        request.setWriter("writer");
        request.setPrice(new BigDecimal(1));
        request.setRemainingStock(1L);

        bookService.updateBook(request);

    }

    @Test
    public void it_should_delete_book() {

        Book book = new Book();
        book.setId(1L);

        Mockito.when(bookRepository.findById(book.getId())).thenReturn(java.util.Optional.of(book));

        bookService.deleteBook(book.getId());
    }

    @Test(expected = EntityNotExistException.class)
    public void it_should_thrown_entity_not_exist_exception() throws Exception{

        Book book = new Book();
        book.setId(1L);

        Mockito.when(bookRepository.findById(book.getId())).thenThrow(new EntityNotExistException(String.valueOf(book.getId())));

        bookService.deleteBook(book.getId());

    }

    @Test
    public void it_should_update_book_stock(){

        Book book = new Book();
        book.setId(1L);
        book.setRemainingStock(50L);

        Mockito.when(bookRepository.findById(book.getId())).thenReturn(java.util.Optional.of(book));

        BookStockUpdateRequest request = new BookStockUpdateRequest();
        request.setId(1L);
        request.setSoldStock(10L);

        bookService.updateBookStock(request);

    }
}
