package com.getir.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.getir.model.request.BookCreateRequest;
import com.getir.model.request.BookStockUpdateRequest;
import com.getir.model.request.BookUpdateRequest;
import com.getir.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void it_should_invoke_api_book_create_endpoint() throws Exception {

        BookCreateRequest request = new BookCreateRequest();

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectWriter.writeValueAsString(request);

        mockMvc.perform(post("/api/book").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    public void it_should_invoke_api_book_update_endpoint() throws Exception {

        BookUpdateRequest request = new BookUpdateRequest();

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectWriter.writeValueAsString(request);

        mockMvc.perform(put("/api/book").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    public void it_should_invoke_api_book_delete_endpoint() throws Exception {

        mockMvc.perform(delete("/api/book/1").contentType(MediaType.ALL_VALUE))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public void it_should_thrown_http_media_type_not_supported_exception() throws Exception {

        BookCreateRequest request = new BookCreateRequest();

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectWriter.writeValueAsString(request);

        mockMvc.perform(post("/api/book")
                .contentType(MediaType.TEXT_HTML)
                .content(requestBody))
                .andExpect(status().isUnsupportedMediaType())
                .andReturn();
    }

    @Test
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public void it_should_throw_http_request_method_not_supported_exception() throws Exception {

        mockMvc.perform(get("/api/book"))
                .andExpect(status().isMethodNotAllowed())
                .andReturn();

    }

    @Test
    public void it_should_invoke_api_book_stock_update_endpoint() throws Exception {

        BookStockUpdateRequest request = new BookStockUpdateRequest();

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectWriter.writeValueAsString(request);

        mockMvc.perform(put("/api/book/stock").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody))
                .andExpect(status().isOk()).andReturn();

    }

}
