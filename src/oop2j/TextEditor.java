/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2j;

import Command.CommandsInvoker;
import Command.ExitCommand;
import Command.InsertCommand;
import Command.NewCommand;
import Command.OpenCommand;
import Command.SaveCommand;
import Command.fixItemCommand;
import Memento.CareTaker;
import Memento.Originator;
import NotDesigned.DictionaryParser;
import NotDesigned.RangedWords;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
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
public class TextEditor extends JFrame implements ActionListener, KeyListener {

    CommandsInvoker stacks = new CommandsInvoker();
    Originator originator = new Originator();
    CareTaker careTaker = new CareTaker();
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu snapshotMenu;
    JMenuItem newItem;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem fixItem;
    JMenuItem changeWordItem;
    JMenuItem exitItem;
    JMenuItem takesnapshotItem;
    JMenuItem restoresnapshotItem;
    HashMap<Character, RangedWords> dictionary = DictionaryParser.parseDict("words.txt");
    

    TextEditor() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("TextEditor");
        this.setSize(800, 600);
        this.setLayout(new FlowLayout());
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(780, 550));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //menu kisimi
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        snapshotMenu = new JMenu("Snapshots");
        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        textArea.addKeyListener(this);
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        editMenu = new JMenu("Edit");
        fixItem = new JMenuItem("Fix Misspellings");
        changeWordItem = new JMenuItem("Change word");
        takesnapshotItem = new JMenuItem("Take a Snapshot");
        restoresnapshotItem = new JMenuItem("Restore from a snapshot");
        takesnapshotItem.addActionListener(this);
        restoresnapshotItem.addActionListener(this);
        fixItem.addActionListener(this);
        editMenu.add(fixItem);
        editMenu.add(changeWordItem);
        snapshotMenu.add(takesnapshotItem);
        snapshotMenu.add(restoresnapshotItem);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(snapshotMenu);
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
        if (e.getSource() == exitItem) {
            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                ExitCommand a = new ExitCommand(this, textArea, jfc.getSelectedFile().getAbsolutePath());
                stacks.execute(a);
            }
        } else if (e.getSource() == openItem) {
            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                OpenCommand a = new OpenCommand(jfc.getSelectedFile().getAbsolutePath(), textArea);
                this.setTitle(jfc.getSelectedFile().getName());
                stacks.execute(a);
                originator.setState(textArea.getText());
                careTaker.add(originator.saveStateToMemento());

            }
        } else if (e.getSource() == saveItem) {
            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                SaveCommand a = new SaveCommand(jfc.getSelectedFile().getAbsolutePath(), textArea);
                stacks.execute(a);
            }
        } else if (e.getSource() == newItem) {
            NewCommand a = new NewCommand(textArea);
            stacks.execute(a);

        } else if (e.getSource() == takesnapshotItem) {
            originator.setState(textArea.getText());
            careTaker.add(originator.saveStateToMemento());

        } else if (e.getSource() == restoresnapshotItem) {
            originator.getStateFromMemento(careTaker.get(0));
            textArea.setText(originator.getState());
        } else if (e.getSource() == fixItem) {
            fixItemCommand a = new fixItemCommand(textArea,dictionary);
            a.execute();
            }
        }

    

    @Override
    public void keyTyped(KeyEvent e) {
        String a = "";
        if (e.getKeyChar() == ' ') {
            InsertCommand c = new InsertCommand(a, textArea);
            a = "";
            stacks.execute(c);
        } else {
            a += e.getKeyChar();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_Z) && (e.isControlDown())) {
            stacks.undo();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
