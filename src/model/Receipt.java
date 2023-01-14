package model;

import utilities.Utils;

public class Receipt {

    private String company;
    private Integer month;
    private Integer year;
    private Double value;
    private String issueDate;
    private Integer bill;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = Utils.validIntegerValue(month);
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = Utils.validIntegerValue(year);
    }

    public Double getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = Utils.monetaryConvert(value);
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public Integer getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = Utils.validIntegerValue(bill);
    }

    @Override
    public String toString() {
        return "\"receipt\": {" +
                "\"company\": " + this.company +
                "}";
    }
}
