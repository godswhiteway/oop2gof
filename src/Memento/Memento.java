
package Memento;

import java.util.ArrayList;
import javax.swing.text.Document;

public class Memento {
   private Document doc;

   public Memento(Document state){
      this.doc = state;
   }

   public Document getState(){
      return doc;
   }	
}
    
