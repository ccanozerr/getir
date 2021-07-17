package com.getir.entity;

import com.getir.model.dto.BookDTO;
import com.getir.model.dto.BookLightDTO;
import com.getir.model.dto.OrderDTO;
import com.getir.model.dto.OrderLightDTO;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    private Long customerId;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price can not be less than 0.")
    private BigDecimal totalPrice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @NotEmpty(message = "Order must have more than one book")
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Book> bookList;

    private Long totalBookCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Long getTotalBookCount() {
        return totalBookCount;
    }

    public void setTotalBookCount(Long totalBookCount) {
        this.totalBookCount = totalBookCount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + getId() +
                ", customerId=" + getCustomerId() +
                ", totalPrice=" + getTotalPrice() +
                ", dateCreated=" + getDateCreated() +
                ", bookList=" + getBookList() +
                ", totalBookCount=" + getTotalBookCount() +
                '}';
    }

    public OrderDTO toDTO(Order order) {

        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setDateCreated(order.getDateCreated());
        dto.setCustomerId(order.getCustomerId());
        dto.setTotalBookCount(order.getTotalBookCount());

        List<BookDTO> bookDTOS = new ArrayList<>();
        order.getBookList().forEach(book -> bookDTOS.add(book.toDTO(book)));

        dto.setBookList(bookDTOS);

        return dto;
    }

    public OrderLightDTO toLightDTO(Order order) {

        OrderLightDTO lightDTO = new OrderLightDTO();
        lightDTO.setDateCreated(order.getDateCreated());
        lightDTO.setTotalPrice(order.getTotalPrice());

        List<BookLightDTO> bookLightDTOS = new ArrayList<>();
        order.getBookList().forEach(book -> bookLightDTOS.add(book.toLightDTO(book)));

        lightDTO.setBookList(bookLightDTOS);

        return lightDTO;

    }
}
