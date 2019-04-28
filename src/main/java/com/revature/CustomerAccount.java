package com.revature;

import java.util.Scanner;

public class CustomerAccount extends BankAccount {

	public CustomerAccount() {
		super();
		this.userID = 0;
	}
	
	//add joint
	public void withdraw(int indexNum) {
		double input;
		Scanner s = new Scanner(System.in);
		double curentBalance;
		int option;
		String keyLookUp;
		boolean contains = false;
		int attempts = 0;
		do {
		
			System.out.println("Please enter the option which you would like to make.");
			System.out.println("1 - Withdraw from Checkings Account");
			System.out.println("2 - Withdraw from Savings Account");
			System.out.println("3 - Withdraw from Joint Account");
			System.out.println("4 - Logout");
			
			option = s.nextInt();
			if (option == 1) {
				System.out.println("Please enter the amount you wish to withdraw.");
				input = s.nextDouble();
				
				curentBalance = BankAccounts.bankDic.get(indexNum).getBalance();
				int exit = 0;
				do {
					if(input < curentBalance && input >= 0) {
						System.out.println("Your input of " + input + " has been withdrawn.");
						curentBalance = curentBalance - input;
						BankAccounts.bankDic.get(indexNum).setBalance(curentBalance);
						System.out.println("Your current balance is now $" + curentBalance + ".");
					}
					else if(input > curentBalance) {
						System.out.println("This input exceeds current funds.");
						System.out.println("Your current balance is" + balance + ".");
						System.out.println("Please enter another value or choose a different option.");
					}
					else {
						System.out.println("This input of " + input + " exceeds current bounds of logic, "
								+ "please enter another value or choose a different option.");
					}
				} while(exit == 0);
				
			} else if (option == 2) {
				// if they don't like the fact you have to know it, well it's a safety feature
				System.out.println("Your current savings accounts are.");
				System.out.println(BankAccounts.bankDic.get(indexNum).getSavingsAcc());
				System.out.println("Please enter the savings account you would like to withdraw from.");
				keyLookUp = s.nextLine();
				while(!contains) {
					contains = BankAccounts.bankDic.get(indexNum).savingsAcc.containsKey(keyLookUp);
					if (!contains) {
						System.out.println("Sorry that savings account does not exist.");
						System.out.println("Please enter another name.");
						keyLookUp = s.nextLine();
						attempts++;
						if (attempts > 3) {
							System.out.println("Sorry for the inconvience, but you've reached your"
									+ " limit on account access atempts.");
							System.out.println("Please try again later.");
							return;
						}
					}
				}
				
				curentBalance = BankAccounts.bankDic.get(indexNum).savingsAcc.get(keyLookUp);
				int exit = 0;
				do {
					System.out.println("Please enter you withdraw amount.");
					input = s.nextDouble();
					
					if(input < curentBalance && input >= 0) {
						System.out.println("Your input of " + input + " has been withdrawn.");
						curentBalance = curentBalance - input;
						BankAccounts.bankDic.get(indexNum).setBalance(curentBalance);
						System.out.println("Your current balance is now $" + curentBalance + ".");
						BankAccounts.bankDic.get(indexNum).savingsAcc.put(keyLookUp, curentBalance);
						exit = 1;
					} else if(input > curentBalance) {
						System.out.println("This input exceeds current funds.");
						System.out.println("Your current balance is" + curentBalance + ".");
						System.out.println("Please enter another value or choose a different option.");
					} else {
						System.out.println("This input of " + input + " exceeds current bounds of logic, "
								+ "please enter another value or choose a different option.");
					}
					
				} while (exit == 0);
				
			} else if (option == 3) {
				// if they don't like the fact you have to know it, well it's a safety feature
				System.out.println("Your current joint accounts are.");
				System.out.println(BankAccounts.bankDic.get(indexNum).getJointAccs());
				System.out.println("Please enter the joint account you would like to withdraw from.");
				keyLookUp = s.nextLine();
				while(!contains) {
					contains = BankAccounts.usersJointAcc.containsKey(keyLookUp);
					if (!contains) {
						System.out.println("Sorry that savings account does not exist.");
						System.out.println("Please enter another name.");
						keyLookUp = s.nextLine();
						attempts++;
						if (attempts > 3) {
							System.out.println("Sorry for the inconvience, but you've reached your"
									+ " limit on account access attempts.");
							System.out.println("Please try again later.");
							return;
						}
					}
				}
				
				curentBalance = BankAccounts.usersJointAcc.get(keyLookUp);
				int exit = 0;
				do {
					System.out.println("Please enter you withdraw amount.");
					input = s.nextDouble();
					
					if(input < curentBalance && input >= 0) {
						System.out.println("Your input of " + input + " has been withdrawn.");
						curentBalance = curentBalance - input;
						System.out.println("Your current balance is now $" + curentBalance + ".");
						BankAccounts.usersJointAcc.put(keyLookUp, curentBalance);
						exit = 1;
					} else if(input > curentBalance) {
						System.out.println("This input exceeds current funds.");
						System.out.println("Your current balance is" + curentBalance + ".");
						System.out.println("Please enter another value or choose a different option.");
					} else {
						System.out.println("This input of " + input + " exceeds current bounds of logic, "
								+ "please enter another value or choose a different option.");
					}
				} while (exit == 0);
				
			} else {
				System.out.println("That value is invalid please input one of the given options.");
			}
			
		} while (option != 4);
		s.close();
	}
	//add joint
	public void deposit(int indexNum) {
		Scanner s = new Scanner(System.in);
		double curentBalance;
		double input;
		int attempts = 0;
		int option;
		String keyLookUp;
		boolean contains = false;
		do {
		
			System.out.println("Please enter the option which you would like to make.");
			System.out.println("1 - Deposit to Checkings Account");
			System.out.println("2 - Deposit to Savings Account");
			System.out.println("3 - Deposit to Joint Account");
			System.out.println("4 - Logout");
			
			option = s.nextInt();
			if (option == 1) {
				curentBalance = BankAccounts.bankDic.get(indexNum).getBalance();
				int exit = 0;
				do {
					System.out.println("Please enter the amount you wish to deposit.");
					input = s.nextDouble();
					
					if (input > 0){
						System.out.println("Your input of " + input + " has been deposited.");
						curentBalance = curentBalance + input;
						BankAccounts.bankDic.get(indexNum).setBalance(curentBalance);
						System.out.println("Your current balance is now $" + curentBalance + ".");
						exit = 1;
					}
					else{
						System.out.println("This input of " + input + " exceeds current bounds of logic, "
								+ "please enter a value greater than 0.");
					}	
				} while (exit == 0);
				
			} else if (option == 2) {
				// if they don't like the fact you have to know it, well it's a safety feature
				System.out.println("Your current joint accounts are.");
				System.out.println(BankAccounts.bankDic.get(indexNum).getSavingsAcc());
				System.out.println("Please enter the savings account you would like to deposit to.");
				keyLookUp = s.nextLine();
				
				while(!contains) {
					contains = BankAccounts.bankDic.get(indexNum).savingsAcc.containsKey(keyLookUp);
					if (!contains) {
						System.out.println("Sorry that savings account does not exist.");
						System.out.println("Please enter another name.");
						keyLookUp = s.nextLine();
						attempts++;
						if (attempts > 3) {
							System.out.println("Sorry for the inconvience, but you've reached your"
									+ " limit on account access attempts.");
							System.out.println("Please try again later.");
							return;
						}
					}
				}
				
				curentBalance = BankAccounts.bankDic.get(indexNum).savingsAcc.get(keyLookUp);
								
				System.out.println("Please enter you deposit amount.");
				input = s.nextDouble();
				
				int exit = 0;
				do {
					System.out.println("Please enter the amount you wish to deposit.");
					input = s.nextDouble();
					
					if (input > 0){
						System.out.println("Your input of " + input + " has been deposited.");
						curentBalance = curentBalance + input;
						BankAccounts.bankDic.get(indexNum).setBalance(curentBalance);
						System.out.println("Your current balance is now $" + curentBalance + ".");
						BankAccounts.bankDic.get(indexNum).savingsAcc.put(keyLookUp, curentBalance);
						exit = 1;
					}
					else{
						System.out.println("This input of " + input + " exceeds current bounds of logic, "
								+ "please enter a value greater than 0.");
					}	
				} while (exit == 0);
				
			} else if (option == 3) {
				// if they don't like the fact you have to know it, well it's a safety feature
				System.out.println("Your current joint accounts are.");
				System.out.println(BankAccounts.bankDic.get(indexNum).getJointAccs());
				System.out.println("Please enter the joint account you would like to deposit to.");
				keyLookUp = s.nextLine();
				
				while(!contains) {
					contains = BankAccounts.usersJointAcc.containsKey(keyLookUp);
					if (!contains) {
						System.out.println("Sorry that savings account does not exist.");
						System.out.println("Please enter another name.");
						keyLookUp = s.nextLine();
						attempts++;
						if (attempts > 3) {
							System.out.println("Sorry for the inconvience, but you've reached your"
									+ " limit on account access attempts.");
							System.out.println("Please try again later.");
							return;
						}
					}
				}
				
				curentBalance = BankAccounts.usersJointAcc.get(keyLookUp);
				int exit = 0;
				do {
					System.out.println("Please enter the amount you wish to deposit.");
					input = s.nextDouble();
					if (input > 0){
						System.out.println("Your input of " + input + " has been deposited.");
						curentBalance = curentBalance + input;
						System.out.println("Your current balance is now $" + curentBalance + ".");
						BankAccounts.usersJointAcc.put(keyLookUp, curentBalance);
						exit = 1;
					}
					else{
						System.out.println("This input of " + input + " exceeds current bounds of logic, "
								+ "please enter a value greater than 0.");
					}	
				} while (exit == 0);
			} else {
				System.out.println("That value is invalid please input one of the given options.");
			}
			
		} while (option != 4);
		s.close();
	}
	
