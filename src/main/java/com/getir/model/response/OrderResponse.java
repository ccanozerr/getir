package com.getir.model.response;

import com.getir.model.dto.CustomerLightDTO;
import com.getir.model.dto.OrderLightDTO;

public class OrderResponse {

    private CustomerLightDTO customer;
    private OrderLightDTO order;

    public CustomerLightDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerLightDTO customer) {
        this.customer = customer;
    }

    public OrderLightDTO getOrder() {
        return order;
    }

    public void setOrder(OrderLightDTO order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "customer=" + getCustomer() +
                ", order=" + getOrder() +
                '}';
    }
}
