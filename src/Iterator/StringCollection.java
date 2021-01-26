/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

/**
 *
 * @author okann
 */
public interface  StringCollection {
    	public void addWord(Word c);
	
	public void removeWord(Word c);
    public StringIterator iterator(StringTypeEnum type);
}
