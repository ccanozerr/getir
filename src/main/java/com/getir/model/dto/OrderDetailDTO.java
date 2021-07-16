package com.getir.model.dto;

public class OrderDetailDTO {

    private Long bookID;
    private Long orderCount;

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public Long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Long orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "bookID=" + getBookID() +
                ", orderCount=" + getOrderCount() +
                '}';
    }
}
