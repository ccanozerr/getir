package com.getir.entity;

import com.getir.model.dto.CustomerDTO;
import com.getir.model.dto.CustomerLightDTO;
import com.getir.model.dto.OrderDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    @NotEmpty(message = "Name can not be empty.")
    private String name;

    @NotEmpty(message = "Surname can not be empty.")
    private String surname;

    @Email(message = "Invalid email format")
    private String email;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Order> orderList;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", orderList=" + getOrderList() +
                '}';
    }

    public CustomerDTO toDTO(Customer customer) {

        CustomerDTO dto = new CustomerDTO();
        dto.setId(getId());
        dto.setName(getName());
        dto.setSurname(getSurname());
        dto.setEmail(getEmail());
        List<OrderDTO> orderDTOS = new ArrayList<>();

        if(Objects.nonNull(getOrderList()))
            getOrderList().forEach(order -> orderDTOS.add(order.toDTO(order)));

        dto.setOrderList(orderDTOS);

        return dto;
    }

    public CustomerLightDTO toLightDTO(Customer customer) {

        CustomerLightDTO lightDTO = new CustomerLightDTO();
        lightDTO.setName(getName());
        lightDTO.setSurname(getSurname());
        lightDTO.setEmail(getEmail());

        return lightDTO;
    }
}
