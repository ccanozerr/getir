package com.getir.model.request;

public class BookStockUpdateRequest {

    private Long id;
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
