/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Memento.CareTaker;
import Memento.Originator;
import java.awt.TextArea;
import javax.swing.JTextArea;

/**
 *
 * @author okann
 */
public class InsertCommand implements Command{
    private String a;
    private JTextArea  b;
    private Originator originator;            
    private CareTaker careTaker;  
    public InsertCommand(String a,JTextArea b){
        this.a = a;
        this.b = b;
        originator = new Originator();
        careTaker = new CareTaker();
                
    }
    @Override
    public void execute() {
        originator.setState(b.getText());
        careTaker.add(originator.saveStateToMemento());
        b.append(a);
        
    }

    @Override
    public void undo() {
        //yazılanları geri almaya sağlayan döngü.
            originator.getStateFromMemento(careTaker.get(0));
            b.setText(originator.getState());
        
    }


    @Override
    public boolean isReversible() {
        return true;
    }
    
}
