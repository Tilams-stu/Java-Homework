package model;

public class User {
	private String idString;
	private String nameString;
	public User(String idString, String nameString) {
		super();
		this.idString = idString;
		this.nameString = nameString;
	}
	
	public String getIdString() {
		return idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}
	public static User fromString(String s) {
		String[] partStrings = s.split(",");
		return new User(partStrings[0], partStrings[1]);
	}
	@Override
	public String toString() {
		return  idString + "," + nameString;
	}
}
