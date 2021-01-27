/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2j;

import Command.ExitCommand;
import Command.NewCommand;
import Command.OpenCommand;
import Command.SaveCommand;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author okann
 */
public class TextEditor extends JFrame implements ActionListener {

    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenuItem newItem;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem fixItem;
    JMenuItem changeWordItem;
    JMenuItem exitItem;
    TextEditor(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("TextEditor");
        this.setSize(600,600);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(580,550));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //menu kisimi
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        editMenu = new JMenu("Edit");
        fixItem = new JMenuItem("Fix Misspellings");
        changeWordItem = new JMenuItem("Change word");
        editMenu.add(fixItem);
        editMenu.add(changeWordItem);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);


        //--
        this.setJMenuBar(menuBar);
        this.add(scrollPane);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose destination.");
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if(e.getSource()==exitItem){
            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                ExitCommand a = new ExitCommand(this,textArea,jfc.getSelectedFile().getAbsolutePath());
                a.execute();
            }    
            ExitCommand a = new ExitCommand(this,textArea,jfc.getSelectedFile().getAbsolutePath());
            a.execute();
        }else if(e.getSource()==openItem){
            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                OpenCommand a = new OpenCommand(jfc.getSelectedFile().getAbsolutePath(),textArea);
                this.setTitle(jfc.getSelectedFile().getName());
                a.execute();
            }    
        }else if(e.getSource()==saveItem){
            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
            SaveCommand a = new SaveCommand(jfc.getSelectedFile().getAbsolutePath(),textArea);
            a.execute();
            }
        }else if(e.getSource()==newItem){
            NewCommand a = new NewCommand(textArea);
            a.execute();
        }
    }
 }

