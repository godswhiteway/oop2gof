/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotDesigned;

import ChainofResponsibility.FixSingleTr;
import ChainofResponsibility.ProceedProcess;
import ChainofResponsibility.ValidationChars;
import ChainofResponsibility.ValidationLengths;
import ChainofResponsibility.ValidationSingleTrans;
import Iterator.Word;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author okann
 */
public class parserTest {
    public static void main(String[] args) {
        HashMap<Character, RangedWords> a = DictionaryParser.parseDict("words.txt");
        Word e = new Word("Asd");
      Word b = new Word("ads");
      FixSingleTr c = new FixSingleTr();
      ProceedProcess d = new ValidationLengths();
      d.linkWith(new ValidationChars()).linkWith(new ValidationSingleTrans());
      c.setProceedProcess(d);
      System.out.println(c.fix(e, b));
    
}
}