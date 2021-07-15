package com.getir.model.response;

import com.getir.model.dto.CustomerLightDTO;
import com.getir.model.dto.OrderLightDTO;

import java.util.List;

public class CustomerResponse {

    private CustomerLightDTO customer;
    private List<OrderLightDTO> orderList;

    public CustomerLightDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerLightDTO customer) {
        this.customer = customer;
    }

    public List<OrderLightDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderLightDTO> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "customer=" + getCustomer() +
                ", orderList=" + getOrderList() +
                '}';
    }
}
