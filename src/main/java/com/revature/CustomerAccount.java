package com.revature;

public class CustomerAccount extends UserAccount {

	public CustomerAccount(String accnName, String accnPswd, double balance) {
		super(accnName, accnPswd, balance);
		this.accnName = accnName;
		this.accnPswd = accnPswd;
		this.balance = balance;
	}
	
	
	public void withdraw(double input) {
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
			System.out.println("Your current balance is now $" + balance + ".");
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
	
	public void apply(String username) {
		
		
	}

}
