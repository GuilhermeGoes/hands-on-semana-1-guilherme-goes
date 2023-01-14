package utilities;

import model.Invoice;

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

    public void writeFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        writer.close();
    }
}
