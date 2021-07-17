package com.getir.entity;

import com.getir.model.dto.BookDTO;
import com.getir.model.dto.BookLightDTO;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

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
        return "Book{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", writer='" + getWriter() + '\'' +
                ", price=" + getPrice() +
                ", remainingStock=" + getRemainingStock() +
                '}';
    }

    public BookDTO toDTO(Book book) {

        BookDTO dto = new BookDTO();
        dto.setId(getId());
        dto.setName(getName());
        dto.setDescription(getDescription());
        dto.setWriter(getWriter());
        dto.setPrice(getPrice().doubleValue());
        dto.setRemainingStock(getRemainingStock());

        return dto;
    }

    public BookLightDTO toLightDTO(Book book) {

        BookLightDTO lightDTO = new BookLightDTO();
        lightDTO.setName(getName());
        lightDTO.setPrice(getPrice());
        lightDTO.setWriter(getWriter());

        return lightDTO;
    }
}
