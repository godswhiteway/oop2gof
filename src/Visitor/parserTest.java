/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author okann
 */
public class parserTest {
    public static void main(String[] args) {
        HashMap<Character, RangedWords> a = DictionaryParser.parseDict("words.txt");
        for(Object t: a.get('z').getWords()){
            System.out.println(t);
        }

    
}
}