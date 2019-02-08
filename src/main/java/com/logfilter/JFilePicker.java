package com.logfilter;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class JFilePicker extends JPanel {
    private String textFieldLabel;
    private String buttonLabel;
     
    private JLabel label;
    private JTextField textField;
    private JButton button;
    private JButton b;
    private JTextField rulesName;
    private JFileChooser fileChooser;
    private JLabel label1;
    private JTextField startTime;
    private JTextField endTime;
    private JLabel stLabel;
    private JLabel endLabel;
    private JLabel jlabeldummy1;
    private JLabel jlabeldummy2;

     
    private int mode;
    public static final int MODE_OPEN = 1;
    public static final int MODE_SAVE = 2;
     
    public JFilePicker(String textFieldLabel, String buttonLabel,String delLabel,String StartTimeLabel,String EndTimeLabel) {
        this.textFieldLabel = textFieldLabel;
        this.buttonLabel = buttonLabel;
         
        fileChooser = new JFileChooser();
         
        //setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setLayout(new GridLayout(4,3));
 
        // creates the GUI
        label = new JLabel(textFieldLabel);
        stLabel = new JLabel(StartTimeLabel);
        endLabel = new JLabel(EndTimeLabel);
        label1 = new JLabel("Give a name for results file");
         
        textField = new JTextField(30);
        button = new JButton(buttonLabel);
        rulesName = new JTextField(30);
        
        startTime = new JTextField("2019-02-05T11:37");
        
        endTime = new JTextField("2019-02-05T13:57");
        
        b = new JButton(delLabel);
       
        jlabeldummy1 = new JLabel(" ");
        jlabeldummy2 = new JLabel(" ");

        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonActionPerformed(evt);   	         
            }
        });
        
        b.addActionListener(new ActionListener() {

      	     public void actionPerformed(ActionEvent e) {

      	    	Temp1 del = new Temp1();
                   
                  try {
                	
					del.convert(getText(),gerRuleFileName(),getStartTime(),getEndTime());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
      	     }
      	
           });
         
        add(label);
        add(textField);
        add(button);
        add(label1);
        add(rulesName);
        add(jlabeldummy1);
        add(stLabel);
        add(startTime);
        add(jlabeldummy2);
        add(endLabel);
        add(endTime);
        add(b);
         
    }
     
    private void buttonActionPerformed(ActionEvent evt) {
        if (mode == MODE_OPEN) {
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        } else if (mode == MODE_SAVE) {
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        }
    }
 
    public void addFileTypeFilter(String extension, String description) {
        FileTypeFilter filter = new FileTypeFilter(extension, description);
        fileChooser.addChoosableFileFilter(filter);
    }
     
    public void setMode(int mode) {
        this.mode = mode;
    }
     
    public String getSelectedFilePath() {
        return textField.getText();
    }
     
    public JFileChooser getFileChooser() {
        return this.fileChooser;
    }

	public String getText() {
		String temp = textField.getText();
		return temp;
	}
	public String gerRuleFileName() {
		String temp = rulesName.getText();
		return temp;
	}
	public String getStartTime() {
		String temp = startTime.getText();
		return temp;
	}
	public String getEndTime() {
		String temp = endTime.getText();
		return temp;
	}
}