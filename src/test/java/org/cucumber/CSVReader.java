package test.java.org.cucumber;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static String[] getProducts(int index) {

        BufferedReader br;
        String[][] products = new String[6][4];

        try {
            br = new BufferedReader(new FileReader("src/test/resources/Products.csv"));
//            System.out.println(br.readLine());
            for (int i = 0; i < 6; i++) {
                products[i] = br.readLine().split("\",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products[index];
    }
}
