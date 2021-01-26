package Memento;

import java.util.ArrayList;

class Caretaker {
    ArrayList<Memento> savedWords = new ArrayList<Memento>();
    public void addMemento(Memento m){savedWords.add(m);}
    public Memento getMemento(int index){return savedWords.get(index);}
}
