package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Dictionary {

    public void addWord(String word) {
    }

    public static void main(String[] args) {
        ArrayList<Dictionary> dictionaries = new ArrayList<Dictionary>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("dictionaries.txt")));
            String s;
            while ((s = reader.readLine()) != null) {
                int n = Integer.valueOf(s);
                Dictionary d = new Dictionary();
                dictionaries.add(d);
                for (int i = 0; i < n; i++) {
                    d.addWord(reader.readLine());
                }
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println("no input text found");
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("output.txt")));
            for (Dictionary d : dictionaries) {
                double prom = 65551.0000;
                
                //prom calc
                
                DecimalFormat df = new DecimalFormat("0.00");
                writer.write(df.format(prom)+"\n");
                System.out.println(df.format(prom));                
            }
            writer.close();
        } catch (Exception ex) {
            System.out.println("file writing not possible");
        }
    }
}
