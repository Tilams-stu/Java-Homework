package model;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import control.Controller;
import var.Vars;

public class LeftBar extends JToolBar{
	JToggleButton rectToggleButton,circleToggleButton,texToggleButton,lineToggleButton;
	public LeftBar(){
		lineToggleButton = new JToggleButton("line");
		rectToggleButton = new JToggleButton("rect");
		circleToggleButton = new JToggleButton("cir");
		texToggleButton = new JToggleButton("A");
		
		lineToggleButton.setPreferredSize(new Dimension(40,40));
		rectToggleButton.setPreferredSize(new Dimension(40,40));
		circleToggleButton.setPreferredSize(new Dimension(40,40));
		texToggleButton.setPreferredSize(new Dimension(40,40));
		
		add(lineToggleButton);
		add(rectToggleButton);
		add(circleToggleButton);
		add(texToggleButton);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(lineToggleButton);
		buttonGroup.add(rectToggleButton);
		buttonGroup.add(circleToggleButton);
		buttonGroup.add(texToggleButton);
		
		lineToggleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Vars.controller.setShapeType(Controller.LINE);
				
			}
		});
		rectToggleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Vars.controller.setShapeType(Controller.RECT);
				
			}
		});
		circleToggleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Vars.controller.setShapeType(Controller.OVAL);
				
			}
		});
		texToggleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Vars.controller.setShapeType(Controller.TEXT);
				
			}
		});

	}
}
