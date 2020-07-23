package Lyutyy.task8.task04;

public class Contract {
    private int contractNumber;
    private String contractDate;
    private String[] products;

    public Contract(int contractNumber, String contractDate, String[] products) {
        this.contractNumber = contractNumber;
        this.contractDate = contractDate;
        this.products = products;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public String getContractDate() {
        return contractDate;
    }

    public String[] getProducts() {
        return products;
    }
}
