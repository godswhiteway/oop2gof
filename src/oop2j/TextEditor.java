/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2j;
import Command.ExitCommand;
import Command.OpenCommand;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author okann
 */
public class TextEditor extends JFrame implements ActionListener{
   private static JTextArea area;
   private static JFrame frame;
   private static int returnValue = 0;

   public TextEditor() { run(); }
   public void run() {
   frame = new JFrame("Text Edit");

    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
      Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
    }

        // Set attributes of the app window
    area = new JTextArea();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(area);
    frame.setSize(640, 480);
    frame.setVisible(true);

        // Build the menu
    JMenuBar menu_main = new JMenuBar();
    JMenu menu_file = new JMenu("File");
    JMenu edit_file = new JMenu("Edit");
    JMenuItem menuitem_new = new JMenuItem("New");
    JMenuItem menuitem_open = new JMenuItem("Open");
    JMenuItem menuitem_save = new JMenuItem("Save");
    JMenuItem menuitem_quit = new JMenuItem("Quit");
    JMenuItem menuitem_fixmiss = new JMenuItem("Correct");
    menuitem_new.addActionListener(this);
    menuitem_open.addActionListener(this);
    menuitem_save.addActionListener(this);
    menuitem_quit.addActionListener(this);
    menuitem_fixmiss.addActionListener(this);
    menu_main.add(menu_file);
    menu_main.add(edit_file);
    menu_file.add(menuitem_new);
    menu_file.add(menuitem_open);
    menu_file.add(menuitem_save);
    menu_file.add(menuitem_quit);
    edit_file.add(menuitem_fixmiss);
        frame.setJMenuBar(menu_main);
    }

@Override
public void actionPerformed(ActionEvent e) {
    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    jfc.setDialogTitle("Choose destination.");
    jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

    String ae = e.getActionCommand();
    if (ae.equals("Open")) {
        returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
        OpenCommand a = new OpenCommand(jfc.getSelectedFile().getAbsolutePath(),area);
        a.execute();
    // SAVE
    } else if (ae.equals("Save")) {
        returnValue = jfc.showSaveDialog(null);
        try {
            File f = new File(jfc.getSelectedFile().getAbsolutePath());
            FileWriter out = new FileWriter(f);
            out.write(area.getText());
            out.close();
        } catch (FileNotFoundException ex) {
            Component f = null;
            JOptionPane.showMessageDialog(f,"File not found.");
        } catch (IOException ex) {
            Component f = null;
            JOptionPane.showMessageDialog(f,"Error.");
        }
    } else if (ae.equals("New")) {
        area.setText("");
    } else if (ae.equals("Quit")) { 
        returnValue = jfc.showSaveDialog(null);
        ExitCommand a = new ExitCommand(frame,area,jfc.getSelectedFile().getAbsolutePath());
        a.execute();
    }
  }
}

}
