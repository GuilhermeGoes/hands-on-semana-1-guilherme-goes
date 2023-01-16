package utilities;

import model.BillingReport;
import model.Invoice;
import model.Receipt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public final class FileUtils {

    private static final Logger LOGGER = Logger.getLogger(FileUtils.class.getName());

    public static ArrayList<Invoice> readInvoiceFile(String filename) throws IOException {
        var invoiceList = new ArrayList<Invoice>();

        BufferedReader reader = new BufferedReader(new FileReader(String.format("%s/%s.txt", "resources", filename)));
        reader.readLine();

        try {
            String line = reader.readLine();

            while(line != null) {
                var invoice = new Invoice();
                String[] invoiceInfo = line.split(";", 9);

                invoice.setCompany(invoiceInfo[0]);
                invoice.setMonth(invoiceInfo[1]);
                invoice.setYear(invoiceInfo[2]);
                invoice.setFirstInstallmentDate(invoiceInfo[3]);
                invoice.setFirstInstallment(invoiceInfo[4]);
                invoice.setSecondInstallmentDate(invoiceInfo[5]);
                invoice.setSecondInstallment(invoiceInfo[6]);
                invoice.setThirdInstallmentDate(invoiceInfo[7]);
                invoice.setThirdInstallment(invoiceInfo[8]);

                 invoiceList.add(invoice);
                line = reader.readLine();
            }

        } catch(IOException e) {
            LOGGER.severe("ERRO NA LEITURA DE ARQUIVO");
        }

        reader.close();

        return invoiceList;
    }

    public static ArrayList<Receipt> readReceiptFile(String filename) throws IOException {
        var receiptList = new ArrayList<Receipt>();

        BufferedReader reader = new BufferedReader(new FileReader(String.format("%s/%s.txt", "resources", filename)));
        reader.readLine();

        try {
            String line = reader.readLine();

            while(line != null) {
                var receipt = new Receipt();
                String[] receiptInfo = line.split(";", 6);

                receipt.setCompany(receiptInfo[0]);
                receipt.setMonth(receiptInfo[1]);
                receipt.setYear(receiptInfo[2]);
                receipt.setValue(receiptInfo[3]);
                receipt.setIssueDate(receiptInfo[4]);
                receipt.setBill(receiptInfo[5]);

                receiptList.add(receipt);
                line = reader.readLine();
            }

        } catch(IOException e) {
            LOGGER.severe("ERRO NA LEITURA DE ARQUIVO");
        }

        reader.close();
        return receiptList;
    }

    public static void writeFile(String filename, List<BillingReport> report) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(String.format("%s/%s.json", "resources", filename))
        );

        report.forEach(
                line -> {
                    try {
                        writer.append(line.toString());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        writer.close();
    }
}
