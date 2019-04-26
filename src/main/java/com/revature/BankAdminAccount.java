package com.revature;

import java.util.Objects;
import java.util.Scanner;

public class BankAdminAccount extends BankAccount{

	public BankAdminAccount() {
		super();
		this.userID = 2;
	}
	
	public void withdraw(double input) {
		
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter customer's username whose account you want to wihtdraw from.");
		String username = s.nextLine();
		
		for (int i = 0; i < userDic.size(); i++) {
			if(Objects.equals(username, userDic.get(i))) {
				break;
			}
			else {
				System.out.println("This user does not exist, sorry.");
				return;
			}
		}
		
		int index = BankAccounts.bankDic.indexOf(username);
		 
		double bal = BankAccounts.bankDic.get(index).balance;
		
		System.out.println("The customer whose account you entered has $" + bal + ".");

		if(input > bal) {
			System.out.println("This input exceeds current funds.");
			System.out.println("Your current balance is" + bal + ".");
			System.out.println("Please enter another value or choose a different option.");
		}
		else if(input < 0) {
			System.out.println("This input of " + input + " exceeds current bounds of logic, "
					+ "please enter another value or choose a different option.");
		}
		else {
			System.out.println("Your input of " + input + " has been withdrawn.");
			System.out.println("The current balance is now $" + bal + " in " + username + "account.");
		}
	}
	
	public void deposit(double input) {
		if (input < 0){
			System.out.println("This input of " + input + " exceeds current bounds of logic, "
					+ "please enter another value or choose a different option.");
		}
		else{
			System.out.println("Your input of " + input + " has been deposited.");
			System.out.println("Your current balance is now $" + balance + ".");
		}
		
	}

	@Override
	public void withdraw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean createUserName(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void signIn(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewMenu() {
		Scanner s = new Scanner(System.in);
		int choice;
		if (approved) {
			System.out.println("Welcome back BankAdmin!");
		} else {
			System.out.println("Sorry for the inconveince, it seems your account isn't approved yet.");
			s.close(); 
			return;
		}
		do {
		System.out.println("Please choose from one of the options");
		System.out.println("1 - Check current balance.");
		System.out.println("2 - Withdraw");
		System.out.println("3 - Deposit");
		System.out.println("4 - Create savings account");
		System.out.println("5 - Create joint account");
		System.out.println("6 - Log out");
		choice = s.nextInt();
		} while (choice != 6);
		s.close(); 
		
	}

}
