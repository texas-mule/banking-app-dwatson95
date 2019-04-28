package com.revature;

import java.util.Scanner;

public class EmployeeAccount extends BankAccount {

	
	public EmployeeAccount() {
		super();
		this.userID = 1;
	}

	@Override
	public void approval() {
		Scanner s = new Scanner(System.in);
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
				System.out.println("Thank you you'll returned to the employee menu.");
			else 
				System.out.println("That's an invalid choice.");
			
			System.out.println("");
		}while(choice != 2);
		
		s.close();
	}

	@Override
	public void usersInfo(int indexNum) {
		Scanner s = new Scanner(System.in);
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
		s.close();
	}
	
	@Override
	public void viewMenu(int indexNum) {
		Scanner s = new Scanner(System.in);
		int choice;
		if (BankAccounts.bankDic.get(indexNum).isApproved()) {
			System.out.println("Welcome to Revature Bank!");
		} else {
			System.out.println("Sorry for the inconveince, it seems your account isn't approved.");
			System.out.println("");
			s.close(); 
			return;
		}
		
		do {
			System.out.println("Please choose from one of the options");
			System.out.println("1 - Check current users information.");
			System.out.println("2 - Approve a user");
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
		
		s.close(); 
		
	}
	
	@Override
	public void withdraw(int indexNum) {
		System.out.println("Employee does not have access to this method.");
	}

	@Override
	public void deposit(int indexNum) {
		System.out.println("Employee does not have access to this method.");
	}

}
