package model;

import java.util.*;

public class Rental {
	private String useridString;
	private String cdidString;
	private Date date;
	public Rental(String useridString, String cdidString, Date date) {
		super();
		this.useridString = useridString;
		this.cdidString = cdidString;
		this.date = date;
	}
	
	public static Rental fromString(String s) {
		String[] partStrings = s.split(",");
		return new Rental(partStrings[0], partStrings[1], new Date(Long.parseLong(partStrings[2])));
	}

	public String getUseridString() {
		return useridString;
	}

	public void setUseridString(String useridString) {
		this.useridString = useridString;
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
	public String toString() {
		return useridString + "," +cdidString + "," +date.getTime();
	}
	
}
