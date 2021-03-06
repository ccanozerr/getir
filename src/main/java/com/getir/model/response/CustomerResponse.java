package com.getir.model.response;

import com.getir.model.dto.CustomerDTO;
import com.getir.model.enums.Status;

public class CustomerResponse {

    private CustomerDTO customer;
    private Status status;

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "customer=" + getCustomer() +
                ", status=" + getStatus() +
                '}';
    }
}
