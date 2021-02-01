/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Iterator.Word;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author okann
 */
public class ChangeWordCommand implements Command {
    private JTextArea main;
    private JTextArea word;
    private JTextArea changeto;
    private String old;
    public ChangeWordCommand(JTextArea main,JTextArea word, JTextArea changeto) {
        this.main = main;
        this.word = word;
        this.changeto = changeto;
        this.old = main.getText();
    }

    @Override
    public void execute() {
        
        String text = main.getText();
        ArrayList<String> arrList = new ArrayList<>(Arrays.asList(text));
        ArrayList<Word> words = new ArrayList<>();
        
        for (String line : arrList) {
            for (String word : line.split("\\r?\\n")) {
                Scanner s2 = new Scanner(word);
                while (s2.hasNext()) {
                    String y = s2.next();
                    words.add(new Word(y + " "));//exporting from text area word by word

                    if (s2.hasNext() == false) {
                        words.add(new Word("\n"));//exporting from text area word by word
                    }
                }
            }
        }
    String newtext = "";
    
    for(Word mainword : words){
        if(mainword.cleanWord().toLowerCase().equals(word.getText().toLowerCase())){
            mainword.setWordself(changeto.getText());//change process.
        }
    newtext += mainword.getWordself();//adding to temp string
    }
    main.setText(newtext);//setting textarea changed text
    }

    @Override
    public void undo() {
        main.setText(old);
    }

    @Override
    public boolean isReversible() {
        return true;
    }

}
