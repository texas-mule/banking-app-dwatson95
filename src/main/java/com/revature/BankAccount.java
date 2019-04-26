package com.revature;

import java.util.Hashtable;

public abstract class BankAccount implements Withdraw, Deposit, Apply, createUserName, SignIn, ViewMenu {
	
	public String accnName;
	public String accnPswd;
	public double balance = 0.0;
	public String firstN;
	public String lastN;
	public boolean approved = false;
	public int userID;
	public Hashtable<String, Double> savingsAcc = new Hashtable<String, Double>();
	public Hashtable<String, Double> jointAcc = new Hashtable<String, Double>();
	public int userINDEX;
	public static int INDEX = 0;	

	//public List<String> pswdDic = new ArrayList<String>();
	
	
	public BankAccount(){
		super();
//		try (FileWriter fw = new FileWriter("output.txt", true)){
//			fw.append(accnName + accnPswd + balance + firstN + lastN + approved);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		userINDEX = INDEX;
		INDEX++;
	}
	
	public Hashtable<String, Double> getSavingsAcc() {
		return savingsAcc;
	}

	public void setSavingsAcc(Hashtable<String, Double> savingsAcc) {
		this.savingsAcc = savingsAcc;
	}

	public void savingsAccount() {
		
	}
	
	public void jointAccount() {
		
	}
	
	public String getAccnName() {
		return accnName;
	}
	
	public void setAccnName(String accnName) {
		int indexNumber = BankAccounts.userDic.indexOf(this.accnName);
		BankAccounts.userDic.set(indexNumber, accnName);
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

	public int getUserINDEX() {
		return userINDEX;
	}
	
//	public void setBankDic() {
//	bankDic.add(new BankAccount(accnName, accnPswd, balance));
//	this.bankDic.add(BankAccount());
//}
		
}

