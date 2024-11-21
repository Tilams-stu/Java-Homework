package views;

import java.util.Collection;
import java.util.Scanner;

import model.CD;

public class Views {
	private Scanner scanner = new Scanner(System.in);
	
	public String showMainMenu() {
		System.out.println("\n--- CD Store Management System ---");
        System.out.println("1. Add Member");
        System.out.println("2. Rent CD");
        System.out.println("3. Return CD");
        System.out.println("4. Sell CD");
        System.out.println("5. Restock CD");
        System.out.println("6. Statistics");
        System.out.println("7. Exit");
        System.out.print("Select an option: ");
        return scanner.nextLine();
		
	}
	public void showMessage(String messageString ) {
		System.out.println(messageString);
	}
	public String getinput(String prompt) {
		System.out.println(prompt);
		return scanner.nextLine();
	}
	public void displayCDs(Collection<CD> cds) {
		System.out.println("\nAvailable CDs:");
		for (CD cd:cds) {
			System.out.println("ID:" + cd.getIdString() + ",TItle:" + cd.getTitleString() + ",Quantity:" + cd.getQuantity());
			
		}
	}
}
