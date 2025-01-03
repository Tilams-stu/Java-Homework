package control;

import java.awt.Color;
import java.util.LinkedList;

import model.Shapes;
import var.Vars;

public class Controller {
	public static final int RECT = 1;
	public static final int OVAL = 2;
	public static final int TEXT = 3;
	public static final int LINE = 4;
	
	private int shapeType;
	
	private Color foreColor=Color.BLACK,backColor=Color.WHITE;
	private String textString;
	public void setShapeType(int shapeType) {
		this.shapeType = shapeType;
	}
	public void setForeColor(Color foreColor) {
		this.foreColor = new Color(foreColor.getRGB());
	}
	public void setBackColor(Color backColor) {
		this.backColor = new Color(backColor.getRGB());
	}
	public void setTextString(String textString) {
		this.textString = textString;
	}
	
	public int getShapeType() {
		return shapeType;
	}
	public Color getForeColor() {
		return foreColor;
	}
	public Color getBackColor() {
		return backColor;
	}
	public String getTextString() {
		return textString;
	}
	
	private LinkedList<Shapes> shapeJobList = new LinkedList<Shapes>();
	public void finishShapeJob(int x1, int y1, int x2, int y2,int stringsize) {
		Shapes shape = new Shapes(shapeType, new Color(foreColor.getRGB()), new Color(backColor.getRGB()),Vars.northPanel.getTextField().getText(),(int) Vars.northPanel.getSizeSpinner().getValue(),x1, y1, x2, y2,Vars.northPanel.getCheckBox().isSelected());
		shapeJobList.add(shape);
		
	}
	public LinkedList<Shapes> getShapeJobList(){
		return shapeJobList;
	}
}
