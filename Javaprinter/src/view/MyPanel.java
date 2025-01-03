package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JPanel;

import control.Controller;
import model.Shapes;
import var.Vars;

@SuppressWarnings("serial")
public class MyPanel extends JPanel{
	int x1,x2,y1,y2;
	private boolean isDrawing = false;
	public MyPanel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x1=e.getX();
				y1=e.getY();
				x2=x1;
				y2=y1;
				isDrawing = true;
				repaint();
				Vars.southPanel.getTextField().setText("Pressed "+"x1="+x1+" y1="+y1);
			}
			public void mouseReleased(MouseEvent e) {
				x2 = e.getX();
				y2 = e.getY();
				isDrawing = false;
				
				Vars.southPanel.getTextField().setText("Released x1="+x1 +" y1="+y1+" x2="+x2+" y2="+y2);
				Vars.controller.finishShapeJob(x1, y1, x2, y2,(int) Vars.northPanel.getSizeSpinner().getValue());
				repaint();
			}
		});
		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				x2 = e.getX();
				y2 = e.getY();
				Vars.southPanel.getTextField().setText("Position x1="+x1 +" y1="+y1+" x2="+x2+" y2="+y2);
				repaint();
			}
		});
	}
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);	
		setBackground(Vars.controller.getBackColor());
		
		LinkedList<Shapes> jobList = Vars.controller.getShapeJobList();

		for(Shapes shape : jobList) {
			graphics.setColor(shape.getForeColor());
			int type = shape.getType();
			if(type == Controller.RECT) {
				if(shape.isIfFill() == false)
					graphics.drawRect(Math.min(shape.getX1(), shape.getX2()), Math.min(shape.getY1(), shape.getY2()), Math.abs(shape.getX1()-shape.getX2()), Math.abs(shape.getY1()-shape.getY2()));
				else 
					graphics.fillRect(Math.min(shape.getX1(), shape.getX2()), Math.min(shape.getY1(), shape.getY2()), Math.abs(shape.getX1()-shape.getX2()), Math.abs(shape.getY1()-shape.getY2()));
				
			}
			else if(type == Controller.OVAL) {
				if(shape.isIfFill() == false)
					graphics.drawOval(Math.min(shape.getX1(), shape.getX2()), Math.min(shape.getY1(), shape.getY2()), Math.abs(shape.getX1()-shape.getX2()), Math.abs(shape.getY1()-shape.getY2()));
				else {
					graphics.fillOval(Math.min(shape.getX1(), shape.getX2()), Math.min(shape.getY1(), shape.getY2()), Math.abs(shape.getX1()-shape.getX2()), Math.abs(shape.getY1()-shape.getY2()));	
				}
			}
			else if(type == Controller.TEXT) {
				Font font = new Font("楷体", Font.PLAIN, shape.getStringsize());
				graphics.setFont(font);
				graphics.drawString(shape.getString(), shape.getX1(), shape.getY1());
				
			}
			else if(type == Controller.LINE) {
				graphics.drawLine(shape.getX1(), shape.getY1(), shape.getX2(), shape.getY2());
			}
		}
		if(isDrawing) {
			graphics.setColor(Vars.controller.getForeColor());
			int type1 = Vars.controller.getShapeType();
			if(type1 == Controller.RECT) {
				if(Vars.northPanel.getCheckBox().isSelected() == true)
					graphics.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
				else {
					graphics.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
				}
			}
			else if(type1 == Controller.OVAL) {
				if(Vars.northPanel.getCheckBox().isSelected() == true)
					graphics.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
				else {
					graphics.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
				}
			}
			else if(type1 == Controller.LINE) {
				graphics.drawLine(x1, y1, x2, y2);
			}
		}
	}
}
