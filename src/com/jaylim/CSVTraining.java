package com.jaylim;

import com.opencsv.CSVReaderHeaderAware;

import java.io.FileReader;
import java.util.Map;

public class CSVTraining {
    public static void main(String[] args) throws Exception {
        /*try(CSVReader reader = new CSVReader(new FileReader("items.csv"))) {
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                for (String e : nextLine) {
                    System.out.format("%s ", e);
                }
            }
        } finally {

        }*/
        CSVReaderHeaderAware csv = new CSVReaderHeaderAware(new FileReader("items.csv"));
        Map<String, String> values = csv.readMap();
        while (values != null) {
            for (Map.Entry<String, String> entry : values.entrySet()) {
                System.out.println(entry.getValue());
            }

            System.out.println("===");

            values = csv.readMap();
        }
    }
}
