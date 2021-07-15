package com.getir.model.request;

import java.util.List;

public class OrderRequest {

    private Long customerID;
    private List<Long> bookIDs;

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public List<Long> getBookIDs() {
        return bookIDs;
    }

    public void setBookIDs(List<Long> bookIDs) {
        this.bookIDs = bookIDs;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "customerID=" + getCustomerID() +
                ", bookIDs=" + getBookIDs() +
                '}';
    }
}
