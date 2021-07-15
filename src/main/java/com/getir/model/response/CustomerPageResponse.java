package com.getir.model.response;

import com.getir.model.dto.OrderDTO;
import org.springframework.data.domain.Page;

public class CustomerPageResponse {

    private Page<OrderDTO> orderDTOS;

    public Page<OrderDTO> getOrderDTOS() {
        return orderDTOS;
    }

    public void setOrderDTOS(Page<OrderDTO> orderDTOS) {
        this.orderDTOS = orderDTOS;
    }

    @Override
    public String toString() {
        return "CustomerPageResponse{" +
                "orderDTOS=" + getOrderDTOS() +
                '}';
    }
}
