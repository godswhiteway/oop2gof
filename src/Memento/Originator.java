
package Memento;
public class Originator {
    private String word;
    public void set(String newWord){
        System.out.println(newWord);
        word = newWord;
    }
    public Memento storeInMemento(){
        System.out.println("Saved");
        return new Memento(word);
    }
    public String restoreFromMemento(Memento memento){
        word = memento.getWord();
        System.out.println("what");
        return word; 
    }
}
