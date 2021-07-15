package com.getir.model.dto;

import java.math.BigDecimal;

public class BookLightDTO {

    private String name;
    private String writer;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "BookLightDTO{" +
                "name='" + getName() + '\'' +
                ", writer='" + getWriter() + '\'' +
                ", price=" + getWriter() +
                '}';
    }
}
