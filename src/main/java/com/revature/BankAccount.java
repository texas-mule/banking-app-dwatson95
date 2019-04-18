package com.revature;

public abstract class BankAccount implements Withdraw, Deposit {
	
	public String accnName;
	public String accnPswd;
	public double balance;
	public String firstN;
	public String lastN;
	
	public String mainDic[];
	public String userDic[];
	public String empDic[];
	
	public BankAccount(String accnName, String accnPswd, double b){
		super();
	}
	
	public void withdraw(double input) {
		if(input > balance) {
			System.out.println("This input exceeds current funds.");
			System.out.println("Your current balance is" + balance + ".");
			System.out.println("Please enter another value or choose a different option.");
		}
		else if(input < 0) {
			System.out.println("This input exceeds current bounds of logic, please enter another value "
					+ "or choose a different option.");
		}
		else {
			System.out.println("Your input of " + input + " has been deposited.");
		}
	}
	
	public void deposit(double input) {
		
	}
		
	
}
