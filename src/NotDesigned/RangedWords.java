/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotDesigned;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author okann
 */
public class RangedWords implements Iterable<Object> {
    private Object[] words;

    public Object[] getWords() {
        return words;
    }

    public void setWords(Object[] words) {
        this.words = words;
    }
    private int currentSize;
    public RangedWords(Object[] words){
        this.words = words;
        this.currentSize = words.length;
    }

    @Override
    public Iterator<Object> iterator(){
        Iterator<Object> it = new Iterator<Object>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && words[currentIndex] != null;
            }

            @Override
            public Object next() {
                return words[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }


}
