/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainofResponsibility;

import Iterator.Word;
import java.util.Arrays;

/**
 *
 * @author okann
 */
public class ValidationChars extends ProceedProcess{

    @Override
    //checks are the compared words have the same chars?
    public boolean check(Word a, Word b) {   
        int counter = 0;
        for(int i =0 ; i<a.cleanWord().length();i++){
            if(a.cleanWord().toLowerCase().charAt(i)==b.cleanWord().charAt(i)){
                counter++;
                
            }
        }
        if(counter==a.cleanWord().length()-2 && Arrays.equals(a.getCharAarray(),b.getCharAarray())){
            return checkNext(a,b);
        }
    
        return false;
    }
    
}
