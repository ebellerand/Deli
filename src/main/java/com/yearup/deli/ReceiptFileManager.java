package com.yearup.deli;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptFileManager {
    private static void writeReceipt(String folderPath, String content){
        String folder = "Receipts";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String fileName = dateFormat.format(new Date()) + ".txt";

    }
}
