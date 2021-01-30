/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotDesigned;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author okann
 */
public class RangedWords implements Iterable<String> {
    private String[] words;

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }
    private int currentSize;
    public RangedWords(Object[] words){
        this.words = objecttoString(words);
        this.currentSize = words.length;
    }

    @Override
    public Iterator<String> iterator(){
        Iterator<String> it = new Iterator<String>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && words[currentIndex] != null;
            }

            @Override
            public String next() {
                return words[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
private String[] objecttoString(Object[] a){
    String[] stringArray = Arrays.copyOf(a, a.length, String[].class);
    return stringArray;
}

}
