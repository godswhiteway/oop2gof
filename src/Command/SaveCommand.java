/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author okann
 */
public class SaveCommand implements Command {
    private String destination;
    private JTextArea area;
    
    public SaveCommand(String destination,JTextArea area){
        this.destination = destination;
        this.area = area;
    }

    @Override
    public void execute() {
        
    try {
            File f = new File(destination);
            FileWriter out = new FileWriter(f);
            out.write(area.getText());
            out.close();
        } catch (IOException ex) {
            Component f = null;
            JOptionPane.showMessageDialog(f,"Error.");
        }
    }

    @Override
    public void undo() {
            //nothing to do
    }

    @Override
    public boolean isReversible() {
        return false;
    }
}
