package utilities;

import model.Invoice;
import model.Receipt;

import java.io.*;
import java.util.ArrayList;

public final class FileUtils {

    public static ArrayList<Invoice> readInvoiceFile(String filename) throws IOException {
        var invoiceList = new ArrayList<Invoice>();

        BufferedReader reader = new BufferedReader(new FileReader(String.format("%s/%s.txt", "resources", filename)));
        reader.readLine();

        try {
            String line = reader.readLine();

            while(line != null) {
                var invoice = new Invoice();
                String[] invoiceInfo = line.split(";");

                invoice.setCompany(invoiceInfo[0]);
                invoice.setMonth(invoiceInfo[1]);
                invoice.setYear(invoiceInfo[2]);
                invoice.setFirstInstallmentDate(invoiceInfo[3]);
                invoice.setFirstInstallmente(invoiceInfo[4]);
                invoice.setSecondInstallmentDate(invoiceInfo[5]);
                invoice.setSecondInstallmente(invoiceInfo[6]);
                invoice.setThirdInstallmentDate(invoiceInfo[7]);
                invoice.setThirdInstallmente(invoiceInfo[8]);

                 invoiceList.add(invoice);
                line = reader.readLine();
            }

        } catch(IOException e) {

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
                String[] receiptInfo = line.split(";");

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

        }

        reader.close();

        return receiptList;
    }

    public void writeFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        writer.close();
    }
}
