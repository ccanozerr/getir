package com.getir.model.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BookStockUpdateRequest {

    @NotNull(message = "ID can not be null.")
    private Long id;

    @NotNull(message = "SoldStock can not be null.")
    @Min(value = 1, message = "Stock must be higher than 1.")
    private Long soldStock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSoldStock() {
        return soldStock;
    }

    public void setSoldStock(Long soldStock) {
        this.soldStock = soldStock;
    }

    @Override
    public String toString() {
        return "BookStockUpdateRequest{" +
                "id=" + getId() +
                ", soldStock=" + getSoldStock() +
                '}';
    }
}
