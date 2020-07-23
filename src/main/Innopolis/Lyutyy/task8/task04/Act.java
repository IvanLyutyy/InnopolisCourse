package main.Innopolis.Lyutyy.task8.task04;

import java.util.Arrays;

public class Act {
    private int contractNumber;
    private String contractDate;
    private String[] products;
    private String employer;
    private static int actNumber;

    public Act() {
        actNumber++;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public void setProducts(String[] products) {
        this.products = products;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String toString() {
        return "Акт №" + actNumber +
                " по договору №" + contractNumber +
                " от '" + contractDate + '\'' +
                ", включает товары:" + Arrays.toString(products) +
                ", создан:'" + employer + '\'';
    }
}
