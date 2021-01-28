/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.awt.TextArea;
import javax.swing.JTextArea;

/**
 *
 * @author okann
 */
public class InsertCommand implements Command{
    private String a;
    private JTextArea  b;
    public InsertCommand(String a,JTextArea b){
        this.a = a;
        this.b = b;
                
    }
    @Override
    public void execute() {
        b.append(a);
        
    }

    @Override
    public void undo() {
        String text = b.getText();
        int lastIndex = text.lastIndexOf(" ");
        text = text.substring(0,lastIndex);
        b.setText(text);
    }


    @Override
    public boolean isReversible() {
        return true;
    }
    
}
