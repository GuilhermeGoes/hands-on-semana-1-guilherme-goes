package model;

import utilities.Utils;

import java.text.ParseException;

public class Invoice {

    private String company;
    private Integer month;
    private Integer year;
    private String firstInstallmentDate;
    private Double firstInstallmente;
    private String secondInstallmentDate;
    private Double secondInstallmente;
    private String thirdInstallmentDate;
    private Double thirdInstallmente;

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

    public Double getFirstInstallmente() {
        return firstInstallmente;
    }

    public void setFirstInstallmente(String firstInstallmente) {
        this.firstInstallmente = Utils.monetaryConvert(firstInstallmente);
    }

    public String getSecondInstallmentDate() {
        return secondInstallmentDate;
    }

    public void setSecondInstallmentDate(String secondInstallmentDate) {
        this.secondInstallmentDate = secondInstallmentDate;
    }

    public Double getSecondInstallmente() {
        return secondInstallmente;
    }

    public void setSecondInstallmente(String secondInstallmente) {
        this.secondInstallmente = Utils.monetaryConvert(secondInstallmente);
    }

    public String getThirdInstallmentDate() {
        return thirdInstallmentDate;
    }

    public void setThirdInstallmentDate(String thirdInstallmentDate) {
        this.thirdInstallmentDate = thirdInstallmentDate;
    }

    public Double getThirdInstallmente() {
        return thirdInstallmente;
    }

    public void setThirdInstallmente(String thirdInstallmente) {
        this.thirdInstallmente = Utils.monetaryConvert(thirdInstallmente);
    }

    @Override
    public String toString() {
        return "\"invoice\": {" +
                "\"company\": " + this.company +
                "}";
    }
}
