/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotDesigned;

import java.util.HashMap;

/**
 *
 * @author okann
 */
public class testtt {
    public static void main(String[] args) {
        HashMap<Character, RangedWords> dictionary = DictionaryParser.parseDict("words.txt");
        for(String a:dictionary.get('a')){
            System.out.print(a);
        }
    }
}
