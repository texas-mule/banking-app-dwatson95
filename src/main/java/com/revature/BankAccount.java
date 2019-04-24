package com.revature;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

public abstract class BankAccount implements Withdraw, Deposit, Apply, createUserName, SignIn, ViewMenu {
	
	public String accnName;
	public String accnPswd;
	public double balance;
	public String firstN;
	public String lastN;
	public boolean approved = false;
	
	public List<String> userDic = new ArrayList<String>();
	public List<BankAccount> bankDic = new ArrayList<BankAccount>();
	public Hashtable<String, Double> savingsAcc = new Hashtable<String, Double>();
	public HashMap<String, String> userSavDic = new HashMap<String, String>();

	
	//public List<String> pswdDic = new ArrayList<String>();
	
	
	public BankAccount(String accnName, String accnPswd, double balance){
		super();
				
//		try (FileWriter fw = new FileWriter("output.txt", true)){
//			fw.append(accnName + accnPswd + balance + firstN + lastN + approved);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	
	public Hashtable<String, Double> getSavingsAcc() {
		return savingsAcc;
	}

	public void setSavingsAcc(Hashtable<String, Double> savingsAcc) {
		this.savingsAcc = savingsAcc;
	}
	
	public String getAccnName() {
		return accnName;
	}
	public void setAccnName(String accnName) {
		int indexNumber = userDic.indexOf(this.accnName);
		userDic.set(indexNumber, accnName);
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
//	public void setBankDic() {
//	bankDic.add(new BankAccount(accnName, accnPswd, balance));
//	this.bankDic.add(BankAccount());
//}
		
}
