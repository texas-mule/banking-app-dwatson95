package com.revature;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class BankAccount implements Withdraw, Deposit, Apply, createUserName, SignIn, ViewMenu, Approval {
	
	public String accnName;
	public String accnPswd;
	public double balance = 0.0;
	public String firstN;
	public String lastN;
	public boolean approved = false;
	public int userID;
	public Hashtable<String, Double> savingsAcc = new Hashtable<String, Double>();
	public List<String> jointAccs = new ArrayList<String>();

	public int userINDEX;
	public static int INDEX = 0;	

	public BankAccount(){
		super();
		userINDEX = INDEX;
		INDEX++;
	}
	
	@Override
	public void approval() {
		
	}
	
	@Override
	public String toString() {
		return "BankAccount [accnName=" + accnName + ", accnPswd=" + accnPswd + ", balance=" + balance 
				+ ", firstN=" + firstN + ", lastN=" + lastN + ", approved=" + approved 
				+ ", userID=" + userID + ", savingsAcc=" + savingsAcc + ", joingAccs=" + jointAccs + 
				", userINDEX=" + userINDEX + "]";
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
		
}

