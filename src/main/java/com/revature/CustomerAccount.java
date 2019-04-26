package com.revature;

import java.util.Objects;
import java.util.Scanner;

public class CustomerAccount extends BankAccount {

	public CustomerAccount() {
		super();
		this.userID = 0;
	}
	
	//add joint
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
					else {
						System.out.println("Sorry that savings account does not exist.");
						keyLookUp = s.nextLine();
					}
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
		s.close();
	}
	//add joint
	public void deposit() {
		
		double input;
		Scanner s = new Scanner(System.in);
		
		int option;
		String keyLookUp;
		boolean contains = false;
		do {
		
			System.out.println("Please enter the option which you would like to make.");
			System.out.println("1 - Deposit to Checkings Account");
			System.out.println("2 - Deposit to Savings Account");
			System.out.println("3 - Deposit to Joint Account");
			System.out.println("4 - Logout");
			
			option = s.nextInt();
			if (option == 1) {
				System.out.println("Please enter the amount you wish to deposit.");
				input = s.nextDouble();
				if (input < 0){
					System.out.println("This input of " + input + " exceeds current bounds of logic, "
							+ "please enter a value greater than 0 or choose a different option.");
				}
				else{
					System.out.println("Your input of " + input + " has been deposited.");
					this.balance = this.balance + input;
					System.out.println("Your current balance is now $" + balance + ".");
				}	
				
			} else if (option == 2) {
				// if they don't like the fact you have to know it, well it's a safety feature
				System.out.println("Please enter the savings account you would like to deposit to.");
				keyLookUp = s.nextLine();
				while(!contains) {
					
					if (contains)
						savingsAcc.containsKey(keyLookUp);
					else {
						System.out.println("Sorry that savings account does not exist.");
						keyLookUp = s.nextLine();
						}
				}
				
				double curentBalance = savingsAcc.get(keyLookUp);
				
				System.out.println("Please enter you deposit amount.");
				input = s.nextDouble();
				
				if(input < 0) {
					System.out.println("This input of " + input + " exceeds current bounds of logic, "
							+ "please enter another value or choose a different option.");
				}
				else {
					System.out.println("Your input of " + input + " has been deposited.");
					curentBalance = curentBalance + input;
					System.out.println("Your current balance is now $" + curentBalance + ".");
					savingsAcc.put(keyLookUp, curentBalance);
				}
				
			} else if (option == 3) {
				
			} else {
				System.out.println("That value is invalid please input one of the given options.");
			}
			
		} while (option != 4);
		
		s.close();
	}
	
	public void apply() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter your first name.");
		String first = s.nextLine();
		setFirstN(first);
		System.out.println("Please enter your last name!");
		String last = s.nextLine();
		setLastN(last);
		System.out.println("You can change these once your account has been approved if needed.");
		String username;
		boolean userNameFree = true;
		while(userNameFree) {
			System.out.println("Please enter a username!");
			username = s.nextLine();
			userNameFree = createUserName(username);
			setAccnName(username);
		}
		int choice;
		String password;
		do {
			// loop if No is selected
			// also if the incorrect option is chosen
			System.out.println("Please enter a password!");
			password = s.nextLine();
			System.out.println("Are you sure you want, " + password + "to be your password?");
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
		s.close();
		
	}
	
	@Override
	public boolean createUserName(String username) {
		for (int i = 0; i < BankAccounts.userDic.size(); i++) {
			if(Objects.equals(username, BankAccounts.userDic.get(i))) {
				System.out.println("This username already exists!");
				return true;
			}
		}
		BankAccounts.userDic.add(username);
		return false;
	}
	
	@Override
	public int signIn(String username, String password) {
		Scanner s = new Scanner(System.in);
		int userIndex = 0;
		//choice = s.nextLine();
		
		String checkPswd, checkUsername;
		checkUsername = username;
		boolean doHaveKey = false;
		do {
			doHaveKey = BankAccounts.userToPswd.containsKey(checkUsername);
			if (doHaveKey) {
				checkPswd = BankAccounts.userToPswd.get(checkUsername);
				if (password.equals(checkPswd)) {
					userIndex = BankAccounts.bankIndex.get(checkUsername);
					viewMenu(userIndex);
				}
			}
			else {
				System.out.println("That username is not in our systems, please enter another one.");
				checkUsername = s.nextLine();
			}
		} while(!doHaveKey);
		
		
		
		return userIndex;
	}
	
	public void savingsAccount() {
		Scanner s = new Scanner(System.in);
		System.out.println("To create an savings account, please input an account name.");
		String newSavAccn;
		int i = 0;
		do {
			System.out.println("This name should be unique and creative as to easily find.");
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
		BankAccounts.userSavDic.put(getAccnName(), newSavAccn);
		
		s.close();
	}
	
	public void jointAccount() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("To create an joint account, please input an account name.");
		String newJoiAccn;
		int i = 0;
		do {
			System.out.println("This name should be unique and creative as to easily find.");
			newJoiAccn = s.nextLine();
			if (savingsAcc.containsKey(newJoiAccn)) {
				System.out.println("Sorry for the inconvience but it seems this account already exsist.");
				System.out.println("Please try a different name for your joint account.");
			}
			else
				i = 1;
				
		} while(i == 0);
		
		String newJoiAccnHolder;
		int j = 0;
		System.out.println("For a join account you can share it with another user.");
		System.out.println("The user will be allowed acces to the joint account.");
		boolean exist = false;
		for (String num : BankAccounts.userDic) { 		      
	           System.out.println(num); 		
	      }
		do {
			System.out.println("Please enter the user's username you would like to join.");
			newJoiAccnHolder = s.nextLine();
			exist = BankAccounts.userDic.contains(newJoiAccnHolder);
			if (exist) {
			// give the user the newJoiAccn name
				System.out.println("Choose to either continue or add another user.");
				System.out.println("0 - Add another user.");
				System.out.println("1 - Continue to depsoit");
				j = s.nextInt();
				if (j != 1 || j != 0) {
					System.out.println("Sorry for the inconvience but it seems this account already exsist.");
					System.out.println("Please try a different name for your joint account.");
					j = 0;
				}
				
			} else {
				System.out.println("Sorry for the inconvience but this user does not exist.");
				System.out.println("Please try a different name for your joint account.");
			}

		} while(j == 0);
		
		System.out.println("How much money would you like to deposit in you savings account");
		double initDeposit = s.nextDouble();
		
		savingsAcc.put(newJoiAccn, initDeposit);
		BankAccounts.userJoiDic.put(getAccnName(), newJoiAccn);
		
		s.close();
	}
	
	@Override
	public void viewMenu(int indexNum) {
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
