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
public class ValidationSingleTrans extends ProceedProcess{

    @Override
    public boolean check(Word a, Word b) {
        for(int i=0;i<a.getWordself().length();i++){
            if(a.getWordself().toLowerCase().charAt(i)!=b.getWordself().toLowerCase().charAt(i)){
                try{
                    if(a.getWordself().toLowerCase().charAt(i+1) != b.getWordself().toLowerCase().charAt(i+1)||a.getWordself().toLowerCase().charAt(i-1) != b.getWordself().toLowerCase().charAt(i-1)){
                        return checkNext(a,b);
                    }
                }catch(StringIndexOutOfBoundsException e){}
            }
        }
    return false;
    }
          
    }
