package com.getir.model;

import com.getir.model.dto.BookDTO;

public class OrderDetail {

    private BookDTO book;
    private Long orderCount;

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public Long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Long orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "book=" + getBook() +
                ", orderCount=" + getOrderCount() +
                '}';
    }
}
