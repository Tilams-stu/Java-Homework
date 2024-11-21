package model;


public class CD {
	private String idString;
	private String titleString;
	private int quantity;
	public CD(String idString, String titleString, int quantity) {
		super();
		this.idString = idString;
		this.titleString = titleString;
		this.quantity = quantity;
	}
	
	public static CD fromString(String s) {
		String[] partStrings = s.split(",");
		return new CD(partStrings[0], partStrings[1], Integer.parseInt(partStrings[2]));
	}

	public String getIdString() {
		return idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTitleString() {
		return titleString;
	}

	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}
	public String toString() {
		return idString + "," + titleString + "," + quantity;
	}
	
}
