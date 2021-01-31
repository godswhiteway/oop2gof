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
public class ValidationLengths extends ProceedProcess{

    @Override
    //kelimelerin özel karakter olmadan uzunluklarını kontrol eder.
    public boolean check(Word a, Word b) {
        if(a.cleanWord().length()!=b.cleanWord().length()){
            return false;
        }
        return checkNext(a, b);
    }


}
