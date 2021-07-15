package com.getir.model.request;

import com.getir.entity.Order;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class CustomerCreateRequest {

    @NotEmpty(message = "Name can not be empty.")
    private String name;

    @NotEmpty(message = "Surname can not be empty.")
    private String surname;

    @Email(message = "Invalid email format")
    private String email;

    private List<Order> orderList;

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
        return "CustomerCreateRequest{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", orderList=" + getOrderList() +
                '}';
    }
}
