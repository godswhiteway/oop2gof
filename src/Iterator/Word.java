/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

import java.util.Arrays;

/**
 *
 * @author okann
 */
public class Word{
    private String wordself;
    private StringTypeEnum TYPE;

    public String getWordself() {
        return wordself;
    }

    public void setWordself(String wordself) {
        this.wordself = wordself;
    }
    
       
    public Word(String aString){
       wordself = aString;
       if(isInteger(aString)){
           TYPE = StringTypeEnum.INT;
       }else{
           TYPE = StringTypeEnum.STRING;
       }
    }
        
    	public StringTypeEnum getTYPE() {
		return TYPE;
	}
    private boolean isInteger(String str) {
        if(str == null || str.trim().isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                return false;
            } 
        }
        return true;
    }
    public char[] getCharAarray(){
        char[] first = cleanWord().toLowerCase().toCharArray();
        Arrays.sort(first);
        return first;
    }    
    @Override
    public String toString(){
        return getWordself();
    }
    public String cleanWord(){
        return getWordself().replaceAll("[^\\w-]", "");
    }
}

