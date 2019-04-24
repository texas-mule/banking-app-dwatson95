package com.revature;

import java.util.Objects;
import java.util.Scanner;

public class CustomerAccount extends BankAccount {

	public CustomerAccount(String accnName, String accnPswd, double balance) {
		super(accnName, accnPswd, balance);
		this.accnName = accnName;
		this.accnPswd = accnPswd;
		this.balance = balance;
	}
	
	
	public void withdraw() {
		double input;
		Scanner s = new Scanner(System.in);
		
		int option;
		String keyLookUp;
		boolean contains = false;
		do {
		
			System.out.println("Please enter the option which you would like to make.");
			System.out.println("1 - Withdraw from Checkings Account");
			System.out.println("2 - Withdraw from Savings Account");
			System.out.println("3 - Withdraw from Joint Account");
			System.out.println("4 - Logout");
			
			option = s.nextInt();
			if (option == 1) {
				System.out.println("Please enter the amount you wish to withdraw.");
				input = s.nextDouble();
				
				if(input > balance) {
					System.out.println("This input exceeds current funds.");
					System.out.println("Your current balance is" + balance + ".");
					System.out.println("Please enter another value or choose a different option.");
				}
				else if(input < 0) {
					System.out.println("This input of " + input + " exceeds current bounds of logic, "
							+ "please enter another value or choose a different option.");
				}
				else {
					System.out.println("Your input of " + input + " has been withdrawn.");
					this.balance = this.balance - input;
					System.out.println("Your current balance is now $" + balance + ".");
				}
				
			} else if (option == 2) {
				// if they don't like the fact you have to know it, well it's a safety feature
				System.out.println("Please enter the savings account you would like to withdraw from.");
				keyLookUp = s.nextLine();
				while(!contains) {
					if (contains)
						savingsAcc.containsKey(keyLookUp);
					else
						System.out.println("Sorry that savings account does not exist.");
				}
				
				double curentBalance = savingsAcc.get(keyLookUp);
				
				System.out.println("Please enter you withdraw amount.");
				input = s.nextDouble();
				
				if(input > curentBalance) {
					System.out.println("This input exceeds current funds.");
					System.out.println("Your current balance is" + curentBalance + ".");
					System.out.println("Please enter another value or choose a different option.");
				}
				else if(input < 0) {
					System.out.println("This input of " + input + " exceeds current bounds of logic, "
							+ "please enter another value or choose a different option.");
				}
				else {
					System.out.println("Your input of " + input + " has been withdrawn.");
					curentBalance = curentBalance - input;
					System.out.println("Your current balance is now $" + curentBalance + ".");
					savingsAcc.put(keyLookUp, curentBalance);
				}
				
			} else if (option == 3) {
				
			} else {
				System.out.println("That value is invalid please input one of the given options.");
			}
			
		} while (option != 4);
		
	}
	
	public void deposit(double input) {
		if (input < 0){
			System.out.println("This input of " + input + " exceeds current bounds of logic, "
					+ "please enter another value or choose a different option.");
		}
		else{
			System.out.println("Your input of " + input + " has been deposited.");
			this.balance = this.balance + input;
			System.out.println("Your current balance is now $" + balance + ".");
		}
		
	}
	
	public void apply() {
		Scanner s = new Scanner(System.in);
		// loop for checking username 
		boolean userNameFree = true;
		while(userNameFree) {
			System.out.println("Please enter a username!");
			String username = s.nextLine();
			createUserName(username);			
		}
		int choice;
		do {
			// loop if No is selected
			// also if the incorrect option is chosen
			System.out.println("Please enter a password!");
			String password = s.nextLine();
			System.out.println("Are you sure you want, " + password + "to be your password?");
			System.out.println("1 - Yes");
			System.out.println("2 - No");
			
			choice = s.nextInt();
		} while (choice == 2);
		
		System.out.println("Your checkings account has been created!");
		System.out.println("You will need to wait for our systems to proccess your account.");
		System.out.println("Until then you'll have to wait to access our banking system, "
				+ "so please return later.");
		System.out.println("Thank you for choosing Revature Bank and have a wonderful day.");
		
	}
	
	@Override
	public boolean createUserName(String username) {
		for (int i = 0; i < userDic.size(); i++) {
			if(Objects.equals(username, userDic.get(i))) {
				this.userDic.add(accnName);
				System.out.println("This username already exists!");
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void signIn(String username, String password) {
		
	}
	
	public void SavingsAccount(String name, double deposit) {
		Scanner s = new Scanner(System.in);
		System.out.println("To create an savings account, please input an account name.");
		String newSavAccn;
		int i = 0;
		do {
			System.out.println("This name should be creative as easily find.");
			newSavAccn = s.nextLine();
			if (savingsAcc.containsKey(newSavAccn)) {
				System.out.println("Sorry for the inconvience but it seems this account already exsist.");
				System.out.println("Please try a different name for your savings account.");
			}
			else
				i = 1;
				
		} while(i == 0);
		
		System.out.println("How much money would you like to deposit in you savings account");
		double initDeposit = s.nextDouble();
		
		savingsAcc.put(newSavAccn, initDeposit);
		userSavDic.put(getAccnName(), newSavAccn);
		
	}
	
	@Override
	public void viewMenu() {
		Scanner s = new Scanner(System.in);
		int choice;
		if (approved) {
			System.out.println("Welcome to Revature Bank!");
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
