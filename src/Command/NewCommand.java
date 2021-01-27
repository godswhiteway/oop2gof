/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import javax.swing.JTextArea;

/**
 *
 * @author okann
 */
public class NewCommand implements Command {
    private JTextArea area;
    private String old;
    public NewCommand(JTextArea area){
        this.area = area;
        old = area.getText();
    }
    @Override
    public void execute() {
        area.setText("");
    }

    @Override
    public void undo() {
        area.setText(old);
    }

    @Override
    public boolean isReversible() {
        return true;
    }
    
}
