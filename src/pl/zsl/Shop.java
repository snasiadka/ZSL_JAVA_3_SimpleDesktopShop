package pl.zsl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shop {

	private User loggedInUser = null;
	private Map<String, User> users = new HashMap<String, User>();
	private ItemManager itemMgr = new ItemManager();
	
	public void addUser(String name, String login, String password) {
		users.put(login, new User (name, login, password, 1));
	}
	
	public void work () {
		User admin = new User ("admin", "admin", "admin", 0);
		User user1 = new User ("user1", "user1", "user1", 1);
		
		users.put(admin.getLogin(), admin);
		users.put(user1.getLogin(), user1);
		
		Scanner scan = new Scanner(System.in);
		
		Boolean doStop = false;
		
		do {
			System.out.println("Podaj login:");
			String login = scan.nextLine();
			System.out.println("Podaj has³o:");
			String pass = scan.nextLine();
			
			if (users.containsKey(login) && users.get(login).getPassword().equals(pass)) {
				loggedInUser = users.get(login);
				if (loggedInUser.getRole() == 0) {
					//admin
					Boolean doLogout = false;
					do {
						System.out.println("[1]. Dodaj u¿ytkownika");
						System.out.println("[2]. Lista u¿ytkowników");
						System.out.println("[3]. Dodaj produkt");
						System.out.println("[4]. Lista produktów");
						System.out.println("[5]. Zmieñ iloœæ produktu");
						System.out.println("[10]. Wyjœcie ze sklepu");
						System.out.println("[11]. Wyjœcie ze sklepu");
						String userChoice = scan.nextLine();
						switch (userChoice) {
							case "1" : {
								System.out.println("Login dla nowego u¿ytkownika: ");
								String newUserLogin = scan.nextLine();
								System.out.println("Password dla nowego u¿ytkownika: ");
								String newUserPass = scan.nextLine();
								System.out.println("Nazwa dla nowego u¿ytkownika: ");
								String newUserName = scan.nextLine();
								addUser(newUserLogin, newUserPass, newUserName);
								break;
							} 
							case "2" : {
								for (User u : users.values())
									System.out.println("User: " + u.getName() + ", login: " + u.getLogin());
								break;
							}
							case "3" : {
								System.out.println("Nazwa dla nowego produktu: ");
								String newItemName = scan.nextLine();
								System.out.println("Cena dla nowego produktu: ");
								String newItemPrice = scan.nextLine();
								System.out.println("Iloœæ dla nowego produktu: ");
								int newItemAmount = scan.nextInt();
								if (scan.hasNextLine()) scan.nextLine();
								Item newItem = itemMgr.createItem(newItemName, newItemPrice, newItemAmount);
								itemMgr.addItem(newItem);
							}
							case "4" : {
								int i = 0;
								System.out.println("Lista produktów:");
								for (Item item : itemMgr.getItems())
									System.out.println("Produkt [" + i++ + "]: " + item.getName() + ", cena: " + item.getPrice() + ", iloœæ w magazynie: " + item.getAmount());
								break;
							}
							case "5" : {
								System.out.println("Wybierz produkt: ");
								int itemIndex = scan.nextInt();
								if (scan.hasNextLine()) scan.nextLine();
								System.out.println("Nowa iloœæ dla produktu: ");
								int itemAmount = scan.nextInt();
								if (scan.hasNextLine()) scan.nextLine();
								itemMgr.getItems().get(itemIndex).setAmount(itemAmount);
								break;
							}
							case "10" : {
								System.out.println("Wylogowano");
								doLogout = true; 
								break;
							}
							case "11" : {
								doLogout = true; 
								doStop = true; 
								break;
							}
						}
					} while (doLogout == false);
				} else {
					//user
				}
			} else {
				System.out.println("Niew³aœciwy login lub has³o");
			}
		} while (doStop == false);
		
		System.out.println("Bye.");
		scan.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shop sklep = new Shop ();
		sklep.work();
	}

}
