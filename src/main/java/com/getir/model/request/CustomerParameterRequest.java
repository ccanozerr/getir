package com.getir.model.request;

public class CustomerParameterRequest {

    private Long id;
    private int page;
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
