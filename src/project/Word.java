
package project;

import java.util.ArrayList;

public class Word {
    private String word;
    private ArrayList<Word> subWords;
    private int keyStrokes;
    
    
    public Word(){
        this.keyStrokes=0;
        this.subWords= new ArrayList<Word>();
    }
    
    public Word(String word){
        this();
        this.word=word;        
    }

    public int getKeyStrokes() {
        return keyStrokes;
    }

    public void setKeyStrokes(int keyStrokes) {
        this.keyStrokes = keyStrokes;
    }  
    
    public void setWord(String word){
        this.word=word;
    }
    
    public String getWord(){
        return this.word;
    }
    
    public void addSubWord(String Word){
        this.subWords.add(new Word(word));    
    }
    
    public ArrayList<Word> getSubWords(){
        return this.subWords;
    }    
}
