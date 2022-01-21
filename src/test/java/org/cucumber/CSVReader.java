package org.cucumber;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static String[] getProducts() {

        BufferedReader br;
        String[] products = new String[6];

        try {
            br = new BufferedReader(new FileReader("src/test/resources/Products.csv"));
//            System.out.println(br.readLine());
            for (int i = 0; i < 6; i++) {
                products[i] = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }
}
