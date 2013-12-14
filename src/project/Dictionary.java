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
    
    public double getAVGKeyStrokes(){
        return 0.0;
        /*Para la obtención de los KeyStrokes me he dado cuenta de una característica al usar un trie:
        * La cantidad de KeyStrokes necesarios para escribir una palabra usando este sistema
        * es igual a el número de "padres" de la palabra que tienen dos hijos y/o son palabras completas.
        * Pienso que podemos tomar la sugerencia que hizo el profesor en una de las clases y marcar
        * las palabras completas con el símbolo "$" al finalizar la misma
        */
    }    
    
    public Dictionary(){
        this.words= new ArrayList<Word>();
    }
    
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
                double prom = d.getAVGKeyStrokes();
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
