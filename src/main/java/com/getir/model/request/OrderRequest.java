package com.getir.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class OrderRequest {

    @NotNull(message = "CustomerId can not be null")
    private Long customerID;

    @NotEmpty(message = "Book list can not be empty.")
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
