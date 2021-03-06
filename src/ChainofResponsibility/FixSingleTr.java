/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainofResponsibility;

import Iterator.Word;

/**
 *
 * @author okann
 */
public class FixSingleTr {
    
    private ProceedProcess valid;
    
    public void setProceedProcess(ProceedProcess valid) {
        this.valid = valid;
    }
    
    public String fix(Word str1, Word str2) {
        String temp2 = "";
        
        if (valid.check(str1, str2)) {
            //Changes the word respectfully,
            //ex: AlYl ==> AlLy
            
            String temp = str1.cleanWord();
            for (int i = 0; i < str2.getWordself().length(); i++) {
                if (temp.toLowerCase().charAt(i) == str2.getWordself().charAt(i)) {
                    temp2 += temp.charAt(i);
                } else if (temp.toLowerCase().charAt(i) != str2.getWordself().charAt(i) && Character.isUpperCase(temp.charAt(i))) {
                    temp2 += str2.getWordself().toUpperCase().charAt(i);
                } else {
                    temp2 += str2.getWordself().charAt(i);
                }
            }
            //addition for non-letter chars
            char[] list = {'+', ',', '/', '.', '-', ';', ':', '?', '!', '(', ')', '*', '$'};
            for (int y = 0; y < list.length; y++) {
                if (str1.getWordself().toLowerCase().substring(str1.cleanWord().length(), str1.cleanWord().length() + 1).charAt(0) == list[y]) {
                    
                    temp2 += list[y];
                    //for(int i=temp2.length();i<str1.getWordself().length();i++){
                    //    temp2 += str1.getWordself().charAt(i);
                    //}

                }
                
            }
            
            return temp2;
        }
        return temp2;
    }
    
}
