package chap01;

import java.util.List;

public class StatementData {
    private String customerName;
    private List<Performance> performances;
    private int totalAmount;
    private int totalVolumeCredits;

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

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalVolumeCredits(int totalVolumeCredits) {
        this.totalVolumeCredits = totalVolumeCredits;
    }

    public int getTotalVolumeCredits() {
        return totalVolumeCredits;
    }
}
