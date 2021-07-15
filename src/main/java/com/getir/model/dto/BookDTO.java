package com.getir.model.dto;

import java.math.BigDecimal;

public class BookDTO {

    private Long id;
    private String name;
    private String description;
    private String writer;
    private BigDecimal price;
    private Long remainingStock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getRemainingStock() {
        return remainingStock;
    }

    public void setRemainingStock(Long remainingStock) {
        this.remainingStock = remainingStock;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", writer='" + getWriter() + '\'' +
                ", price=" + getPrice() +
                ", remainingStock=" + getRemainingStock() +
                '}';
    }
}
