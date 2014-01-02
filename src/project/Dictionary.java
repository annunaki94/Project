package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Dictionary {

    private int ks;
    private Node root;
    private int size;

    private double getAVGKeyStrokes() {
        ks = 0;
        for(Node nod: root.children){
            calculateKSAmount(nod, 1);
        }        
        return size != 0 ? (double) ks / size : 0;
    }

    private void calculateKSAmount(Node node, int n) {
        if (node == null) {
            return;
        }
        if (node.marker) {
            ks += n;            
        }
        if (node.children.size() > 1 || node.marker) {
            n++;            
        }
        for (Node child : node.children) {
            calculateKSAmount(child, n);
        }
    }
    
    public Dictionary(char c) {
        root = new Node(c);
        size = 0;
    }
    
    public Dictionary(){
        this(' ');
    }
    
    public void addWord(String s) {
        Node current = root;
        if (s.length() == 0) {
            current.marker = true;
        } else {
            for (int i = 0; i < s.length(); i++) {
                Node child = current.subNode(s.charAt(i));
                if (child != null) {
                    current = child;
                } else {
                    current.children.add(new Node(s.charAt(i)));
                    current = current.subNode(s.charAt(i));
                }
                if (i == s.length() - 1) {
                    current.marker = true;
                }
            }
        }
        size++;
    }
    
    public boolean search(String s) {
        Node current = root;
        for (int i = 0; i < s.length(); i++) {
            Node child = current.subNode(s.charAt(i));
            if (child != null) {
                current = child;
            } else {
                return false;
            }
        }
        if (current.marker) {
            return true;
        }
        return false;
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
            }
            writer.close();
        } catch (Exception ex) {
            System.out.println("file writing not possible");
        }
    }
}
