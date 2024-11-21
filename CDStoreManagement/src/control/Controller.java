package control;
import views.*;
import java.util.*;
import model.*;

public class Controller {
	private Model model = new Model();
	private Views view = new Views();
	private void addMember() {
		String idString = view.getinput("Enter member ID:");
		if(model.userExists(idString)) {
			view.showMessage("Member already exists.");
			return;
		}
		String nameString=view.getinput("Enter member name:");
		model.addUser(new User(idString, nameString));
		view.showMessage("Member added successfully");
	}
	
	public void rentCD() {
		String userIdString = view.getinput("Enter member ID:");
		if(!model.cdExists(userIdString)) {
			view.showMessage("Member does not exist.");
			return;
		}
		view.displayCDs(model.getAllCDs());
		String cdIdString = view.getinput("Enter CD ID to rent:");
		if(!model.cdExists(cdIdString)) {
			view.showMessage("CD does not exist.");
			return;
		}
		if(model.getCDQuantity(cdIdString)<= 0) {
			view.showMessage("CD is out of stock.");
			return;
		}
		model.rentCD(userIdString, cdIdString);
		view.showMessage("CD rented successfully.");
	}
	private void returnCD() {
		String userIdString = view.getinput("Enter member ID:");
		if(!model.cdExists(userIdString)) {
			view.showMessage("Member does not exist.");
			return;
		}
		List<Rental> userRentals=model.getUserRentals(userIdString);
		if(userRentals.isEmpty()) {
			view.showMessage("NO CDs to return");
			return;
		}
		System.out.println("\nYour rented CDs:");
		for (int i = 0; i < userRentals.size(); i++) {
			Rental rental = userRentals.get(i);
			CD cd = model.getCD(rental.getCdidString());
			System.out.println((i+1)+".ID:"+cd.getIdString() + ",Title" + cd.getTitleString());
		}
		String inputString=view.getinput("Enter the number of the CD to return:");
		try {
			int index=Integer.parseInt(inputString)-1;
			if(index<0 ||index>=userRentals.size()) {
				view.showMessage("Invalid selection.");
				return;
			}
			model.returnCD(userRentals.get(index));
			view.showMessage("CD returned successfully.");
		} catch (NumberFormatException e) {
			// TODO: handle exception
			view.showMessage("Invalid input.");
		}
	}
	private void sellCD() {
		view.displayCDs(model.getAllCDs());
		String cdIdString=view.getinput("Enter CD ID to sell:");
		if(!model.cdExists(cdIdString)) {
			view.showMessage("CD does not exist.");
			return;
		}
		if(model.getCDQuantity(cdIdString)<= 0) {
			view.showMessage("CD is out of stock");
			return;
		}
		
		model.sellCD(cdIdString);
		view.showMessage("CD sold successfully.");
	}
	
	private void restockCD() {
		String cdIdString= view.getinput("Enter CD ID:");
		if(model.cdExists(cdIdString)) {
			String quantityString= view.getinput("Enter quantity to add:");
			try {
				int quantity= Integer.parseInt(quantityString);
				model.restockCD(cdIdString, quantity);
				view.showMessage("CD restocked.");
			} catch (NumberFormatException e) {
				// TODO: handle exception
				view.showMessage("Invalid quantity.");
			}
		}
		else {
			String titleString=view.getinput("Enter CD title:");
			String quantityString= view.getinput("Enter quantity:");
			try {
				int quantity= Integer.parseInt(quantityString);
				model.addCD(new CD(cdIdString, titleString, quantity));
				view.showMessage("New CD added.");
			} catch (NumberFormatException e) {
				// TODO: handle exception
				view.showMessage("Invalid quantity.");
			}
		}
	}
	private void showStatistics() {
		view.showMessage("\n--- Statistics ---");
		view.showMessage("Total members:" + model.getUserCount());
		view.showMessage("Total CDs:" + model.getCDCount());
		view.showMessage("Total rentals:" + model.getRentalCount());
		view.showMessage("Total sales:" + model.getSaleCount());
	}
	public void start() {
		model.loadData();
		boolean running = true;
		while(running) {
			String choiceString = view.showMainMenu();
			switch (choiceString) {
			case "1": {
				addMember();
				break;
				
			}
			case "2": {
				rentCD();
				break;

			}
			case "3": {
				returnCD();
				break;

			}
			case "4": {
				sellCD();
				break;
			}
			case "5": {
				restockCD();
				break;
			}
			case "6": {
				showStatistics();
				break;
			}
			case "7": {
				model.saveData();
				view.showMessage("Exiting the system.");
				running = false;
				break;
			}
			default:
				view.showMessage("Invalid input.Please try again.");
			}
		}
	}
	
}
