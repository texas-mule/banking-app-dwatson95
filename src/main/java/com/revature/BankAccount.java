package com.revature;

import java.io.FileWriter;

public abstract class BankAccount implements Withdraw, Deposit, Apply {
	
	public String accnName;
	public String accnPswd;
	public double balance;
	public String firstN;
	public String lastN;
	public boolean approved = false;
	
	public String mainDic[];
	public String userDic[];
	public String empDic[];
	
	
	
	public BankAccount(String accnName, String accnPswd, double balance){
		super();
		try (FileWriter fw = new FileWriter("output.txt", true)){
			fw.append("Hello World");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getAccnName() {
		return accnName;
	}
	public void setAccnName(String accnName) {
		this.accnName = accnName;
	}
	public String getAccnPswd() {
		return accnPswd;
	}
	public void setAccnPswd(String accnPswd) {
		this.accnPswd = accnPswd;
	}
	public String getFirstN() {
		return firstN;
	}
	public void setFirstN(String firstN) {
		this.firstN = firstN;
	}
	public String getLastN() {
		return lastN;
	}
	public void setLastN(String lastN) {
		this.lastN = lastN;
	}
		
	
}
