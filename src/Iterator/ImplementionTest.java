/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author okann
 */
public class ImplementionTest {
    public static void main(String[] args) {
        Scanner sc2 = null;
        StringCollection text = new Implemention();
        StringIterator baseIterator = text.iterator(StringTypeEnum.ALL);        
        try {
        sc2 = new Scanner(new File("hahahaha.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  
        }
        ArrayList<Word> tome = null;
        while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String s = s2.next();
                text.addWord(new Word(s + " "));
            }
            text.addWord(new Word("\n"));
        }
    		while (baseIterator.hasNext()) {
			Word c = baseIterator.next();
			System.out.print(c.toString());
    }
    }
}

