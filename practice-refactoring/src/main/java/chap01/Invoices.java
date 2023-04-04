package chap01;

import java.util.List;

public class Invoices {
    private String customerName;
    private List<Performance> performances;

    public Invoices(String customerName, List<Performance> performances) {
        this.customerName = customerName;
        this.performances = performances;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Performance> getPerformances() {
        return performances;
    }
}
