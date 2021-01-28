
package Memento;

import javax.swing.JTextArea;
import javax.swing.text.Document;

public class Memento {
   private String doc;

   public Memento(String state){
      this.doc = state;
   }

   public String getState(){
      return doc;
   }	
}
    
