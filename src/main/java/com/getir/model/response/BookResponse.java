package com.getir.model.response;

import com.getir.model.dto.BookDTO;
import com.getir.model.enums.Status;

public class BookResponse {

    private BookDTO book;
    private Status status;

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookResponse{" +
                "book=" + getBook() +
                ", status=" + getStatus() +
                '}';
    }
}
