package com.revature;

public class EmployeeAccount extends UserAccount {

	
	public EmployeeAccount(String accnName, String accnPswd, double balance) {
		super(accnName, accnPswd, balance);
		this.accnName = accnName;
		this.accnPswd = accnPswd;
	}
	

}