	@Override
	public void signIn(String username, String password) {
		Scanner s = new Scanner(System.in);
		int userIndex = 0;
		//choice = s.nextLine();
		
		String checkPswd, checkUsername;
		checkUsername = username;
		boolean doHaveKey = false;
		
		do {
			doHaveKey = BankAccounts.userToPswd.containsKey(checkUsername);
			if (doHaveKey) {
				checkPswd = BankAccounts.userToPswd.get(checkUsername);
				boolean rightPword = checkPswd.equals(password);
				do {
					if (rightPword) {
						userIndex = BankAccounts.bankIndex.get(checkUsername);
						viewMenu(userIndex);
					}
					else {
						System.out.println("That password is not in our systems, please enter another one.");
						password = s.nextLine();
					}
				} while(!rightPword);
			}
			else {
				System.out.println("That username is not in our systems, please enter another one.");
				checkUsername = s.nextLine();
			}
		} while(!doHaveKey);
		
		s.close();
	}
	
	public void savingsAccount(int indexNum) {
		Scanner s = new Scanner(System.in);
		System.out.println("To create an savings account, please input an account name.");
		String newSavAccn;
		int i = 0;
		do {
			System.out.println("This name should be unique and creative as to easily find.");
			newSavAccn = s.nextLine();
			if (BankAccounts.bankDic.get(indexNum).savingsAcc.containsKey(newSavAccn)) {
				System.out.println("Sorry for the inconvience but it seems this account already exsist.");
				System.out.println("Please try a different name for your savings account.");
			}
			else
				i = 1;
				
		} while(i == 0);
		
		int a;
		do {
			System.out.println("How much money would you like to deposit in you savings account");
			double initDeposit = s.nextDouble();
			if (initDeposit < 0) {
				System.out.println("Please enter a proper amount.");
				a = 0;
			}
			else {
				a = 1;
				BankAccounts.bankDic.get(indexNum).savingsAcc.put(newSavAccn, initDeposit);
				BankAccounts.usersSavingsAcc.put(newSavAccn, BankAccounts.bankDic.get(indexNum).getAccnName());
			}
		} while(a != 0);
		
		s.close();
	}
	
