package model;

public class BillingReport {

    String company;
    Double receiptTotalValue;
    Double invoiceTotalValue;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getReceiptTotalValue() {
        return receiptTotalValue;
    }

    public void setReceiptTotalValue(Double receiptTotalValue) {
        this.receiptTotalValue = receiptTotalValue;
    }

    public Double getInvoiceTotalValue() {
        return invoiceTotalValue;
    }

    public void setInvoiceTotalValue(Double invoiceTotalValue) {
        this.invoiceTotalValue = invoiceTotalValue;
    }

    @Override
    public String toString() {
        return "{\"BillingReport\": {" +
                "\"invoiceTotalValue\": " + this.getInvoiceTotalValue() +
                "}}";
    }
}
