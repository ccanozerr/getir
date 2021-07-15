package com.getir.model.request;

import java.util.Date;

public class OrderByDateRequest {

    private Date startDate;
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "OrderByDateRequest{" +
                "startDate=" + getStartDate() +
                ", endDate=" + getEndDate() +
                '}';
    }
}
