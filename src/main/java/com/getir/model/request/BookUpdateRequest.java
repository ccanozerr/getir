package com.getir.model.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class BookUpdateRequest {

    @NotNull(message = "ID can not be null.")
    private Long id;

    @NotEmpty(message = "Name can not be empty.")
    private String name;

    private String description;

    @NotEmpty(message = "Writer can not be empty.")
    private String writer;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price can not be less than 0.")
    private BigDecimal price;

    @NotNull(message = "Stock can not be null.")
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
        return "BookUpdateRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", writer='" + writer + '\'' +
                ", price=" + price +
                ", remainingStock=" + remainingStock +
                '}';
    }
}
