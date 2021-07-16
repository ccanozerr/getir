package com.getir.model.request;

import com.getir.entity.Order;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class CustomerCreateRequest {

    @NotNull(message = "Name can not be null.")
    @Size(min = 3, max = 16, message = "Name must have min 3 and max 16 character.")
    private String name;

    @NotNull(message = "Surname can not be null.")
    @Size(min = 3, max = 16, message = "Name must have min 3 and max 16 character.")
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
