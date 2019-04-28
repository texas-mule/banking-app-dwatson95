package com.revature;

import java.util.Scanner;

public class CustomerAccount extends BankAccount {

	public CustomerAccount() {
		super();
		this.userID = 0;
	}
	
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
			System.out.println("");
			
			if (option == 1) {
				System.out.println("Please enter the amount you wish to withdraw.");
				input = s.nextDouble();
				System.out.println("");
				
				curentBalance = BankAccounts.bankDic.get(indexNum).getBalance();
				int exit = 0;
				do {
					if(input < curentBalance && input >= 0) {
						System.out.println("Your input of " + input + " has been withdrawn.");
						curentBalance = curentBalance - input;
						BankAccounts.bankDic.get(indexNum).setBalance(curentBalance);
						System.out.println("Your current balance is now $" + curentBalance + ".");
						System.out.println("");
					}
					else if(input > curentBalance) {
						System.out.println("This input exceeds current funds.");
						System.out.println("Your current balance is" + balance + ".");
						System.out.println("Please enter another value or choose a different option.");
						System.out.println("");
					}
					else {
						System.out.println("This input of " + input + " exceeds current bounds of logic, "
								+ "please enter another value or choose a different option.");
						System.out.println("");
					}
				} while(exit == 0);
				
			} else if (option == 2) {
				// if they don't like the fact you have to know it, well it's a safety feature
				System.out.println("Your current savings accounts are.");
				System.out.println(BankAccounts.bankDic.get(indexNum).getSavingsAcc());
				System.out.println("Please enter the savings account you would like to withdraw from.");
				keyLookUp = s.nextLine();
				System.out.println("");
				
				while(!contains) {
					contains = BankAccounts.bankDic.get(indexNum).savingsAcc.containsKey(keyLookUp);
					if (!contains) {
						System.out.println("Sorry that savings account does not exist.");
						System.out.println("Please enter another name.");
						keyLookUp = s.nextLine();
						System.out.println("");
						attempts++;
						if (attempts > 3) {
							System.out.println("Sorry for the inconvience, but you've reached your"
									+ " limit on account access atempts.");
							System.out.println("Please try again later.");
							System.out.println("");
							s.close();
							return;
						}
					}
				}
				
				curentBalance = BankAccounts.bankDic.get(indexNum).savingsAcc.get(keyLookUp);
				int exit = 0;
				do {
					System.out.println("Please enter you withdraw amount.");
					input = s.nextDouble();
					System.out.println("");
					
					if(input < curentBalance && input >= 0) {
						System.out.println("Your input of " + input + " has been withdrawn.");
						curentBalance = curentBalance - input;
						BankAccounts.bankDic.get(indexNum).setBalance(curentBalance);
						System.out.println("Your current balance is now $" + curentBalance + ".");
						BankAccounts.bankDic.get(indexNum).savingsAcc.put(keyLookUp, curentBalance);
						System.out.println("");
						exit = 1;
					} else if(input > curentBalance) {
						System.out.println("This input exceeds current funds.");
						System.out.println("Your current balance is" + curentBalance + ".");
						System.out.println("Please enter another value or choose a different option.");
						System.out.println("");
					} else {
						System.out.println("This input of " + input + " exceeds current bounds of logic, "
								+ "please enter another value or choose a different option.");
						System.out.println("");
					}
					
				} while (exit == 0);
				
			} else if (option == 3) {
				// if they don't like the fact you have to know it, well it's a safety feature
				System.out.println("Your current joint accounts are.");
				System.out.println(BankAccounts.bankDic.get(indexNum).getJointAccs());
				System.out.println("Please enter the joint account you would like to withdraw from.");
				keyLookUp = s.nextLine();
				System.out.println("");
				
				while(!contains) {
					contains = BankAccounts.usersJointAcc.containsKey(keyLookUp);
					if (!contains) {
						System.out.println("Sorry that savings account does not exist.");
						System.out.println("Please enter another name.");
						keyLookUp = s.nextLine();
						System.out.println("");
						attempts++;
						if (attempts > 3) {
							System.out.println("Sorry for the inconvience, but you've reached your"
									+ " limit on account access attempts.");
							System.out.println("Please try again later.");
							System.out.println("");
							s.close();
							return;
						}
					}
				}
				
				curentBalance = BankAccounts.usersJointAcc.get(keyLookUp);
				int exit = 0;
				do {
					System.out.println("Please enter you withdraw amount.");
					input = s.nextDouble();
					System.out.println("");
					
					if(input < curentBalance && input >= 0) {
						System.out.println("Your input of " + input + " has been withdrawn.");
						curentBalance = curentBalance - input;
						System.out.println("Your current balance is now $" + curentBalance + ".");
						BankAccounts.usersJointAcc.put(keyLookUp, curentBalance);
						System.out.println("");
						exit = 1;
					} else if(input > curentBalance) {
						System.out.println("This input exceeds current funds.");
						System.out.println("Your current balance is" + curentBalance + ".");
						System.out.println("Please enter another value or choose a different option.");
						System.out.println("");
					} else {
						System.out.println("This input of " + input + " exceeds current bounds of logic, "
								+ "please enter another value or choose a different option.");
						System.out.println("");
					}
				} while (exit == 0);
				
			} else {
				System.out.println("That value is invalid please input one of the given options.");
				System.out.println("");
			}
			
		} while (option != 4);
		s.close();
	}
	
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
			System.out.println("");
			
			if (option == 1) {
				curentBalance = BankAccounts.bankDic.get(indexNum).getBalance();
				int exit = 0;
				do {
					System.out.println("Please enter the amount you wish to deposit.");
					input = s.nextDouble();
					System.out.println("");
					
					if (input > 0){
						System.out.println("Your input of " + input + " has been deposited.");
						curentBalance = curentBalance + input;
						BankAccounts.bankDic.get(indexNum).setBalance(curentBalance);
						System.out.println("Your current balance is now $" + curentBalance + ".");
						System.out.println("");
						exit = 1;
					}
					else{
						System.out.println("This input of " + input + " exceeds current bounds of logic, "
								+ "please enter a value greater than 0.");
						System.out.println("");
					}	
				} while (exit == 0);
				
			} else if (option == 2) {
				// if they don't like the fact you have to know it, well it's a safety feature
				System.out.println("Your current joint accounts are.");
				System.out.println(BankAccounts.bankDic.get(indexNum).getSavingsAcc());
				System.out.println("Please enter the savings account you would like to deposit to.");
				keyLookUp = s.nextLine();
				System.out.println("");
				
				while(!contains) {
					contains = BankAccounts.bankDic.get(indexNum).savingsAcc.containsKey(keyLookUp);
					if (!contains) {
						System.out.println("Sorry that savings account does not exist.");
						System.out.println("Please enter another name.");
						keyLookUp = s.nextLine();
						System.out.println("");
						attempts++;
						
						if (attempts > 3) {
							System.out.println("Sorry for the inconvience, but you've reached your"
									+ " limit on account access attempts.");
							System.out.println("Please try again later.");
							System.out.println("");
							s.close();
							return;
						}
					}
				}
				
				curentBalance = BankAccounts.bankDic.get(indexNum).savingsAcc.get(keyLookUp);
								
				System.out.println("Please enter you deposit amount.");
				input = s.nextDouble();
				System.out.println("");
				
				int exit = 0;
				do {
					System.out.println("Please enter the amount you wish to deposit.");
					input = s.nextDouble();
					System.out.println("");
					
					if (input > 0){
						System.out.println("Your input of " + input + " has been deposited.");
						curentBalance = curentBalance + input;
						BankAccounts.bankDic.get(indexNum).setBalance(curentBalance);
						System.out.println("Your current balance is now $" + curentBalance + ".");
						BankAccounts.bankDic.get(indexNum).savingsAcc.put(keyLookUp, curentBalance);
						System.out.println("");
						exit = 1;
					}
					else{
						System.out.println("This input of " + input + " exceeds current bounds of logic, "
								+ "please enter a value greater than 0.");
						System.out.println("");
					}	
				} while (exit == 0);
				
			} else if (option == 3) {
				// if they don't like the fact you have to know it, well it's a safety feature
				System.out.println("Your current joint accounts are.");
				System.out.println(BankAccounts.bankDic.get(indexNum).getJointAccs());
				System.out.println("Please enter the joint account you would like to deposit to.");
				keyLookUp = s.nextLine();
				System.out.println("");
				
				while(!contains) {
					contains = BankAccounts.usersJointAcc.containsKey(keyLookUp);
					if (!contains) {
						System.out.println("Sorry that savings account does not exist.");
						System.out.println("Please enter another name.");
						keyLookUp = s.nextLine();
						System.out.println("");
						attempts++;
						if (attempts > 3) {
							System.out.println("Sorry for the inconvience, but you've reached your"
									+ " limit on account access attempts.");
							System.out.println("Please try again later.");
							System.out.println("");
							s.close();
							return;
						}
					}
				}
				
				curentBalance = BankAccounts.usersJointAcc.get(keyLookUp);
				int exit = 0;
				do {
					System.out.println("Please enter the amount you wish to deposit.");
					input = s.nextDouble();
					System.out.println("");
					
					if (input > 0){
						System.out.println("Your input of " + input + " has been deposited.");
						curentBalance = curentBalance + input;
						System.out.println("Your current balance is now $" + curentBalance + ".");
						BankAccounts.usersJointAcc.put(keyLookUp, curentBalance);
						System.out.println("");
						exit = 1;
					}
					else{
						System.out.println("This input of " + input + " exceeds current bounds of logic, "
								+ "please enter a value greater than 0.");
						System.out.println("");
					}	
				} while (exit == 0);
			} else {
				System.out.println("That value is invalid please input one of the given options.");
				System.out.println("");
			}
			
		} while (option != 4);
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
			System.out.println("");
			if (BankAccounts.bankDic.get(indexNum).savingsAcc.containsKey(newSavAccn)) {
				System.out.println("Sorry for the inconvience but it seems this account already exsist.");
				System.out.println("Please try a different name for your savings account.");
				System.out.println("");
			}
			else
				i = 1;
				
		} while(i == 0);
		
		int a;
		do {
			System.out.println("How much money would you like to deposit in you savings account");
			double initDeposit = s.nextDouble();
			System.out.println("");
			if (initDeposit < 0) {
				System.out.println("Please enter a proper amount.");
				System.out.println("");
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
			System.out.println("");
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
			System.out.println("");
			exist = BankAccounts.userDic.contains(newJoiAccnHolder);
			if (exist) {
				// give the user the newJoiAccn name
				
				newJoiHolderIndex = BankAccounts.bankIndex.get(newJoiAccnHolder);
				BankAccounts.bankDic.get(newJoiHolderIndex).setJointAccs(newJoiAccn);
				do {
					System.out.println("Choose to either continue or add another user.");
					System.out.println("0 - Add another user.");
					System.out.println("1 - Continue to depsoit");
					j = s.nextInt();
					System.out.println("");
					if (j != 1 || j != 0) {
						System.out.println("Sorry for the inconvience but that's not an option.");
						System.out.println("");
					}
				}while(j != 1 || j != 0);
				
			} else {
				System.out.println("Sorry for the inconvience but this user does not exist.");
				System.out.println("Please try a different name for your joint account.");
				System.out.println("");
			}

		} while(j == 0);
		int a = 1;
		do {
			System.out.println("How much money would you like to deposit in you savings account");
			double initDeposit = s.nextDouble();
			System.out.println("");
			if (initDeposit < 0) {
				System.out.println("Please enter a proper amount.");
				System.out.println("");
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
	public void usersInfo(int indexNum) {
		BankAccounts.bankDic.get(indexNum).toString();
		System.out.println("");
	}
	
	@Override
	public void viewMenu(int indexNum) {
		Scanner s = new Scanner(System.in);
		int choice;
		double curentBalance;
		if (BankAccounts.bankDic.get(indexNum).isApproved()) {
			System.out.println("Welcome to Revature Bank!");
		} else {
			System.out.println("Sorry for the inconveince, it seems your account isn't approved.");
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
			System.out.println("6 - Check account information");
			System.out.println("7 - Log out");
			choice = s.nextInt();
			System.out.println("");
			
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
			else if (choice == 6)
				usersInfo(indexNum);
			else if (choice == 7)
				System.out.println("Thank you for choosing RV Bank");
			else {
				System.out.println("That's an invalid option.");
				System.out.println("");
			}
		
		} while (choice != 7);
		
		s.close(); 
	}

	@Override
	public void approval() {
		System.out.println("Customer does not have access to this method.");
	}
}
