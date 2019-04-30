package com.revature;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

public abstract class BankAccount implements Withdraw, Deposit, Apply, createUserName, SignIn, ViewMenu, Approval, UsersInfo, Transfer {
	
	public String accnName;
	public String accnPswd;
	public double balance = 0.0;
	public String firstN;
	public String lastN;
	public boolean approved = false;
	public int userID;
	public Hashtable<String, Double> savingsAcc = new Hashtable<String, Double>();
	public List<String> jointAccs = new ArrayList<String>();
	public boolean cancelled = false;
	

	public int userINDEX;
	public static int INDEX = 0;	

	public BankAccount(){
		super();
		userINDEX = INDEX;
		INDEX++;
	}
	
	
	@Override
	public String toString() {
		return "BankAccount [accnName=" + accnName + ", accnPswd=" + accnPswd + ", balance=" + balance 
				+ ", firstN=" + firstN + ", lastN=" + lastN + ", approved=" + approved 
				+ ", userID=" + userID + ", savingsAcc=" + savingsAcc + ", joingAccs=" + jointAccs + 
				", userINDEX=" + userINDEX + "]";
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

	
	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
	
	public List<String> getJointAccs() {
		return jointAccs;
	}

	public void setJointAccs(String newJoiAccn) {
		this.jointAccs.add(newJoiAccn);
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	public Hashtable<String, Double> getSavingsAcc() {
		return savingsAcc;
	}

	public void setSavingsAcc(Hashtable<String, Double> savingsAcc) {
		this.savingsAcc = savingsAcc;
	}

	public void savingsAccount(int indexNum) {
		
	}
	
	public void jointAccount(int indexNum) {
		
	}
	
	public String getAccnName() {
		return accnName;
	}
	
	public void setAccnName(String accnName) {
		//int indexNumber = BankAccounts.userDic.indexOf(this.accnName);
		//BankAccounts.userDic.set(indexNumber, accnName);
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
		
}