	public void jointAccount(int indexNum) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("To create an joint account, please input an account name.");
		String newJoiAccn;
		int i = 0;
		do {
			System.out.println("This name should be unique and creative as to easily find.");
			newJoiAccn = s.nextLine();
			if (BankAccounts.usersJointAcc.containsKey(newJoiAccn)) {
				System.out.println("Sorry for the inconvience but it seems this account already exsist.");
				System.out.println("Please try a different name for your joint account.");
			}
			else
				i = 1;
				
		} while(i == 0);
		
		BankAccounts.bankDic.get(indexNum).setJointAccs(newJoiAccn);
		
		String newJoiAccnHolder;
		int j = 0;
		int newJoiHolderIndex;
		System.out.println("For a join account you can share it with another user.");
		System.out.println("The user will be allowed access to the joint account.");
		boolean exist = false;
		for (String num : BankAccounts.userDic) { 		      
	           System.out.println(num); 		
	      }
		do {
			System.out.println("Please enter the user's username you would like to join.");
			newJoiAccnHolder = s.nextLine();
			exist = BankAccounts.userDic.contains(newJoiAccnHolder);
			if (exist) {
				// give the user the newJoiAccn name
				
				newJoiHolderIndex = BankAccounts.bankIndex.get(newJoiAccnHolder);
				BankAccounts.bankDic.get(newJoiHolderIndex).setJointAccs(newJoiAccn);
				
				System.out.println("Choose to either continue or add another user.");
				System.out.println("0 - Add another user.");
				System.out.println("1 - Continue to depsoit");
				j = s.nextInt();
				if (j != 1 || j != 0) {
					System.out.println("Sorry for the inconvience but it seems this account already exsist.");
					System.out.println("Please try a different name for your joint account.");
					j = 0;
				}
				
			} else {
				System.out.println("Sorry for the inconvience but this user does not exist.");
				System.out.println("Please try a different name for your joint account.");
			}

		} while(j == 0);
		int a = 1;
		do {
			System.out.println("How much money would you like to deposit in you savings account");
			double initDeposit = s.nextDouble();
			if (initDeposit < 0) {
				System.out.println("Please enter a proper amount.");
				a = 0;
			}
			else {
				a = 1;
				BankAccounts.usersJointAcc.put(newJoiAccn, initDeposit);
			}
		} while(a != 0);
		
		s.close();
	}
	
	@Override
	public void viewMenu(int indexNum) {
		Scanner s = new Scanner(System.in);
		int choice;
		double curentBalance;
		if (BankAccounts.bankDic.get(indexNum).isApproved()) {
			System.out.println("Welcome to Revature Bank!");
		} else {
			System.out.println("Sorry for the inconveince, it seems your account isn't approved yet.");
			s.close(); 
			return;
		}
		
		do {
			System.out.println("Please choose from one of the options");
			System.out.println("1 - Check current balance.");
			System.out.println("2 - Withdraw");
			System.out.println("3 - Deposit");
			System.out.println("4 - Create savings account");
			System.out.println("5 - Create joint account");
			System.out.println("6 - Log out");
			choice = s.nextInt();
			
			if (choice == 1) {
				curentBalance = BankAccounts.bankDic.get(indexNum).getBalance();
				System.out.println("Your current balance is $" + curentBalance);
			} 
			else if (choice == 2)
				withdraw(indexNum);
			else if (choice == 3)
				deposit(indexNum);
			else if (choice == 4)
				savingsAccount(indexNum);
			else if (choice == 5)
				jointAccount(indexNum);
		
		} while (choice != 6);
		
		s.close(); 
	}

}
