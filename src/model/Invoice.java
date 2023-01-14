package model;

import utilities.Utils;

import java.text.ParseException;

public class Invoice {

    private String company;
    private Integer month;
    private Integer year;
    private String firstInstallmentDate;
    private Double firstInstallment;
    private String secondInstallmentDate;
    private Double secondInstallment;
    private String thirdInstallmentDate;
    private Double thirdInstallment;

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

    public String getFirstInstallmentDate() {
        return firstInstallmentDate;
    }

    public void setFirstInstallmentDate(String firstInstallmentDate) {
        this.firstInstallmentDate = firstInstallmentDate;
    }

    public Double getFirstInstallment() {
        return firstInstallment;
    }

    public void setFirstInstallment(String firstInstallment) {
        this.firstInstallment = Utils.monetaryConvert(firstInstallment);
    }

    public String getSecondInstallmentDate() {
        return secondInstallmentDate;
    }

    public void setSecondInstallmentDate(String secondInstallmentDate) {
        this.secondInstallmentDate = secondInstallmentDate;
    }

    public Double getSecondInstallment() {
        return secondInstallment;
    }

    public void setSecondInstallment(String secondInstallment) {
        this.secondInstallment = Utils.monetaryConvert(secondInstallment);
    }

    public String getThirdInstallmentDate() {
        return thirdInstallmentDate;
    }

    public void setThirdInstallmentDate(String thirdInstallmentDate) {
        this.thirdInstallmentDate = thirdInstallmentDate;
    }

    public Double getThirdInstallment() {
        return thirdInstallment;
    }

    public void setThirdInstallment(String thirdInstallment) {
        this.thirdInstallment = Utils.monetaryConvert(thirdInstallment);
    }

    @Override
    public String toString() {
        return "\"invoice\": {" +
                "\"company\": " + this.company +
                "}";
    }
}
