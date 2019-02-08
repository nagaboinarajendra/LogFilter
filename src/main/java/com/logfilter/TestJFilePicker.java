package com.logfilter;


import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
 
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
 
 
public class TestJFilePicker extends JFrame {
    public TestJFilePicker() {
        super("Test using JFilePicker");
         
        setLayout(new FlowLayout());
 
        // set up a file picker component
        JFilePicker filePicker = new JFilePicker("Select a file", "Browse...","Generate Results File","Enter start Time","Enter End Time");
        filePicker.setMode(JFilePicker.MODE_SAVE);
        filePicker.addFileTypeFilter(".txt", "JPEG Images");
        filePicker.addFileTypeFilter(".mp4", "MPEG-4 Videos");
         
        // access JFileChooser class directly
        JFileChooser fileChooser = filePicker.getFileChooser();
        fileChooser.setCurrentDirectory(new File("D:/"));
         
        // add the component to the frame
        add(filePicker);
         
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 300);	
        setLocationRelativeTo(null);    // center on screen
    }
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestJFilePicker().setVisible(true);
                
            }
        });
    }
 
}