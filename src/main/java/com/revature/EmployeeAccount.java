package com.revature;

import java.util.Scanner;

public class EmployeeAccount extends BankAccount {

	
	public EmployeeAccount(String accnName, String accnPswd, double balance) {
		super(accnName, accnPswd, balance);
		this.accnName = accnName;
		this.accnPswd = accnPswd;
	}
	
	
	

}
