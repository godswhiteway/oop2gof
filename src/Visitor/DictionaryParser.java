/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import Iterator.Implemention;
import Iterator.StringCollection;
import Iterator.StringIterator;
import Iterator.StringTypeEnum;
import Iterator.Word;
import Singleton.Dictionary;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author okann
 */
public class DictionaryParser extends CheckSpelling {
    private static final String DICTIONARY_FILE = "words.txt";
    static{
        
    }
    public static HashMap<Character, RangedWords> parseDict(String filename){
        HashMap<Character, RangedWords> parsed = new HashMap<>();
        StringIterator baseIterator = Dictionary.getInstance();
        List<String> dictWords = new ArrayList();
        Character tmp2 = ' ';
        while(baseIterator.hasNext()){
            String tmp = baseIterator.next().cleanWord().toLowerCase();
            if(!parsed.containsKey(tmp.charAt(0))){
                if(tmp2 != tmp.charAt(0)){
                   
                    parsed.put(tmp2, new RangedWords(dictWords.toArray()));
                    tmp2 = tmp.charAt(0);
                    
                }else{
                dictWords.add(tmp);
                }
            }else{
                dictWords.add(tmp);
            }
        
        }
    return parsed;
    }
}

