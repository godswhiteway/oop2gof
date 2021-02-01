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
      FixSingleTr c = new FixSingleTr();//chainofresponsibility creator
      ProceedProcess d = new ValidationLengths();//link procecss
      d.linkWith(new ValidationChars()).linkWith(new ValidationSingleTrans());//link procecss
      c.setProceedProcess(d);//link procecss
        String text = main.getText();
        ArrayList<String> arrList = new ArrayList<>(Arrays.asList(text));
        ArrayList<Word> words = new ArrayList<>();
        for (String line : arrList) {
            for (String word : line.split("\\r?\\n")) {
                Scanner s2 = new Scanner(word);
                while (s2.hasNext()) {
                    String y = s2.next();
                    words.add(new Word(y + " "));//exporting from text area word by word
                    
                    if(s2.hasNext() == false){
                        words.add(new Word("\n"));//exporting from text area word by word
                    }
                }
            }
        }
        try{
        for(Word a:words){
            for(int i=0;i<a.cleanWord().length();i++){
                for(String wordarray : parsed.get(a.cleanWord().toLowerCase().charAt(i)).getWords()){
                String tmp = c.fix(a, new Word(wordarray));//checking for singletransposition
                if(!"".equals(tmp)){
                    a.setWordself(tmp + " ");//when statement is true change the words string.
                    
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
