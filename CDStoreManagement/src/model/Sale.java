package model;

import java.util.*;

public class Sale {
	private String cdidString;
	private Date date;
	public Sale(String cdidString, Date date) {
		super();
		this.cdidString = cdidString;
		this.date = date;
	}
	public String getCdidString() {
		return cdidString;
	}
	public void setCdidString(String cdidString) {
		this.cdidString = cdidString;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public static Sale fromString(String s) {
		String[] partStrings = s.split(",");
		return new Sale(partStrings[0], new Date(Long.parseLong(partStrings[1])));
	}
	public String toString() {
		return cdidString + "," + date.getTime();
	}
}
