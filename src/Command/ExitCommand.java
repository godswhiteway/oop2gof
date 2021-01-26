/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author okann
 */
public class ExitCommand implements Command{
    private JFrame main;
    private int proceed;
    private JTextArea area;
    private String destination;
    public ExitCommand(JFrame main,JTextArea area,String destination){
        this.main = main;
        this.area = area;
        this.destination = destination;
    }
    @Override
    public void execute() {
        dialogBox(main);
        if(proceed == JOptionPane.YES_OPTION){
            SaveCommand save = new SaveCommand(destination,area);
            save.execute();
            System.exit(0);
        }else if(proceed == JOptionPane.NO_OPTION){
            System.exit(0);
        }else{
            //nothing to do
        }
    }

    @Override
    public void undo() {
//nothing to do
    }

    @Override
    public boolean isReversible() {return false;    }
	public void dialogBox(JFrame main) {
		this.proceed = JOptionPane.showConfirmDialog(main,"want to save?", "ALERT",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

	}    
}
