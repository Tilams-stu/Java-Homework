package calculator;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener {
	private final String[] nameStrings= {"%","CE","C","del","1/x","^2","√","/","7","8","9","*","4","5","6","-","1","2","3","+","+/-","0",".","="};
	private final JButton[] buttons = new JButton[nameStrings.length];
	private final JTextField resulTextField = new JTextField("0");
	private final JTextField operaTextField = new JTextField("");
	private boolean isDight = true;
	private double resultNum = 0.0;
	private String operatorString = "=";
	private int flag1 = 0;
	private int flag2 = 2;
	
	
	public Calculator() {
		super("计算器");
		this.init();//***
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.gray);
		this.setLocationRelativeTo(null);
		this.pack();
	}
	
	public void init() {
		resulTextField.setHorizontalAlignment(JTextField.RIGHT);
		operaTextField.setHorizontalAlignment(JTextField.RIGHT);
		resulTextField.setEditable(false);
		operaTextField.setEditable(false);
		JPanel allPanel = new JPanel();
		allPanel.setLayout(new GridLayout(6,4,3,3));
		for (int i = 0; i < nameStrings.length; i++) {
			buttons[i] = new JButton(nameStrings[i]);
			allPanel.add(buttons[i]);
			buttons[i].addActionListener(this);
		}
		
		JPanel topJPanel = new JPanel();
		topJPanel.setLayout(new BorderLayout());
		topJPanel.add("North", operaTextField);
		topJPanel.add("Center",resulTextField);
		
		getContentPane().setLayout(new BorderLayout(3,3));
		getContentPane().add("North",topJPanel);
		getContentPane().add(allPanel);
	}
	
	private double getNumFromText() {
		return Double.parseDouble(resulTextField.getText());
	}
	
	private void getNumber(String num) {
		if(flag2 == 1) return;
		if(isDight) resulTextField.setText(num);
		else if((num.equals(".")) && (!resulTextField.getText().contains("."))) resulTextField.setText(resulTextField.getText() + ".");
		else if(!num.equals(".")) resulTextField.setText(resulTextField.getText() + num);
		isDight = false;
	}
	
	private void c() {
		resulTextField.setText("0");
		operaTextField.setText("");
		isDight = true;
		flag1 = 0;
		operatorString = "=";
	}
	
	private void del() {
		String textString = resulTextField.getText();
		int i = textString.length();
		if(i==0) c();
		if(i>0) {
			textString = textString.substring(0,i-1);
			resulTextField.setText(textString);
		}
	}
	private void getSymbol(String symbol) {
		if(isDight && "+-*/".contains(symbol) && "+-*/".contains(operatorString)) {
			operatorString = symbol;
			operaTextField.setText(getNumFromText()+symbol);
			isDight = true;
			return;
		}
		if(symbol.equals("+")||symbol.equals("-")||symbol.equals("*")||symbol.equals("/")) flag2 = 2;
		if(symbol.equals("%")||symbol.equals("1/x")||symbol.equals("^2")||symbol.equals("√")||symbol.equals("+/-")) flag2 = 1;
		if(flag1 == 1) {
			operaTextField.setText("");
			flag1 = 0;
		}
		if(symbol.equals("=")) flag1 = 1;
		
		switch (operatorString) {
		case "%": {
			resultNum /= 100;
			break;
		}
		case "1/x": {
			if(resultNum == 0.0) {
				flag1 = -1;
				resulTextField.setText("除数不能为零");
				return;
			}
			else resultNum = 1 / resultNum;
			break;
		}
		case "^2": {
			resultNum = resultNum * resultNum;
			break;
		}
		case "√": {
			resultNum = Math.sqrt(resultNum);
			break;
			
		}
		case "/": {
			if(resultNum == 0.0) {
				flag1 = -1;
				resulTextField.setText("除数不能为零");
				return;
			}
			else {
				resultNum /= getNumFromText();
				operaTextField.setText(operaTextField.getText() + getNumFromText() + symbol);
			}
			break;
		}
		case "*": {
			resultNum *= getNumFromText();
			operaTextField.setText(operaTextField.getText() + getNumFromText() + symbol);
			break;
		}
		case "-": {
			resultNum -= getNumFromText();
			operaTextField.setText(operaTextField.getText() + getNumFromText() + symbol);
			break;
		}
		case "+": {
			resultNum += getNumFromText();
			operaTextField.setText(operaTextField.getText() + getNumFromText() + symbol);
			break;
		}
		case "+/-": {
			resultNum *=(-1);
			break;
		}
		case "=": {
			resultNum = getNumFromText();
			operaTextField.setText(operaTextField.getText() + getNumFromText() + symbol);
			break;
			}
		}
		resulTextField.setText(String.valueOf(resultNum));
		operatorString = symbol;
		isDight = true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String labelString =e.getActionCommand();
		
		if(flag1 == -1) {
			c();
		}
		if(labelString.equals("del")) {
			del();
		}
		else if(labelString.equals("CE")){
			resulTextField.setText("0");
		}
		else if(labelString.equals("C")) {
			c();
		}
		else if("0123456789.".contains(labelString)) {
			getNumber(labelString);
		}
		else {
			getSymbol(labelString);
		}
	}
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.setVisible(true);
	}
}
