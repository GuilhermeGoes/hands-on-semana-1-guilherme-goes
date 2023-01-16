import services.BillingService;
import utilities.FileUtils;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        var invoices = FileUtils.readInvoiceFile("faturamento");
        var reports = FileUtils.readReceiptFile("nota");

        System.out.println("Digite o ano para o relatório");
        int year = scanner.nextInt();

        var service = new BillingService();

        service.compareBillings(invoices, reports, year);
    }
}