package model;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

import var.Vars;

public class SouthPanel extends JPanel{
	int x1,y1,x2,y2;
	JTextField textField1 = new JTextField();
	public SouthPanel(){
		
		
		textField1.setHorizontalAlignment(JTextField.LEFT);
		textField1.setFont(new Font("楷体",Font.PLAIN,15));
		setLayout(new GridLayout(1,1));
		textField1.setEditable(false);
		add(textField1);
	}
	public JTextField getTextField() {
		return textField1;
	}

}