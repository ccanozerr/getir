package com.getir.model.response;

import com.getir.model.dto.OrderDTO;
import com.getir.model.enums.Status;

import java.util.List;

public class OrderListResponse {

    private List<OrderDTO> orders;
    private Status status;

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderListResponse{" +
                "orders=" + getOrders() +
                ", status=" + getStatus() +
                '}';
    }
}
