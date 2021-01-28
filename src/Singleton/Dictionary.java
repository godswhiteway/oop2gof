/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import Iterator.Implemention;
import Iterator.StringCollection;
import Iterator.StringIterator;
import Iterator.StringTypeEnum;
import Iterator.Word;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author okann
 */
public class Dictionary {
       private static StringIterator a = getDictionary("words.txt");
       private Dictionary(){}
       public static StringIterator getInstance(){
        return a;
   }
       private static StringIterator getDictionary(String filename){
        Scanner sc2 = null;
        StringCollection text = new Implemention();
        StringIterator baseIterator = text.iterator(StringTypeEnum.STRING);        
        try {
        sc2 = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  
        }
        while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String s = s2.next();
                text.addWord(new Word(s));
            }
        }           
       return baseIterator;
       }
}
