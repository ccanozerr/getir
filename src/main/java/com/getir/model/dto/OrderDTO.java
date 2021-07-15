package com.getir.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Long customerId;
    private BigDecimal totalPrice;
    private Date dateCreated;
    private List<BookDTO> bookList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

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

    public List<BookDTO> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookDTO> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + getId() +
                ", customerId=" + getCustomerId() +
                ", totalPrice=" + getTotalPrice() +
                ", dateCreated=" + getDateCreated() +
                ", bookList=" + getBookList() +
                '}';
    }
}
