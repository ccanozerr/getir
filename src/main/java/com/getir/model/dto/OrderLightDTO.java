package com.getir.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderLightDTO {

    private BigDecimal totalPrice;
    private Date dateCreated;
    private List<BookLightDTO> bookList;

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<BookLightDTO> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookLightDTO> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "OrderLightDTO{" +
                "totalPrice=" + totalPrice +
                ", dateCreated=" + dateCreated +
                ", bookList=" + bookList +
                '}';
    }
}
