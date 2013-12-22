package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Dictionary {

    private ArrayList<Word> words;
    private int size;

    public double getAVGKeyStrokes() {
        double avg = getKSAmount(words);
        return size != 0 ? avg /= size : 0;
    }

    private int getKSAmount(ArrayList<Word> list) {
        if (list == null) {
            return 0;
        }
        int ks = 0;
        for (Word word : list) {
            if (list.size() > 1 || (list.size() < 2 && word.getWord().endsWith("$"))) {
                ks++;
            }
            ks += getKSAmount(word.getSubWords());
        }
        return ks;
    }

    public Dictionary() {
        this.words = new ArrayList<Word>();
        this.size = 0;
    }

    public void addWord(String word) {
        /////////////////////////////
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
                double prom = d.getAVGKeyStrokes();
                DecimalFormat df = new DecimalFormat("0.00");
                writer.write(df.format(prom) + "\n");
                System.out.println(df.format(prom));
            }
            writer.close();
        } catch (Exception ex) {
            System.out.println("file writing not possible");
        }
    }
}
