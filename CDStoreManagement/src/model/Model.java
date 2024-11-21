package model;

import java.io.*;
import java.util.*;

public class Model {
	private static final String USER_FILE_STRING = "users.txt";
	private static final String CD_FILE_STRING = "cds.txt";
	private static final String RENTAL_FILE_STRING = "rentals.txt";
	private static final String SALES_FILE_STRING = "sales.txt";
	private static final String HISTORY_FILE_STRING = "history.txt";
	
	private Map<String, User>usersMap = new HashMap<>();
	private Map<String, CD>cdsMap = new HashMap<>();
	private List<Rental> rentals = new ArrayList<Rental>();
	private List<Sale> sales = new ArrayList<Sale>();
	
	private void loadUsers() {
		try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE_STRING))) {
            String line;
            while ((line = br.readLine()) != null) {
                User user = User.fromString(line);
                usersMap.put(user.getIdString(), user);
            }
        } catch (IOException e) {
            
        }
	}
	private void loadCDs() {
		try (BufferedReader br = new BufferedReader(new FileReader(CD_FILE_STRING))) {
            String line;
            while ((line = br.readLine()) != null) {
                CD cd = CD.fromString(line);
                cdsMap.put(cd.getIdString(), cd);
            }
        } catch (IOException e) {
            
        }
	}
	private void loadRentals() {
		try (BufferedReader br = new BufferedReader(new FileReader(RENTAL_FILE_STRING))) {
            String line;
            while ((line = br.readLine()) != null) {
                Rental rental = Rental.fromString(line);
                rentals.add(rental);
            }
        } catch (IOException e) {
            
        }
	}
	private void loadSales() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(SALES_FILE_STRING))){
			String lineString;
			while ((lineString = bufferedReader.readLine()) != null) {
				Sale sale = Sale.fromString(lineString);
				sales.add(sale);
			}
		} catch (IOException e) {
			
		}
	}
	private void saveUsers() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(USER_FILE_STRING))) {
            for (User user : usersMap.values()) {
                pw.println(user);
            }
        } catch (IOException e) {
            System.out.println("Error saving user data.");
        }
    }

    private void saveCDs() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CD_FILE_STRING))) {
            for (CD cd : cdsMap.values()) {
                pw.println(cd);
            }
        } catch (IOException e) {
            System.out.println("Error saving CD data.");
        }
    }
	private void saveRentals() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(RENTAL_FILE_STRING))) {
            for (Rental rental : rentals) {
                pw.println(rental);
            }
        } catch (IOException e) {
            System.out.println("Error saving rental data.");
        }
    }

    private void saveSales() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(SALES_FILE_STRING))) {
            for (Sale sale : sales) {
                pw.println(sale);
            }
        } catch (IOException e) {
            System.out.println("Error saving sales data.");
        }
    }

    private void saveHistory() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(HISTORY_FILE_STRING, true))) {
            Date now = new Date();
            pw.println("Data saved at " + now.toString());
        } catch (IOException e) {
            System.out.println("Error saving history data.");
        }
    }
    public void loadData() {
    	loadUsers();
    	loadCDs();
    	loadRentals();
    	loadSales();
    }
    public void saveData() {
    	saveUsers();
    	saveCDs();
    	saveRentals();
    	saveSales();
    	saveHistory();
    }
    //users operations
    public boolean userExists(String userId) {
		return usersMap.containsKey(userId);
	}
    public void addUser(User user) {
    	usersMap.put(user.getIdString(), user);
    }
    public int getUserCount() {
    	return usersMap.size();
    }
    // CD operations
    public boolean cdExists(String cdId) {
		return cdsMap.containsKey(cdId);
	}
    public void addCD(CD cd) {
    	cdsMap.put(cd.getIdString(), cd);
    }
    public void restockCD(String cdId,int quantity) {
    	CD cd = cdsMap.get(cdId);
    	cd.setQuantity(cd.getQuantity()+quantity);
    }
    public int getCDQuantity(String cdId) {
    	return cdsMap.get(cdId).getQuantity();
    }
    public CD getCD(String cdId) {
    	return cdsMap.get(cdId);
    }
    public Collection<CD> getAllCDs(){
    	return cdsMap.values();
    }
    public int getCDCount() {
    	return cdsMap.size();
    }
    
    //Rental operation
    public void rentCD(String userId,String cdId) {
    	CD cd = cdsMap.get(cdId);
    	cd.setQuantity(cd.getQuantity() - 1);
    	rentals.add(new Rental(userId, cdId, new Date()));
	}
    public void returnCD(Rental rental) {
    	CD cd = cdsMap.get(rental.getCdidString());
    	cd.setQuantity(cd.getQuantity() + 1);
    	rentals.remove(rental);
	}
    public List<Rental> getUserRentals(String userId){
    	List<Rental> userRentals = new ArrayList<Rental>();
    	for (Rental rental : rentals) {
			if(rental.getUseridString().equals(userId)) {
				userRentals.add(rental);
			}
		}
    	return userRentals;
    }
    public int getRentalCount() {
    	return rentals.size();
    }
    
    //Sale operations
    public void sellCD(String cdId) {
    	CD cd = cdsMap.get(cdId);
    	cd.setQuantity(cd.getQuantity() - 1);
    	sales.add(new Sale(cdId, new Date()));
    }
    public int getSaleCount() {
    	return sales.size();
    }
}
