package com.yearup.deli;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReceiptFileManager {
    public void writeReceipt(String folderPath, Order order){
        String folder = "Receipts";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String fileName = dateFormat.format(new Date()) + ".txt";

        File folderDir = new File(folderPath);
        if (!folderDir.exists()) {
            folderDir.mkdir();
        }
        File receiptFile = new File(folderDir,fileName);
        try (FileWriter writer = new FileWriter(receiptFile)) {
            writer.write("Order Details: \n");
            writer.write("---------------\n");
            writer.write("Date: " + dateFormat.format(new Date()) + "\n");
            writer.write("Total: $" + order.getTotal() + "\n");
            writer.write("Items:\n");
            List<Product> products = order.getProducts();
            for (Product product : products) {
                writer.write("- " + product.getClass().getSimpleName() + " " + product.getType()+ ": $" + product.getPrice() + "\n");
            }

            System.out.println("Receipt saved: " + receiptFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("An error occurred while writing the receipt: " + e.getMessage());
        }
    }
}
