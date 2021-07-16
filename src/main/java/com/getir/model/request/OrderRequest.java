package com.getir.model.request;

import com.getir.model.dto.OrderDetailDTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class OrderRequest {

    @NotNull(message = "CustomerId can not be null")
    private Long customerID;

    @NotEmpty(message = "Order list can not be empty.")
    private List<OrderDetailDTO> orders;

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public List<OrderDetailDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDetailDTO> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "customerID=" + customerID +
                ", orders=" + orders +
                '}';
    }
}
