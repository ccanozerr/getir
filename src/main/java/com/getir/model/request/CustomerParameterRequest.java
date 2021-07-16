package com.getir.model.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CustomerParameterRequest {

    @NotNull(message = "Id can not be null")
    private Long id;

    @NotNull(message = "Page can not be null")
    @Min(value = 0, message = "Page must be greater or equal 0.")
    private int page;

    @NotNull(message = "Size can not be null")
    @Min(value = 0, message = "Size must be greater or equal 0.")
    private int size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "CustomerParameterRequest{" +
                "id=" + getId() +
                ", page=" + getPage() +
                ", size=" + getSize() +
                '}';
    }
}
