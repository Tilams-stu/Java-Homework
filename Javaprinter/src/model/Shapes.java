package model;

import java.awt.Color;

public class Shapes {
	int type;
	Color foreColor;
	Color backColor;
	String string;
	int stringsize;
	int x1,y1;
	int x2,y2;
	boolean ifFill;
	public Shapes(int type, Color foreColor, Color backColor, String string, int stringsize, int x1, int y1, int x2,
			int y2,boolean ifFill) {
		super();
		this.type = type;
		this.foreColor = new Color(foreColor.getRGB());
		this.backColor = new Color(backColor.getRGB());
		this.string = string;
		this.stringsize = stringsize;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.ifFill = ifFill;
	}
	public boolean isIfFill() {
		return ifFill;
	}
	public void setIfFill(boolean ifFill) {
		this.ifFill = ifFill;
	}
	public int getStringsize() {
		return stringsize;
	}
	public void setStringsize(int stringsize) {
		this.stringsize = stringsize;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Color getForeColor() {
		return foreColor;
	}
	public void setForeColor(Color foreColor) {
		this.foreColor = foreColor;
	}
	public Color getBackColor() {
		return backColor;
	}
	public void setBackColor(Color backColor) {
		this.backColor = backColor;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	
}
