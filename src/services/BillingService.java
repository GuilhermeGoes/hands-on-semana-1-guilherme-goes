package services;

import model.BillingReport;
import model.Invoice;
import model.Receipt;
import utilities.FileUtils;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class BillingService {

    private static final Logger LOGGER = Logger.getLogger(BillingService.class.getName());
    private static Scanner scanner = new Scanner(System.in);

    public void execute() throws IOException {

        var invoices = FileUtils.readInvoiceFile("faturamento");
        var receipts = FileUtils.readReceiptFile("nota");

        LOGGER.info("ARQUIVOS LIDOS");

        System.out.println("Digite o ano para o relatório: ");
        int year = scanner.nextInt();

        genReports(invoices, receipts, year);

        LOGGER.info("ARQUIVOS GERADOS COM SUCESSO");
    }

    private void genReports(ArrayList<Invoice> invoices, ArrayList<Receipt> receipts, int year) throws IOException {
        var billings = compareBillings(invoices, receipts, year);

        var conformities = billings.stream()
                .filter(bill -> Objects.equals(bill.getReceiptTotalValue(), bill.getInvoiceTotalValue()))
                .toList();

        FileUtils.writeFile(String.format("empresas_em_conformidades_%s", year), conformities);

        var nonConformities = billings.stream()
                .filter(bill -> !Objects.equals(bill.getInvoiceTotalValue(), bill.getReceiptTotalValue()))
                .toList();

        FileUtils.writeFile(String.format("empresas_em_não_conformidades_%s", year), nonConformities);
    }

    private ArrayList<BillingReport> compareBillings(ArrayList<Invoice> invoices, ArrayList<Receipt> receipts, int year) {

        ArrayList<BillingReport> billingReports = new ArrayList<BillingReport>();

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
                receipt -> {
                    var br = new BillingReport();
                    br.setCompany(receipt.getKey());

                    var companyFiltered = grCompanyInv.entrySet()
                            .stream()
                            .filter(inv -> Objects.equals(inv.getKey(), receipt.getKey()))
                            .map(h -> h.getValue()).toList();

                    if (companyFiltered.isEmpty()) { return; }

                    companyFiltered.stream().forEach(
                            cf -> br.setInvoiceTotalValue(
                                    cf.stream().mapToDouble(Invoice::getTotalInstallment).sum()
                            )
                    );

                    br.setReceiptTotalValue(receipt.getValue().stream().mapToDouble(Receipt::getValue).sum());
                    billingReports.add(br);
                }
        );

        return billingReports;
    }

    private List<Invoice> getYearInvoice(int year, ArrayList<Invoice> invoices) {
        return invoices.stream().filter(f -> f.getYear() == year).toList();
    }

    private List<Receipt> getYearReceipt(int year, ArrayList<Receipt> receipts) {
        return receipts.stream().filter(f -> f.getYear() == year).toList();
    }

}
