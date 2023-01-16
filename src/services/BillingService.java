package services;

import model.BillingReport;
import model.Invoice;
import model.Receipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class BillingService {

    public void compareBillings(ArrayList<Invoice> invoices, ArrayList<Receipt> receipts, int year) {

        var yearInvoice = getYearInvoice(year, invoices);
        var yearReceipt = getYearReceipt(year, receipts);

        Map <String, List<Invoice>> grCompanyInv = yearInvoice.parallelStream()
                .collect(Collectors.groupingBy(Invoice::getCompany));

        Map <String, List<Receipt>> grCompanyRpt = yearReceipt.parallelStream()
                .collect(Collectors.groupingBy(Receipt::getCompany));

        grCompanyRpt.entrySet()
                .stream()
                .parallel()
                .forEach(
                e -> {
                    var br = new BillingReport();
                    br.setCompany(e.getKey());

                    var companyFiltered = grCompanyInv.entrySet()
                            .stream()
                            .filter(inv -> Objects.equals(inv.getKey(), e.getKey()))
                            .map(h -> h.getValue()).toList();

                    if (companyFiltered.isEmpty()) {
                        return;
                    }

                    companyFiltered.stream().forEach(
                            cf -> br.setInvoiceTotalValue(cf.stream().mapToDouble(Invoice::getTotalInstallment).sum())
                    );
                }
        );
    }

    private List<Invoice> getYearInvoice(int year, ArrayList<Invoice> invoices) {
        return invoices.stream().filter(f -> f.getYear() == year).collect(Collectors.toList());
    }

    private List<Receipt> getYearReceipt(int year, ArrayList<Receipt> receipts) {
        return receipts.stream().filter(f -> f.getYear() == year).toList();
    }

}
