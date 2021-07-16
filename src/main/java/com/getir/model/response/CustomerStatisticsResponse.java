package com.getir.model.response;

import com.getir.model.dto.CustomerStatisticsDTO;

import java.util.List;

public class CustomerStatisticsResponse {

    List<CustomerStatisticsDTO> customerStatistics;

    public List<CustomerStatisticsDTO> getCustomerStatistics() {
        return customerStatistics;
    }

    public void setCustomerStatistics(List<CustomerStatisticsDTO> customerStatistics) {
        this.customerStatistics = customerStatistics;
    }

    @Override
    public String toString() {
        return "CustomerStatisticsResponse{" +
                "customerStatistics=" + getCustomerStatistics() +
                '}';
    }
}
