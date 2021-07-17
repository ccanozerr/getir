package com.getir.service;

import com.getir.entity.Book;
import com.getir.exception.EntityNotExistException;
import com.getir.exception.SoldStockCannotGreaterThanOldStockException;
import com.getir.model.enums.Status;
import com.getir.model.request.BookCreateRequest;
import com.getir.model.request.BookStockUpdateRequest;
import com.getir.model.request.BookUpdateRequest;
import com.getir.model.response.BookResponse;
import com.getir.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class BookService {

    private final Logger logger = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse createBook(BookCreateRequest request) {

        Book book = new Book();
        book.setName(request.getName());
        book.setDescription(request.getDescription());
        book.setWriter(request.getWriter());
        book.setPrice(request.getPrice());
        book.setRemainingStock(request.getRemainingStock());

        bookRepository.save(book);

        logger.info("Book saved successfully! {}", book);

        BookResponse response = new BookResponse();
        response.setStatus(Status.SUCCESS);
        response.setBook(book.toDTO(book));

        return response;

    }

    public BookResponse updateBook(BookUpdateRequest request) {
        
        Book book = bookRepository.findById(request.getId())
                .orElseThrow(() -> new EntityNotExistException(String.valueOf(request.getId())));

        book.setName(request.getName());
        book.setDescription(request.getDescription());
        book.setWriter(request.getWriter());
        book.setPrice(request.getPrice());
        book.setRemainingStock(request.getRemainingStock());

        bookRepository.save(book);

        logger.info("Book updated successfully! {}", book);

        BookResponse response = new BookResponse();
        response.setStatus(Status.SUCCESS);
        response.setBook(book.toDTO(book));

        return response;
    }

    public BookResponse deleteBook(Long id) {

        BookResponse response = new BookResponse();

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotExistException(String.valueOf(id)));

        response.setBook(book.toDTO(book));

        bookRepository.delete(book);

        logger.info("Book deleted successfully! {}", book);

        response.setStatus(Status.SUCCESS);

        return response;

    }

    public BookResponse updateBookStock(BookStockUpdateRequest request) {

        Book book = bookRepository.findById(request.getId())
                .orElseThrow(() -> new EntityNotExistException(String.valueOf(request.getId())));

        if(book.getRemainingStock() < request.getSoldStock())
            throw new SoldStockCannotGreaterThanOldStockException();

        book.setRemainingStock(book.getRemainingStock() - request.getSoldStock());

        bookRepository.save(book);

        logger.info("Book stock updated successfully! {}", book);

        BookResponse response = new BookResponse();
        response.setStatus(Status.SUCCESS);
        response.setBook(book.toDTO(book));

        return response;
    }
}
