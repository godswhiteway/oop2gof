/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author okann
 */
public class Implemention implements StringCollection{
    private ArrayList<Word> text;

	public Implemention() {
		text = new ArrayList<>();
	}
	public Implemention(ArrayList<Word> textarray) {
		text = textarray;
	}
	public void addWord(Word c) {
		this.text.add(c);
	}

	public void removeWord(Word c) {
		this.text.remove(c);
	}
        @Override
	public StringIterator iterator(StringTypeEnum type) {
		return new StringImplemention(type, this.text);
	}

	private class StringImplemention implements StringIterator {

		private StringTypeEnum type;
		private List<Word> strings;
		private int position;

		public StringImplemention(StringTypeEnum ty,
				ArrayList<Word> texts) {
			this.type = ty;
			this.strings = texts;
		}

		@Override
		public boolean hasNext() {
			while (position < strings.size()) {
				Word c = strings.get(position);
				if ((c.getTYPE().equals(type) || type.equals(StringTypeEnum.ALL))) {
					return true;
				} else
					position++;
			}
			return false;
		}

		@Override
		public Word next() {
			Word c = strings.get(position);
			position++;
			return c;
		}

	}
}
  

