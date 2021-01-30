/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import ChainofResponsibility.FixSingleTr;
import ChainofResponsibility.ProceedProcess;
import ChainofResponsibility.ValidationChars;
import ChainofResponsibility.ValidationLengths;
import ChainofResponsibility.ValidationSingleTrans;
import Iterator.Word;
import Memento.CareTaker;
import Memento.Originator;
import NotDesigned.RangedWords;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author okann
 */
public class fixItemCommand implements Command {

    private JTextArea main;
    private HashMap<Character, RangedWords> parsed;
    private String old;
    public fixItemCommand(JTextArea main, HashMap<Character, RangedWords> dictionary) {

        this.main = main;
        this.parsed = dictionary;
        this.old = main.getText();
    }

    @Override
    public void execute() {
      FixSingleTr c = new FixSingleTr();
      ProceedProcess d = new ValidationLengths();
      d.linkWith(new ValidationChars()).linkWith(new ValidationSingleTrans());
      c.setProceedProcess(d);
        String text = main.getText();
        ArrayList<String> arrList = new ArrayList<>(Arrays.asList(text));
        ArrayList<Word> words = new ArrayList<>();
        for (String line : arrList) {
            for (String word : line.split("\\r?\\n")) {
                Scanner s2 = new Scanner(word);
                while (s2.hasNext()) {
                    String y = s2.next();
                    words.add(new Word(y + " "));
                    
                    if(s2.hasNext() == false){
                        words.add(new Word("\n"));
                    }
                }
            }
        }
        try{
        for(Word a:words){
            for(int i=0;i<a.cleanWord().length();i++){
                for(String wordarray : parsed.get(a.cleanWord().toLowerCase().charAt(i)).getWords()){
                String tmp = c.fix(a, new Word(wordarray));
                if(!"".equals(tmp)){
                    a.setWordself(tmp + " ");
                    
                }

            }        
            }
        }
        }catch(StringIndexOutOfBoundsException e){e.printStackTrace();
        }
        String newtext = "";
        for(Word a: words){
            newtext += a;
    }
    main.setText(newtext);
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
