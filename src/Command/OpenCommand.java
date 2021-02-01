/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author okann
 */
public class OpenCommand implements Command{
    private String filename;	
    private JTextArea main;
    public OpenCommand(String filename,JTextArea main) {
		this.filename = filename;
                this.main = main;
	}
    @Override
    //fill the textarea with txt file
    public void execute() {
        String text = "";
        File f = new File(filename);
        try{
            FileReader read = new FileReader(f);
            Scanner scan = new Scanner(read);
            while(scan.hasNextLine()){
                String line = scan.nextLine() + "\n";
                text = text + line;
        }
            main.setText(text);
        }
    catch ( FileNotFoundException ex) { ex.printStackTrace(); }
}

    @Override
    
    public void undo() {
        main.setText("");
    }

    @Override
    public boolean isReversible() {
        return true;
    }
}


