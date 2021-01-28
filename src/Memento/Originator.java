/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memento;

import javax.swing.text.Document;

/**
 *
 * @author okann
 */
public class Originator {
   private Document state;

   public void setState(Document state){
      this.state = state;
   }

   public Document getState(){
      return state;
   }

   public Memento saveStateToMemento(){
      return new Memento(state);
   }

   public void getStateFromMemento(Memento memento){
      state = memento.getState();
   }
}
