package model;

import java.awt.*;
import javax.swing.*;

import var.Vars;


public class NorthPanel extends JPanel{
	private Color rentForeColor=null,rentBackColor=null;
	private JButton changeForeColorButton = new JButton("设置前景色");
	private JButton changeBackColorButton = new JButton("设置背景色");
	private JTextField textField = new JTextField(20);
	private JPanel esPanel = new JPanel();
	
	private JPanel sizePanel = new JPanel();
	private JLabel sizeLabel = new JLabel("Size");
	
	SpinnerNumberModel model = new SpinnerNumberModel(15,0,50,1);
	private JSpinner sizeSpinner = new JSpinner(model);
	
	private JCheckBox checkBox = new JCheckBox("Fill the region");
	public NorthPanel() {
		setLayout(new GridLayout(2,2));
		changeForeColorButton.setOpaque(true);
		changeForeColorButton.setBorderPainted(false);
		changeBackColorButton.setOpaque(true);
		changeBackColorButton.setBorderPainted(false);
		textField.setText("Type Text Here");
		
		add(changeForeColorButton);
		add(changeBackColorButton);
		add(textField);
		add(esPanel);
		esPanel.setLayout(new GridLayout(1,2));
		esPanel.add(sizePanel);
		esPanel.add(checkBox);
		sizePanel.setLayout(new GridLayout(1,2));
		sizePanel.add(sizeLabel);
		sizePanel.add(sizeSpinner);
		
		changeForeColorButton.addActionListener(e ->{
			JColorChooser colorChooser =new JColorChooser();
			JDialog dialog = JColorChooser.createDialog(Vars.northPanel, "请选择颜色", false, colorChooser, e1 -> {
				Vars.paintPanel.repaint();
				Vars.controller.setForeColor(colorChooser.getColor());
				Vars.paintPanel.repaint();
				rentForeColor = colorChooser.getColor();
				changeForeColorButton.setBackground(rentForeColor);
			}, null);
			dialog.setVisible(true);
			rentForeColor = colorChooser.getColor();
		});
		changeBackColorButton.addActionListener(e ->{
			JColorChooser colorChooser =new JColorChooser();
			JDialog dialog = JColorChooser.createDialog(Vars.northPanel, "请选择颜色", false, colorChooser, e1 -> {
				Vars.controller.setBackColor(colorChooser.getColor());
				Vars.paintPanel.repaint();
				rentBackColor = colorChooser.getColor();
				changeBackColorButton.setBackground(rentBackColor);
			}, null);
			dialog.setVisible(true);
			rentBackColor = colorChooser.getColor();
		});
		
	//	Vars.controller.setTextString(textField.getText());
	}
	
	public JButton getChangeForeColorButton() {
		return changeForeColorButton;
	}
	public JButton getChangeBackColorButton() {
		return changeBackColorButton;
	}
	public JTextField getTextField() {
		return textField;
	} 
	public JPanel getEsPanel() {
		return esPanel;
	}
	public JPanel getSizePanel() {
		return sizePanel;
	}
	public JSpinner getSizeSpinner() {
		return sizeSpinner;
	}
	public JCheckBox getCheckBox() {
		return checkBox;
	}
	
	
/*	JComboBox<Color> foreComboBox;
	JComboBox<Color> backComboBox;
	
	Color[] colors = {Color.BLACK,Color.BLUE,Color.CYAN,Color.GRAY,Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.WHITE,Color.YELLOW};
	private void disableFocusBackground(JComboBox<Color> box) {
		if(box == null) return;
		Component component = box.getEditor().getEditorComponent();
		if(component instanceof JTextField) {
			JTextField field = (JTextField) component;
			field.setEditable(false);
			field.setSelectionColor(field.getForeground()); 
			box.setEditable(true);
		}
	}
	public NorthPanel(){
		foreComboBox = new JComboBox<>(new DefaultComboBoxModel<>(colors));
		backComboBox = new JComboBox<>(new DefaultComboBoxModel<>(colors));
		textField = new JTextField(20);
		setLayout(new GridLayout(2,2));
		add(foreComboBox);
		add(backComboBox);
		add(textField);
		foreComboBox.setRenderer(aRenderer());	
		backComboBox.setRenderer(aRenderer());
	}
	@SuppressWarnings("serial")
	private DefaultListCellRenderer aRenderer() {
		return new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list,
					Object value,int index,boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				setText("");
				setPreferredSize(new Dimension(50,25));
				setForeground((Color.black));
				setBackground((Color) value);
				disableFocusBackground(foreComboBox);
				disableFocusBackground(backComboBox);
				return this;
			}
			 e1 -> Vars.controller.setForeColor(colorChooser.getColor())
		};
	}
*/
}
