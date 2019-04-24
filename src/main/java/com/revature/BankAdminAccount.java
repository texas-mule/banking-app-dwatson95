package com.revature;

import java.util.Objects;
import java.util.Scanner;

public class BankAdminAccount extends BankAccount{

	public BankAdminAccount(String accnName, String accnPswd, double balance) {
		super(accnName, accnPswd, balance);
		// TODO Auto-generated constructor stub
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
		
		int index = bankDic.indexOf(username);
		 
		double bal = bankDic.get(index).balance;
		
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

}
