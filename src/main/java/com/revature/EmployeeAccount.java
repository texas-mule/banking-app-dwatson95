package com.revature;

import java.util.Scanner;

public class EmployeeAccount extends BankAccount {

	Scanner s = new Scanner(System.in);

	public EmployeeAccount() {
		super();
		this.userID = 1;
	}

	@Override
	public void approval() {
		int choice;
		int i = 0;
		String userApproved;
		boolean exist;
		
		System.out.println("Welcome to Revature Bank's approval portal!");
		System.out.println("The current user's not yet approved are listed below.");
		
		for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
			String user = BankAccounts.userDic.get(counter); 
			boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isApproved();
			if (isappr == false) {
				System.out.println(user);
			}
		}
		System.out.println("");
		
		do {
			System.out.println("Would you like to approve a user above?");
			System.out.println("1 - Yes");
			System.out.println("2 - No");
			choice = s.nextInt();
			System.out.println("");
			
			if(choice == 1) {
				do {
					System.out.println("Please enter the username who you wish to approve.");
					userApproved = s.nextLine();
					System.out.println("");
					exist = BankAccounts.userDic.contains(userApproved);
					
					if (exist) {
						System.out.println("The account " + userApproved + " has been approved");
						BankAccounts.bankDic.get(BankAccounts.bankIndex.get(userApproved)).setApproved(true);
						i = 1;
					}
					else 
						System.out.println("That username currently does not exist.");
					
				}while (i == 0);
			} else if (choice == 2)
				System.out.println("Thank you, you'll returned to the employee menu now.");
			else 
				System.out.println("That's an invalid choice.");
			
			System.out.println("");
		}while(choice != 2);
		
		//s.close();
	}

	@Override
	public void usersInfo(int indexNum) {
		int choice, i;
		boolean exist;
		String user;
		System.out.println("Your current information is!");
		BankAccounts.bankDic.get(indexNum).toString();
		System.out.println("");
		
		do {
			System.out.println("You can check the current users as well as there information here.");
			
			System.out.println("Please choose from one of the options");
			System.out.println("1 - Check current users.");
			System.out.println("2 - Check a users information");
			System.out.println("3 - Leave");
			choice = s.nextInt();
			System.out.println("");
			
			if (choice == 1) {
				for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) { 		      
			          System.out.println("Username = " + BankAccounts.userDic.get(counter)); 
				}
				System.out.println("");
			}
			else if (choice == 2) {
				do {
					System.out.println("Please choose the user's account you wish to view.");
					user = s.nextLine();
					exist = BankAccounts.userDic.contains(user);
					if (exist) {
						BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).toString();
						i = 1;
					} 
					else {
						System.out.println("That's an invalid option.");
						System.out.println("");
						i = 0;
					}
				
				} while (i == 0);
			}
			else if (choice == 3)
				System.out.println("Returning to user menu.");
			else {
				System.out.println("That's an invalid option.");
				System.out.println("");
			}
		
		} while (choice != 3);
		System.out.println("");
		//s.close();
	}
	
	@Override
	public void viewMenu(int indexNum) {
		int choice;
		boolean approvedOrNot = BankAccounts.bankDic.get(indexNum).isApproved();
		if (approvedOrNot == true) {
			System.out.println("Welcome to Revature Bank!");
		} else {
			System.out.println("Sorry for the inconveince, it seems your account isn't approved.");
			System.out.println("");
			//s.close(); 
			return;
		}
		
		do {
			System.out.println("Please choose from one of the options");
			System.out.println("1 - Check Current Accounts Information.");
			System.out.println("2 - Approve Users Accounts");
			System.out.println("3 - Log out");
			choice = s.nextInt();
			System.out.println("");
			
			if (choice == 1) 
				usersInfo(indexNum);
			else if (choice == 2)
				approval();
			else if (choice == 3)
				System.out.println("Thank you for working with RV Bank");
			else {
				System.out.println("That's an invalid option.");
				System.out.println("");
			}
		
		} while (choice != 3);
		
		//s.close(); 
		
	}
	
	@Override
	public void withdraw(int indexNum) {
		System.out.println("Employee does not have access to this method.");
	}

	@Override
	public void deposit(int indexNum) {
		System.out.println("Employee does not have access to this method.");
	}
	
	public void transfer(int indexNum) {
		System.out.println("Employee does not have access to this method.");
	}

	public void apply() {		
		System.out.println("Please enter your first name.");
		String first = s.nextLine();
		setFirstN(first);
		
		System.out.println("Please enter your last name!");
		String last = s.nextLine();
		setLastN(last);
		
		String username;
		boolean userNameFree = true;
		while(userNameFree) {
			System.out.println("Please enter a username!");
			username = s.nextLine();
			userNameFree = createUserName(username);
			if(userNameFree == true) {
				BankAccounts.employeeDic.add(username);
				setAccnName(username);
			}
		}
		
		int choice;
		String password;
		do {
			// loop if No is selected
			// also if the incorrect option is chosen
			System.out.println("Please enter a password!");
			password = s.nextLine();
			System.out.println("Are you sure you want, " + password + " to be your password?");
			System.out.println("1 - Yes");
			System.out.println("2 - No");
			choice = s.nextInt();
			if (choice == 1)
				setAccnPswd(password);
		} while (choice != 1);
		
		System.out.println("Your checkings account has been created!");
		System.out.println("You will need to wait for our systems to proccess your account.");
		System.out.println("Until then you'll have to wait to access our banking system, "
				+ "so please return later.");
		System.out.println("Thank you for choosing Revature Bank and have a wonderful day.");
		BankAccounts.userToPswd.put(getAccnName(), getAccnPswd());
		BankAccounts.bankIndex.put(getAccnName(), getUserINDEX());
		////s.close();
		
	}
	
	@Override
	public void signIn(String username, String password) {
		int userIndex = 0;
		//choice = s.nextLine();
		
		String checkPswd, checkUsername;
		checkUsername = username;
		boolean doHaveKey = false;
		
		do {
			doHaveKey = BankAccounts.employeeDic.contains(checkUsername);
			if (doHaveKey) {
				checkPswd = BankAccounts.userToPswd.get(checkUsername);
				boolean rightPword = checkPswd.equals(password);
				do {
					if (rightPword) {
						userIndex = BankAccounts.bankIndex.get(checkUsername);
						viewMenu(userIndex);
					}
					else {
						System.out.println("That password is not in our systems, please enter another one.");
						password = s.nextLine();
					}
				} while(!rightPword);
			}
			else {
				System.out.println("That username is not in our systems, please enter another one.");
				System.out.println("If you wish not to login enter 'exit' to leave.");
				checkUsername = s.nextLine();
				if (checkUsername.equals("exit")) {
					System.out.println("Thank you, you'll return to the login page now.");
					return;
				}
			}
		} while(!doHaveKey);
		
		//s.close();
	}
	
}
