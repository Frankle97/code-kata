package chap01;

import java.util.List;

public class StatementData {
    private String customerName;
    private List<Performance> performances;

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setPerformances(List<Performance> performances) {
        this.performances = performances;
    }

    public List<Performance> getPerformances() {
        return performances;
    }
}
