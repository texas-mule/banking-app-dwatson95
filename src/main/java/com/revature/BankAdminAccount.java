package com.revature;

import java.util.Scanner;

public class BankAdminAccount extends BankAccount{
	Scanner s = new Scanner(System.in);
	
	@Override
	public void withdraw(int indexNum) {
		double input;
		
		double curentBalance;
		int option;
		String keyLookUp;
		boolean contains;
		int attempts = 0;
		
		do {
			contains = false;
			System.out.println("Please enter the option which you would like to make.");
			System.out.println("1 - Withdraw from a Checkings Account");
			System.out.println("2 - Withdraw from a Savings Account");
			System.out.println("3 - Withdraw from a Joint Account");
			System.out.println("4 - Logout");
			option = s.nextInt();
			System.out.println("");
			
			if (option == 1) {
				String accountChoice;
				for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
					String user = BankAccounts.userDic.get(counter); 
					boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isApproved();
					if (isappr == true) {
						System.out.println(user);
					}
				}
				System.out.println("");
				int i = 0;
				do {
					System.out.println("Please enter the account you wish to withdraw from.");
					accountChoice = s.nextLine();
					System.out.println("");
					if (BankAccounts.userDic.contains(accountChoice)) {
						int trueIndexNumber = BankAccounts.bankIndex.get(accountChoice);
						curentBalance = BankAccounts.bankDic.get(trueIndexNumber).getBalance();
						System.out.println("The current account has $" + curentBalance + ".");
						System.out.println("Please enter the amount you wish to withdraw.");
						input = s.nextDouble();
						System.out.println("");
						int exit = 0;
						do {
							if(input < curentBalance && input >= 0) {
								System.out.println("The input of " + input + " has been withdrawn.");
								curentBalance = curentBalance - input;
								BankAccounts.bankDic.get(trueIndexNumber).setBalance(curentBalance);
								System.out.println("THe current balance is now $" + curentBalance + ".");
								System.out.println("");
								exit = 1;
							}
							else if(input > curentBalance) {
								System.out.println("This input exceeds current funds.");
								System.out.println("The current balance is" + balance + ".");
								System.out.println("Please enter another value or choose a different option.");
								System.out.println("");
							}
							else {
								System.out.println("This input of " + input + " exceeds current bounds of logic, "
										+ "please enter another value or choose a different option.");
								System.out.println("");
							}
						} while(exit == 0);
						i = 1;
					}
					else {
						System.out.println("This input of exceeds current bounds of logic.");
						System.out.println("");
					}
				} while(i == 0);
			} else if (option == 2) {
				// if they don't like the fact you have to know it, well it's a safety feature
				String accountChoice;
				for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
					String user = BankAccounts.userDic.get(counter); 
					boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isApproved();
					if (isappr == true) {
						System.out.println(user);
					}
				}
				System.out.println("");
				int i = 0;
				do {
					System.out.println("Please enter the account you wish to withdraw from.");
					accountChoice = s.nextLine();
					System.out.println("");
					if (BankAccounts.userDic.contains(accountChoice)) {
						int trueIndexNumber = BankAccounts.bankIndex.get(accountChoice);
						System.out.println("The current savings accounts in this account are.");
						System.out.println(BankAccounts.bankDic.get(trueIndexNumber).getSavingsAcc());
						System.out.println("Please enter the savings account you would like to withdraw from.");
						keyLookUp = s.nextLine();
						System.out.println("");
						
						while(!contains) {
							contains = BankAccounts.bankDic.get(trueIndexNumber).savingsAcc.containsKey(keyLookUp);
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
									//s.close();
									return;
								}
							}
						}
						
						curentBalance = BankAccounts.bankDic.get(trueIndexNumber).savingsAcc.get(keyLookUp);
						int exit = 0;
						System.out.println("The current account has $" + curentBalance + ".");
						do {
							System.out.println("Please enter your withdraw amount.");
							input = s.nextDouble();
							System.out.println("");
							
							if(input < curentBalance && input >= 0) {
								System.out.println("Your input of " + input + " has been withdrawn.");
								curentBalance = curentBalance - input;
								BankAccounts.bankDic.get(trueIndexNumber).setBalance(curentBalance);
								System.out.println("The current balance is now $" + curentBalance 
										+ " in" + keyLookUp + ".");
								BankAccounts.bankDic.get(trueIndexNumber).savingsAcc.replace(keyLookUp, curentBalance);
								System.out.println("");
								exit = 1;
							} else if(input > curentBalance) {
								System.out.println("This input exceeds current funds.");
								System.out.println("The current balance is" + curentBalance + ".");
								System.out.println("Please enter another value or choose a different option.");
								System.out.println("");
							} else {
								System.out.println("This input of " + input + " exceeds current bounds of logic, "
										+ "please enter another value or choose a different option.");
								System.out.println("");
							}
							
						} while (exit == 0);
						
						i = 1;
						
					}
					else {
						System.out.println("This input of exceeds current bounds of logic.");
						System.out.println("");
					}
					
				} while(i == 0);
				
			} else if (option == 3) {
				
				String accountChoice;
				for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
					String user = BankAccounts.userDic.get(counter); 
					boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isApproved();
					if (isappr == true) {
						System.out.println(user);
					}
				}
				System.out.println("");
				int i = 0;
				
				do {
					System.out.println("Please enter the account you wish to withdraw from.");
					accountChoice = s.nextLine();
					System.out.println("");
					if (BankAccounts.userDic.contains(accountChoice)) {
						int trueIndexNumber = BankAccounts.bankIndex.get(accountChoice);
						System.out.println("The current joint accounts to this account are.");
						System.out.println(BankAccounts.bankDic.get(trueIndexNumber).getJointAccs());
						System.out.println("Please enter the joint account you would like to withdraw from.");
						keyLookUp = s.nextLine();
						System.out.println("");
						
						while(!contains) {
							contains = BankAccounts.usersJointAcc.containsKey(keyLookUp);
							if (!contains) {
								System.out.println("Sorry that joint account does not exist.");
								System.out.println("Please enter another name.");
								keyLookUp = s.nextLine();
								System.out.println("");
								attempts++;
								if (attempts > 3) {
									System.out.println("Sorry for the inconvience, but you've reached your"
											+ " limit on account access attempts.");
									System.out.println("Please try again later.");
									System.out.println("");
									//s.close();
									return;
								}
							}
						}
						
						curentBalance = BankAccounts.usersJointAcc.get(keyLookUp);
						System.out.println("The current account has $" + curentBalance + ".");
						int exit = 0;
						do {
							System.out.println("Please enter your withdraw amount.");
							input = s.nextDouble();
							System.out.println("");
							
							if(input < curentBalance && input >= 0) {
								System.out.println("Your input of " + input + " has been withdrawn.");
								curentBalance = curentBalance - input;
								System.out.println("Your current balance is now $" + curentBalance + ".");
								BankAccounts.usersJointAcc.replace(keyLookUp, curentBalance);
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
						
						i = 1;
						
					}
					else {
						System.out.println("This input of exceeds current bounds of logic.");
						System.out.println("");
					}
					
				} while(i == 0);
					
				
			} else {
				System.out.println("That value is invalid please input one of the given options.");
				System.out.println("");
			}
			
		} while (option != 4);
		//s.close();
	}

	@Override
	public void deposit(int indexNum) {
		double input;
		double curentBalance;
		int option;
		String keyLookUp;
		boolean contains;
		int attempts = 0;
		
		do {
			contains = false;
			System.out.println("Please enter the option which you would like to make.");
			System.out.println("1 - Deposit to a Checkings Account");
			System.out.println("2 - Deposit to a Savings Account");
			System.out.println("3 - Deposit to a Joint Account");
			System.out.println("4 - Logout");
			option = s.nextInt();
			System.out.println("");
			
			if (option == 1) {
				String accountChoice;
				for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
					String user = BankAccounts.userDic.get(counter); 
					boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isApproved();
					if (isappr == true) {
						System.out.println(user);
					}
				}
				System.out.println("");
				int i = 0;
				do {
					System.out.println("Please enter the account you wish to deposit to.");
					accountChoice = s.nextLine();
					System.out.println("");
					if (BankAccounts.userDic.contains(accountChoice)) {
						int trueIndexNumber = BankAccounts.bankIndex.get(accountChoice);
						curentBalance = BankAccounts.bankDic.get(trueIndexNumber).getBalance();
						System.out.println("The current account has $" + curentBalance + ".");
						System.out.println("Please enter the amount you wish to deposit.");
						input = s.nextDouble();
						System.out.println("");
						int exit = 0;
						do {
							if(input > 0) {
								System.out.println("The input of " + input + " has been withdrawn.");
								curentBalance = curentBalance + input;
								BankAccounts.bankDic.get(trueIndexNumber).setBalance(curentBalance);
								System.out.println("THe current balance is now $" + curentBalance + ".");
								System.out.println("");
								exit = 1;
							}
							else {
								System.out.println("This input of " + input + " exceeds current bounds of logic, "
										+ "please enter another value or choose a different option.");
								System.out.println("");
							}
						} while(exit == 0);
						i = 1;
					}
					else {
						System.out.println("This input of exceeds current bounds of logic.");
						System.out.println("");
					}
				} while(i == 0);
			} else if (option == 2) {
				// if they don't like the fact you have to know it, well it's a safety feature
				String accountChoice;
				for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
					String user = BankAccounts.userDic.get(counter); 
					boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isApproved();
					if (isappr == true) {
						System.out.println(user);
					}
				}
				System.out.println("");
				int i = 0;
				do {
					System.out.println("Please enter the account you wish to deposit to.");
					accountChoice = s.nextLine();
					System.out.println("");
					if (BankAccounts.userDic.contains(accountChoice)) {
						int trueIndexNumber = BankAccounts.bankIndex.get(accountChoice);
						System.out.println("The current savings accounts in this account are.");
						System.out.println(BankAccounts.bankDic.get(trueIndexNumber).getSavingsAcc());
						System.out.println("Please enter the savings account you would like to deposit to.");
						keyLookUp = s.nextLine();
						System.out.println("");
						
						while(!contains) {
							contains = BankAccounts.bankDic.get(trueIndexNumber).savingsAcc.containsKey(keyLookUp);
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
									//s.close();
									return;
								}
							}
						}
						
						curentBalance = BankAccounts.bankDic.get(trueIndexNumber).savingsAcc.get(keyLookUp);
						int exit = 0;
						System.out.println("The current account has $" + curentBalance + ".");
						do {
							System.out.println("Please enter your deposit amount.");
							input = s.nextDouble();
							System.out.println("");
							
							if(input > 0) {
								System.out.println("Your input of " + input + " has been withdrawn.");
								curentBalance = curentBalance + input;
								BankAccounts.bankDic.get(trueIndexNumber).setBalance(curentBalance);
								System.out.println("The current balance is now $" + curentBalance 
										+ " in" + keyLookUp + ".");
								BankAccounts.bankDic.get(trueIndexNumber).savingsAcc.replace(keyLookUp, curentBalance);
								System.out.println("");
								exit = 1;
							} else {
								System.out.println("This input of " + input + " exceeds current bounds of logic, "
										+ "please enter another value or choose a different option.");
								System.out.println("");
							}
							
						} while (exit == 0);
						
						i = 1;
						
					}
					else {
						System.out.println("This input of exceeds current bounds of logic.");
						System.out.println("");
					}
					
				} while(i == 0);
				
			} else if (option == 3) {
				
				String accountChoice;
				for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
					String user = BankAccounts.userDic.get(counter); 
					boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isApproved();
					if (isappr == true) {
						System.out.println(user);
					}
				}
				System.out.println("");
				int i = 0;
				
				do {
					System.out.println("Please enter the account you wish to deposit to.");
					accountChoice = s.nextLine();
					System.out.println("");
					if (BankAccounts.userDic.contains(accountChoice)) {
						int trueIndexNumber = BankAccounts.bankIndex.get(accountChoice);
						System.out.println("The current joint accounts to this account are.");
						System.out.println(BankAccounts.bankDic.get(trueIndexNumber).getJointAccs());
						System.out.println("Please enter the joint account you would like to withdraw from.");
						keyLookUp = s.nextLine();
						System.out.println("");
						
						while(!contains) {
							contains = BankAccounts.usersJointAcc.containsKey(keyLookUp);
							if (!contains) {
								System.out.println("Sorry that joint account does not exist.");
								System.out.println("Please enter another name.");
								keyLookUp = s.nextLine();
								System.out.println("");
								attempts++;
								if (attempts > 3) {
									System.out.println("Sorry for the inconvience, but you've reached your"
											+ " limit on account access attempts.");
									System.out.println("Please try again later.");
									System.out.println("");
									//s.close();
									return;
								}
							}
						}
						
						curentBalance = BankAccounts.usersJointAcc.get(keyLookUp);
						int exit = 0;
						do {
							System.out.println("The current account has $" + curentBalance + ".");
							System.out.println("Please enter your deposit amount.");
							input = s.nextDouble();
							System.out.println("");
							
							if(input > 0) {
								System.out.println("Your input of " + input + " has been deposited.");
								curentBalance = curentBalance + input;
								System.out.println("Your current balance is now $" + curentBalance + ".");
								BankAccounts.usersJointAcc.replace(keyLookUp, curentBalance);
								System.out.println("");
								exit = 1;
							} else {
								System.out.println("This input of " + input + " exceeds current bounds of logic, "
										+ "please enter another value or choose a different option.");
								System.out.println("");
							}
						} while (exit == 0);
						
						i = 1;
						
					}
					else {
						System.out.println("This input of exceeds current bounds of logic.");
						System.out.println("");
					}
					
				} while(i == 0);
					
				
			} else {
				System.out.println("That value is invalid please input one of the given options.");
				System.out.println("");
			}
			
		} while (option != 4);
		//s.close();
		
	}

	@Override
	public void approval() {
		int choice;
		int i = 0; int j = 0;
		String userApproved, userCancelled;
		boolean exist;
		
		System.out.println("Welcome to Revature Bank's approval portal!");
		
		do {
			System.out.println("What would you like to do?");
			System.out.println("1 - Approve User Accounts");
			System.out.println("2 - Cancel User Accounts");
			System.out.println("3 - Return to Admin Menu");
			choice = s.nextInt();
			System.out.println("");
			
			if(choice == 1) {
				System.out.println("The current user's not yet approved are listed below.");
				for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
					String user = BankAccounts.userDic.get(counter); 
					boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isApproved();
					if (isappr == false) {
						System.out.println(user);
					}
				}
				System.out.println("");
				
				do {
					System.out.println("Please enter the username who you wish to approve.");
					userApproved = s.next();
					System.out.println("");
					exist = BankAccounts.userDic.contains(userApproved);
					
					if (exist) {
						System.out.println("The account " + userApproved + " has been approved");
						BankAccounts.bankDic.get(BankAccounts.bankIndex.get(userApproved)).setApproved(true);
						i = 1;
					}
					else 
						System.out.println("That username currently does not exist.");
					
				}while (i == 0);
			} else if (choice == 2) {
				System.out.println("The current user's that are active are listed below.");
				for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
					String user = BankAccounts.userDic.get(counter); 
					boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isCancelled();
					if (isappr == false) {
						System.out.println(user);
					}
				}
				
				System.out.println("");
				
				do {
					System.out.println("Please enter the username who you wish to cancel their account.");
					userCancelled = s.nextLine();
					System.out.println("");
					exist = BankAccounts.userDic.contains(userCancelled);
					
					if (exist) {
						System.out.println("The account " + userCancelled + " has been cancelled");
						BankAccounts.bankDic.get(BankAccounts.bankIndex.get(userCancelled)).setApproved(true);
						j = 1;
					}
					else 
						System.out.println("That username currently does not exist.");
					
				}while (j == 0);
				
			} else if (choice == 3)
				System.out.println("Thank you, you'll be returned to the admin menu now.");
			else 
				System.out.println("That's an invalid choice.");
			
			System.out.println("");
		}while(choice != 3);
		
		//s.close();
	}

	@Override
	public void usersInfo(int indexNum) {
		int choice, i;
		boolean exist;
		String user;
		System.out.println("Your current information is!");
		System.out.println(BankAccounts.bankDic.get(indexNum).toString());
		
		do {
			System.out.println("You can check the current users as well as there information here.");
			
			System.out.println("Please choose from one of the options");
			System.out.println("1 - Check current users.");
			System.out.println("2 - Check a users information");
			System.out.println("3 - Leave");
			choice = s.nextInt();
			System.out.println("");
			
			if (choice == 1) {
				for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) { 		      
			          System.out.println("Username = " + BankAccounts.userDic.get(counter)); 
				}
				System.out.println("");
			}
			else if (choice == 2) {
				do {
					System.out.println("Please choose the user's account you wish to view.");
					user = s.next();
					exist = BankAccounts.userDic.contains(user);
					if (exist) {
						System.out.println(BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).toString());
//						for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
//							String user = BankAccounts.userDic.get(counter); 
//							boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isApproved();
//							if (isappr == false) {
//								System.out.println(user);
//							}
//						}
						i = 1;
					} 
					else {
						System.out.println("That's an invalid option.");
						System.out.println("");
						i = 0;
					}
				
				} while (i == 0);
			}
			else if (choice == 3)
				System.out.println("Returning to user menu.");
			else {
				System.out.println("That's an invalid option.");
				System.out.println("");
			}
		
		} while (choice != 3);
		System.out.println("");
		//s.close();
	}

	@Override
	public void transfer(int indexNum) {
		double input;
		int attempts = 0;
		int option, choice;
		String keyLookUp;
		boolean contains;
		
		do {
			contains = false;
			System.out.println("Please enter the option which you would like to make.");
			System.out.println("1 - Transfer between a Checkings Account and its' Savings Account");
			System.out.println("2 - Transfer between a Checkiings Account and its' Joint Account");
			System.out.println("3 - Transfer between a Savings Account and a Savings Account belonging to the same user");
			System.out.println("4 - Transfer between a Savings Account and a Joint Account belonging to the same user");
			System.out.println("5 - Transfer between a Joint Account and a Joint Account");
			System.out.println("6 - Transfer between a Checkings Account and a Checking Account");
			System.out.println("7 - Logout");
			System.out.println("Note option 6 is the only transfers possible between separate acounts");
			option = s.nextInt();
			System.out.println("");
			
			if (option == 1) {
				int newIndex;
				int i = 0;
				double checkingsBalance, savingsBalance;
				do {
					
					String accountChoice;
					for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
						String user = BankAccounts.userDic.get(counter); 
						boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isApproved();
						if (isappr == true) {
							System.out.println(user);
						}
					}
					System.out.println("");
					int j = 0;
					do {
						System.out.println("Please enter the checkings account you wish to transfer with.");
						accountChoice = s.nextLine();
						System.out.println("");
						if (BankAccounts.userDic.contains(accountChoice)) {
							newIndex = BankAccounts.bankIndex.get(accountChoice);
							int sizeS = BankAccounts.bankDic.get(newIndex).getSavingsAcc().size();
							if (sizeS < 1) {
								System.out.println("This account does not have a savings account "
										+ " and therefore can't be transfered between.");
								System.out.println("Please enter a different account to transfer between.");
								System.out.println("Or you can type in exit and then enter to leave.");
							}
							else {
								j = 1;
							}
						}
						else if (accountChoice.equals("exit")) {
							//s.close();
							return;
						}
						else {
							System.out.println("Please enter a checkings account that exist.");
						}
					} while (j == 0);
					
					newIndex = BankAccounts.bankIndex.get(accountChoice);
					System.out.println("This account's current savings accounts are.");
					System.out.println(BankAccounts.bankDic.get(newIndex).getSavingsAcc());
					while(!contains) {
						System.out.println("Please enter the savings account you would like to trasnfer with.");
						keyLookUp = s.nextLine();
						System.out.println("");
						contains = BankAccounts.bankDic.get(newIndex).savingsAcc.containsKey(keyLookUp);
						
						if (!contains) {
							System.out.println("Sorry that savings account does not exist.");
							System.out.println("Please enter another name.");
							attempts++;
							
							if (attempts > 3) {
								System.out.println("Sorry for the inconvience, but you've reached your"
										+ " limit on account access attempts.");
								System.out.println("Please try again later.");
								System.out.println("");
								//s.close();
								return;
							}
						}
						else {
							savingsBalance = BankAccounts.bankDic.get(newIndex).savingsAcc.get(keyLookUp);
							System.out.println("The current balance in this savings account is"
									+ " $" + savingsBalance);
							checkingsBalance = BankAccounts.bankDic.get(newIndex).getBalance();
							System.out.println("The current balance in this checkings account is"
									+ " $" + checkingsBalance);
							System.out.println("");
							
							do {
								System.out.println("Please enter the option which you would like to make.");
								System.out.println("1 - Transfer from Checkings Account to Savings Account");
								System.out.println("2 - Transfer from Savings Account to Checkings Account");
								choice = s.nextInt();
								System.out.println("");
								
								int exit = 0;
								
								if (choice == 1) {
									do {
										System.out.println("Please enter the amount you wish transfer.");
										input = s.nextDouble();
										System.out.println("");
										
										if (input < checkingsBalance){
											System.out.println("Your input of " + input + " has been transfered.");
											
											checkingsBalance = checkingsBalance - input;
											BankAccounts.bankDic.get(newIndex).setBalance(checkingsBalance);
											savingsBalance = savingsBalance + input;
											BankAccounts.bankDic.get(newIndex).savingsAcc.replace(keyLookUp, savingsBalance);
											
											System.out.println("The current balance in this savings account now is"
													+ " $" + savingsBalance);
											System.out.println("The current balance in this checkings account now is"
													+ " $" + checkingsBalance);
											exit = 1;
										}
										else{
											System.out.println("This input of " + input + " exceeds current bounds of logic, "
													+ "please enter a value greater than 0.");
											System.out.println("");
										}	
									} while (exit == 0);
									i = 1;
								}
								else if (choice == 2) {
									do {
										System.out.println("Please enter the amount you wish transfer.");
										input = s.nextDouble();
										System.out.println("");
										
										if (input < savingsBalance){
											System.out.println("Your input of " + input + " has been transfered.");
											
											checkingsBalance = checkingsBalance + input;
											BankAccounts.bankDic.get(indexNum).setBalance(checkingsBalance);
											savingsBalance = savingsBalance - input;
											BankAccounts.bankDic.get(indexNum).savingsAcc.replace(keyLookUp, savingsBalance);
											
											System.out.println("The current balance in this savings account now is"
													+ " $" + savingsBalance);
											System.out.println("The current balance in this checkings account now is"
													+ " $" + checkingsBalance);
											exit = 1;
										}
										else{
											System.out.println("This input of " + input + " exceeds current bounds of logic, "
													+ "please enter a value greater than 0.");
											System.out.println("");
										}	
									} while (exit == 0);
									i = 1;
								}
								else 
									System.out.println("That option is invalid");
							} while (choice != 1 || choice != 2);
							
							System.out.println("");
							
						}
					}
				} while (i == 0);
				System.out.println("");
				
			} else if (option == 2) {
				int newIndex;
				int i = 0;
				double checkingsBalance, jointBalance;
				do {
					
					String accountChoice;
					for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
						String user = BankAccounts.userDic.get(counter); 
						boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isApproved();
						if (isappr == true) {
							System.out.println(user);
						}
					}
					System.out.println("");
					int j = 0;
					do {
						System.out.println("Please enter the checkings account you wish to transfer with.");
						accountChoice = s.nextLine();
						System.out.println("");
						if (BankAccounts.userDic.contains(accountChoice)) {
							newIndex = BankAccounts.bankIndex.get(accountChoice);
							int sizeJ = BankAccounts.bankDic.get(newIndex).getJointAccs().size();
							if (sizeJ < 1) {
								System.out.println("This account does not have a joint"
										+ " and therefore can't be transfered between.");
								System.out.println("Please enter a different account to transfer between.");
								System.out.println("Or you can type in exit and then enter to leave.");
							}
							else {
								j = 1;
							}
						}
						else if (accountChoice.equals("exit")) {
							//s.close();
							return;
						}
						else {
							System.out.println("Please enter a checkings account that exist.");
						}
					} while (j == 0);
					
					newIndex = BankAccounts.bankIndex.get(accountChoice);
					System.out.println("This account's current joint accounts are.");
					System.out.println(BankAccounts.bankDic.get(newIndex).getJointAccs());
					while(!contains) {
						System.out.println("Please enter the joint account you would like to transfer with.");
						keyLookUp = s.nextLine();
						System.out.println("");
						contains = BankAccounts.usersJointAcc.containsKey(keyLookUp);
						if (!contains) {
							System.out.println("Sorry that joint account does not exist.");
							System.out.println("Please enter another name.");
							attempts++;
							
							if (attempts > 3) {
								System.out.println("Sorry for the inconvience, but you've reached your"
										+ " limit on account access attempts.");
								System.out.println("Please try again later.");
								System.out.println("");
								//s.close();
								return;
							}
						}
						else {
							jointBalance = BankAccounts.usersJointAcc.get(keyLookUp);
							System.out.println("The current balance in this joint account is"
									+ " $" + jointBalance);
							checkingsBalance = BankAccounts.bankDic.get(newIndex).getBalance();
							System.out.println("The current balance in this checkings account is"
									+ " $" + checkingsBalance);
							System.out.println("");
							
							do {
								System.out.println("Please enter the option which you would like to make.");
								System.out.println("1 - Transfer from Checkings Account to Joint Account");
								System.out.println("2 - Transfer from Joint Account to Checkings Account");
								choice = s.nextInt();
								System.out.println("");
								
								int exit = 0;
								
								if (choice == 1) {
									do {
										System.out.println("Please enter the amount you wish transfer.");
										input = s.nextDouble();
										System.out.println("");
										
										if (input < checkingsBalance){
											System.out.println("Your input of " + input + " has been transfered.");
											
											checkingsBalance = checkingsBalance - input;
											BankAccounts.bankDic.get(newIndex).setBalance(checkingsBalance);
											jointBalance = jointBalance + input;
											BankAccounts.usersJointAcc.replace(keyLookUp, jointBalance);
											
											System.out.println("The current balance in this joint account now is"
													+ " $" + jointBalance);
											System.out.println("The current balance in this checkings account now is"
													+ " $" + checkingsBalance);
											exit = 1;
										}
										else{
											System.out.println("This input of " + input + " exceeds current bounds of logic, "
													+ "please enter a value greater than 0.");
											System.out.println("");
										}	
									} while (exit == 0);
									i = 1;
								}
								else if (choice == 2) {
									do {
										System.out.println("Please enter the amount you wish transfer.");
										input = s.nextDouble();
										System.out.println("");
										
										if (input < jointBalance){
											System.out.println("Your input of " + input + " has been transfered.");
											
											checkingsBalance = checkingsBalance + input;
											BankAccounts.bankDic.get(newIndex).setBalance(checkingsBalance);
											jointBalance = jointBalance - input;
											BankAccounts.usersJointAcc.replace(keyLookUp, jointBalance);
											
											System.out.println("The current balance in this joint account now is"
													+ " $" + jointBalance);
											System.out.println("The current balance in this checkings account now is"
													+ " $" + checkingsBalance);
											exit = 1;
										}
										else{
											System.out.println("This input of " + input + " exceeds current bounds of logic, "
													+ "please enter a value greater than 0.");
											System.out.println("");
										}	
									} while (exit == 0);
									i = 1;
								}
								else 
									System.out.println("That option is invalid");
								
								System.out.println("");
							} while (choice != 1 || choice != 2);
							
						}
					}
				} while (i == 0);
				System.out.println("");
				
			} else if (option == 3) {
				int newIndex;
				int i = 0;
				double savingsBalance_1, savingsBalance_2;
				do {
					String accountChoice;
					for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
						String user = BankAccounts.userDic.get(counter); 
						boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isApproved();
						if (isappr == true) {
							System.out.println(user);
						}
					}
					System.out.println("");
					int j = 0;
					do {
						System.out.println("Please enter the user you wish to transfer with.");
						accountChoice = s.nextLine();
						System.out.println("");
						if (BankAccounts.userDic.contains(accountChoice)) {
							newIndex = BankAccounts.bankIndex.get(accountChoice);
							int size = BankAccounts.bankDic.get(newIndex).getSavingsAcc().size();
							if (size < 2) {
								System.out.println("This account does not have 2 savings account and therefore"
										+ " can't be transfered between.");
								System.out.println("Please enter a different account to transfer between.");
								System.out.println("Or you can type in exit and then enter to leave.");
							}
							else {
								j = 1;
							}
						}
						else if (accountChoice.equals("exit")) {
							//s.close();
							return;
						}
						else {
							System.out.println("Please enter a user account that exist.");
						}
					} while (j == 0);
					
					newIndex = BankAccounts.bankIndex.get(accountChoice);
					System.out.println("This accounts current savings accounts are.");
					System.out.println(BankAccounts.bankDic.get(newIndex).getSavingsAcc());
					
					while(!contains) {
						System.out.println("Please enter the savings account you would like to transfer from.");
						System.out.println("This will be the savings account you are withdrawing from.");
						keyLookUp = s.nextLine();
						System.out.println("");
						contains = BankAccounts.bankDic.get(newIndex).savingsAcc.containsKey(keyLookUp);
						if (!contains) {
							System.out.println("Sorry that savings account does not exist.");
							System.out.println("Please enter another name.");
							attempts++;
							
							if (attempts > 3) {
								System.out.println("Sorry for the inconvience, but you've reached your"
										+ " limit on account access attempts.");
								System.out.println("Please try again later.");
								System.out.println("");
								//s.close();
								return;
							}
						}
						else {
							boolean contains_2 = false;
							String keyLookUp_2;
							while(!contains) {
								System.out.println("Please enter the savings account you would like to transfer to.");
								System.out.println("This will be the savings account you are depositing to.");
								keyLookUp_2 = s.nextLine();
								System.out.println("");
								contains_2 = BankAccounts.bankDic.get(newIndex).savingsAcc.containsKey(keyLookUp_2);
								if (!contains_2) {
									System.out.println("Sorry that savings account does not exist.");
									System.out.println("Please enter another name.");
									attempts++;
									
									if (attempts > 3) {
										System.out.println("Sorry for the inconvience, but you've reached your"
												+ " limit on account access attempts.");
										System.out.println("Please try again later.");
										System.out.println("");
										//s.close();
										return;
									}
								}
								else if (keyLookUp_2.equals(keyLookUp)) {
									System.out.println("The accounts can't be the same account.");
								}
								else {
							
									savingsBalance_1 = BankAccounts.bankDic.get(newIndex).savingsAcc.get(keyLookUp);
									System.out.println("The current balance in the savings account " + keyLookUp
											+ " is $" + savingsBalance_1);
									savingsBalance_2 = BankAccounts.bankDic.get(newIndex).savingsAcc.get(keyLookUp_2);
									System.out.println("The current balance in the savings account " + keyLookUp_2
											+ " is $" + savingsBalance_2);
									System.out.println("");
									
									int exit = 0;
									
									do {
										System.out.println("Please enter the amount you wish transfer.");
										input = s.nextDouble();
										System.out.println("");
										
										if (input < savingsBalance_1){
											System.out.println("Your input of " + input + " has been transfered.");
											
											savingsBalance_1 = savingsBalance_1 - input;
											BankAccounts.bankDic.get(newIndex).savingsAcc.replace(keyLookUp, savingsBalance_1);
											savingsBalance_2 = savingsBalance_2 + input;
											BankAccounts.bankDic.get(newIndex).savingsAcc.replace(keyLookUp_2, savingsBalance_2);
											
											System.out.println("The current balance in the savings account " + keyLookUp
													+ " now is $" + savingsBalance_1);
											System.out.println("The current balance in the savings account " + keyLookUp_2
													+ " now is $" + savingsBalance_2);
											exit = 1;
										}
										else{
											System.out.println("This input of " + input + " exceeds current bounds of logic, "
													+ "please enter a value greater than 0.");
											System.out.println("");
										}	
									} while (exit == 0);
									i = 1;
									System.out.println("");
								}
							}
						}
					}
				} while (i == 0);
				System.out.println("");
				
			} else if (option == 4) {
				int newIndex;
				int i = 0;
				double savingsBalance, jointBalance;
				
				do {
					String accountChoice;
					for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
						String user = BankAccounts.userDic.get(counter); 
						boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isApproved();
						if (isappr == true) {
							System.out.println(user);
						}
					}
					System.out.println("");
					int j = 0;
					do {
						System.out.println("Please enter the user you wish to transfer with.");
						accountChoice = s.nextLine();
						System.out.println("");
						if (BankAccounts.userDic.contains(accountChoice)) {
							newIndex = BankAccounts.bankIndex.get(accountChoice);
							int sizeS = BankAccounts.bankDic.get(newIndex).getSavingsAcc().size();
							int sizeJ = BankAccounts.bankDic.get(newIndex).getJointAccs().size();
							if (sizeS < 1 || sizeJ < 1) {
								System.out.println("This account does not have a savings account or joint"
										+ " and therefore can't be transfered between.");
								System.out.println("Please enter a different account to transfer between.");
								System.out.println("Or you can type in exit and then enter to leave.");
							}
							else {
								j = 1;
							}
						}
						else if (accountChoice.equals("exit")) {
							//s.close();
							return;
						}
						else {
							System.out.println("Please enter a user account that exist.");
						}
					} while (j == 0);
					
					newIndex = BankAccounts.bankIndex.get(accountChoice);
					System.out.println("This accounts current savings accounts are.");
					System.out.println(BankAccounts.bankDic.get(newIndex).getSavingsAcc());
					
					while(!contains) {
						System.out.println("Please enter the savings account you would like to transfer with.");
						keyLookUp = s.nextLine();
						System.out.println("");
						contains = BankAccounts.bankDic.get(newIndex).savingsAcc.containsKey(keyLookUp);
						if (!contains) {
							System.out.println("Sorry that savings account does not exist.");
							System.out.println("Please enter another name.");
							attempts++;
							
							if (attempts > 3) {
								System.out.println("Sorry for the inconvience, but you've reached your"
										+ " limit on account access attempts.");
								System.out.println("Please try again later.");
								System.out.println("");
								//s.close();
								return;
							}
						}
						else {
							boolean contains_2 = false;
							String keyLookUp_2;
							while(!contains) {
								System.out.println("The current joint accounts to this user is.");
								System.out.println(BankAccounts.bankDic.get(newIndex).getJointAccs());
								System.out.println("Please enter the joint account you would like to transfer with.");
								keyLookUp_2 = s.nextLine();
								System.out.println("");
								contains_2 = BankAccounts.usersJointAcc.containsKey(keyLookUp_2);
								if (!contains_2) {
									System.out.println("Sorry that joint account does not exist.");
									System.out.println("Please enter another name.");
									attempts++;
									
									if (attempts > 3) {
										System.out.println("Sorry for the inconvience, but you've reached your"
												+ " limit on account access attempts.");
										System.out.println("Please try again later.");
										System.out.println("");
										//s.close();
										return;
									}
								} else {
							
									savingsBalance = BankAccounts.bankDic.get(newIndex).savingsAcc.get(keyLookUp);
									System.out.println("The current balance in the savings account " + keyLookUp
											+ " is $" + savingsBalance);
									jointBalance = BankAccounts.usersJointAcc.get(keyLookUp_2);
									System.out.println("The current balance in the savings account " + keyLookUp_2
											+ " is $" + jointBalance);
									System.out.println("");
									
									do {
										System.out.println("Please enter the option which you would like to make.");
										System.out.println("1 - Transfer from Savings Account to Joint Account");
										System.out.println("2 - Transfer from Joint Account to Savings Account");
										choice = s.nextInt();
										System.out.println("");
										
										int exit = 0;
										
										if (choice == 1) {
											do {
												System.out.println("Please enter the amount you wish transfer.");
												input = s.nextDouble();
												System.out.println("");
												
												if (input < savingsBalance){
													System.out.println("Your input of " + input + " has been transfered.");
													
													savingsBalance = savingsBalance - input;
													BankAccounts.bankDic.get(newIndex).savingsAcc.replace(keyLookUp, savingsBalance);
													jointBalance = jointBalance + input;
													BankAccounts.usersJointAcc.replace(keyLookUp, jointBalance);
													
													System.out.println("The current balance in this joint account now is"
															+ " $" + jointBalance);
													System.out.println("The current balance in this savings account now is"
															+ " $" + savingsBalance);
													exit = 1;
												}
												else{
													System.out.println("This input of " + input + " exceeds current bounds of logic, "
															+ "please enter a value greater than 0.");
													System.out.println("");
												}	
											} while (exit == 0);
											i = 1;
										}
										else if (choice == 2) {
											do {
												System.out.println("Please enter the amount you wish transfer.");
												input = s.nextDouble();
												System.out.println("");
												
												if (input < jointBalance){
													System.out.println("Your input of " + input + " has been transfered.");
													
													savingsBalance = savingsBalance + input;
													BankAccounts.bankDic.get(newIndex).savingsAcc.replace(keyLookUp, savingsBalance);
													jointBalance = jointBalance - input;
													BankAccounts.usersJointAcc.replace(keyLookUp, jointBalance);
													
													System.out.println("The current balance in this joint account now is"
															+ " $" + jointBalance);
													System.out.println("The current balance in this savings account now is"
															+ " $" + savingsBalance);
													exit = 1;
												}
												else{
													System.out.println("This input of " + input + " exceeds current bounds of logic, "
															+ "please enter a value greater than 0.");
													System.out.println("");
												}	
											} while (exit == 0);
											i = 1;
										}
										else 
											System.out.println("That option is invalid");
										
										System.out.println("");
									} while (choice != 1 || choice != 2);
								}
							}
						}
					}
				} while (i == 0);
				System.out.println("");
				
			} else if (option == 5) {
				int newIndex;
				int i = 0;
				double jointBalance_1, jointBalance_2;
				do {
					
					String accountChoice;
					for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
						String user = BankAccounts.userDic.get(counter); 
						boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isApproved();
						if (isappr == true) {
							System.out.println(user);
						}
					}
					System.out.println("");
					int j = 0;
					do {
						System.out.println("Please enter the user you wish to transfer with.");
						accountChoice = s.nextLine();
						System.out.println("");
						if (BankAccounts.userDic.contains(accountChoice)) {
							newIndex = BankAccounts.bankIndex.get(accountChoice);
							int sizeJ = BankAccounts.bankDic.get(newIndex).getJointAccs().size();
							if (sizeJ < 2) {
								System.out.println("This account does not have a 2 joint accounts to it"
										+ " and therefore can't be transfered between.");
								System.out.println("Please enter a different account to transfer between.");
								System.out.println("Or you can type in exit and then enter to leave.");
							}
							else {
								j = 1;
							}
						}
						else if (accountChoice.equals("exit")) {
							//s.close();
							return;
						}
						else {
							System.out.println("Please enter a user account that exist.");
						}
					} while (j == 0);
					
					newIndex = BankAccounts.bankIndex.get(accountChoice);
					
					
					
					System.out.println("Your current joint accounts are.");
					System.out.println(BankAccounts.bankDic.get(newIndex).getJointAccs());
					
					while(!contains) {
						System.out.println("Please enter the joint account you would like to transfer from.");
						System.out.println("This will be the joint account you are withdrawing from.");
						keyLookUp = s.nextLine();
						System.out.println("");
						contains = BankAccounts.usersJointAcc.containsKey(keyLookUp);
						if (!contains) {
							System.out.println("Sorry that joint account does not exist.");
							System.out.println("Please enter another name.");
							attempts++;
							
							if (attempts > 3) {
								System.out.println("Sorry for the inconvience, but you've reached your"
										+ " limit on account access attempts.");
								System.out.println("Please try again later.");
								System.out.println("");
								//s.close();
								return;
							}
						}
						else {
							boolean contains_2 = false;
							String keyLookUp_2;
							while(!contains) {
								System.out.println("Please enter the joint account you would like to transfer to.");
								System.out.println("This will be the joint account you are depositing to.");
								keyLookUp_2 = s.nextLine();
								System.out.println("");
								contains_2 = BankAccounts.usersJointAcc.containsKey(keyLookUp_2);
								if (!contains_2) {
									System.out.println("Sorry that joint account does not exist.");
									System.out.println("Please enter another name.");
									attempts++;
									
									if (attempts > 3) {
										System.out.println("Sorry for the inconvience, but you've reached your"
												+ " limit on account access attempts.");
										System.out.println("Please try again later.");
										System.out.println("");
										//s.close();
										return;
									}
								}
								else if (keyLookUp_2.equals(keyLookUp)) {
									System.out.println("The accounts can't be the same account.");
								}
								else {
									jointBalance_1 = BankAccounts.usersJointAcc.get(keyLookUp);
									System.out.println("The current balance in the joint account " + keyLookUp
											+ " is $" + jointBalance_1);
									jointBalance_2 = BankAccounts.usersJointAcc.get(keyLookUp_2);
									System.out.println("The current balance in the joint account " + keyLookUp_2
											+ " is $" + jointBalance_2);
									System.out.println("");
									
									int exit = 0;
									
									do {
										System.out.println("Please enter the amount you wish transfer.");
										input = s.nextDouble();
										System.out.println("");
										
										if (input < jointBalance_1){
											System.out.println("Your input of " + input + " has been transfered.");
											
											jointBalance_1 = jointBalance_1 - input;
											BankAccounts.usersJointAcc.replace(keyLookUp, jointBalance_1);
											jointBalance_2 = jointBalance_2 + input;
											BankAccounts.bankDic.get(indexNum).savingsAcc.replace(keyLookUp_2, jointBalance_2);
											
											System.out.println("The current balance in your joint account " + keyLookUp
													+ " now is $" + jointBalance_1);
											System.out.println("The current balance in your joint account " + keyLookUp_2
													+ " now is $" + jointBalance_2);
											exit = 1;
										}
										else{
											System.out.println("This input of " + input + " exceeds current bounds of logic, "
													+ "please enter a value greater than 0.");
											System.out.println("");
										}	
									} while (exit == 0);
									i = 1;
									System.out.println("");
								}
							}
						}
					}
				} while (i == 0);
				System.out.println("");
				
			} else if (option == 6) {
				int newIndex_1, newIndex_2;
				int i = 0;
				double checkingsBalance_1, checkingsBalance_2;
				String accountChoice_2;
				do {
					
					String accountChoice;
					for (int counter = 0; counter < BankAccounts.userDic.size(); counter++) {
						String user = BankAccounts.userDic.get(counter); 
						boolean isappr = BankAccounts.bankDic.get(BankAccounts.bankIndex.get(user)).isApproved();
						if (isappr == true) {
							System.out.println(user);
						}
					}
					System.out.println("");
					int j = 0;
					do {
						System.out.println("Please enter the checkings account you wish to transfer from.");
						System.out.println("Or you can type in exit and then enter to leave.");
						accountChoice = s.nextLine();
						System.out.println("");
						if (BankAccounts.userDic.contains(accountChoice)) {
							j = 1;
						}
						else if (accountChoice.equals("exit")) {
							//s.close();
							return;
						}
						else {
							System.out.println("Please enter a checkings account that exist.");
						}
					} while (j == 0);
					
					newIndex_1 = BankAccounts.bankIndex.get(accountChoice);
					System.out.println("");
					int k = 0;
					
					do {
						System.out.println("Please enter the checkings account you wish to transfer to.");
						System.out.println("Or you can type in exit and then enter to leave.");
						accountChoice_2 = s.nextLine();
						System.out.println("");
						if (BankAccounts.userDic.contains(accountChoice_2)) {
							k = 1;
						}
						else if (accountChoice_2.equals("exit")) {
							//s.close();
							return;
						}
						else {
							System.out.println("Please enter a checkings account that exist.");
						}
					} while (k == 0);
					
					newIndex_2 = BankAccounts.bankIndex.get(accountChoice_2);
					System.out.println("");
					
					
					checkingsBalance_1 = BankAccounts.bankDic.get(newIndex_1).getBalance();
					System.out.println("The current balance in the first checkings account is"
							+ " $" + checkingsBalance_1);
					checkingsBalance_2 = BankAccounts.bankDic.get(newIndex_2).getBalance();
					System.out.println("The current balance in the second checkings account is"
							+ " $" + checkingsBalance_2);
					System.out.println("");
					
					int exit = 0;
					
					do {
						System.out.println("Please enter the amount you wish transfer.");
						input = s.nextDouble();
						System.out.println("");
						
						if (input < checkingsBalance_1){
							System.out.println("Your input of " + input + " has been transfered.");
							
							checkingsBalance_1 = checkingsBalance_1 - input;
							BankAccounts.bankDic.get(newIndex_1).setBalance(checkingsBalance_1);
							checkingsBalance_2 = checkingsBalance_2 + input;
							BankAccounts.bankDic.get(newIndex_2).setBalance(checkingsBalance_2);;
							
							System.out.println("The current balance in the savings account " + accountChoice
									+ " now is $" + checkingsBalance_1);
							System.out.println("The current balance in the checkings account " + accountChoice_2
									+ " now is $" + checkingsBalance_2);
							exit = 1;
						}
						else{
							System.out.println("This input of " + input + " exceeds current bounds of logic, "
									+ "please enter a value greater than 0.");
							System.out.println("");
						}	
					} while (exit == 0);
					i = 1;
					System.out.println("");	
					
				} while (i == 0);
				System.out.println("");
			} else if (option == 7) {
				System.out.println("Thank you, you now will be returned to the Customer menu.");
				System.out.println("");
			} else {
				System.out.println("That value is invalid please input one of the given options.");
				System.out.println("");
			}
			
		} while (option != 7);
		//s.close();
		
	}

	@Override
	public void viewMenu(int indexNum) {
		int choice;
		boolean approvedOrNot = BankAccounts.bankDic.get(indexNum).isApproved();
		
		if (approvedOrNot == true) {
			System.out.println("Welcome to Revature Bank!");
		} else {
			System.out.println("Sorry for the inconveince, it seems your account isn't approved.");
			System.out.println("");
			//s.close(); 
			return;
		}
		
		do {
			System.out.println("Please choose from one of the options");
			System.out.println("1 - Check Current Accounts Information.");
			System.out.println("2 - Approve/Cancel Users Accounts");
			System.out.println("3 - Withdraw From Current Accounts.");
			System.out.println("4 - Deposit to Current Accounts");
			System.out.println("5 - Transfer Between Current Accounts");
			System.out.println("6 - Log out");
			choice = s.nextInt();
			System.out.println("");
			
			if (choice == 1) 
				usersInfo(indexNum);
			else if (choice == 2)
				approval();
			else if (choice == 3)
				withdraw(indexNum);
			else if (choice == 4) 
				deposit(indexNum);
			else if (choice == 5)
				transfer(indexNum);
			else if (choice == 6)
				System.out.println("Thank you for working with RV Bank");
			else {
				System.out.println("That's an invalid option.");
				System.out.println("");
			}
		} while (choice != 6);
		
		//s.close(); 
	}

	public void apply() {		
		System.out.println("Please enter your first name.");
		String first = s.nextLine();
		setFirstN(first);
		
		System.out.println("Please enter your last name!");
		String last = s.nextLine();
		setLastN(last);
		
		String username;
		boolean userNameFree = true;
		while(userNameFree) {
			System.out.println("Please enter a username!");
			username = s.nextLine();
			userNameFree = createUserName(username);
			if(userNameFree == true) {
				BankAccounts.adminDic.add(username);
				setAccnName(username);
			}
		}
		
		String password;
		int c = 0;
		do {
			// loop if No is selected
			// also if the incorrect option is chosen
			System.out.println("Please enter a password!");
			password = s.nextLine();
			System.out.println("Are you sure you want, " + password + " to be your password?");
			System.out.println("1 - Yes");
			System.out.println("2 - No");
			int choice = s.nextInt();
			if (choice == 1) {
				setAccnPswd(password);
				c = 1;
			}
		} while (c == 0);
		
		System.out.println("Your checkings account has been created!");
		System.out.println("You will need to wait for our systems to proccess your account.");
		System.out.println("Until then you'll have to wait to access our banking system, "
				+ "so please return later.");
		System.out.println("Thank you for choosing Revature Bank and have a wonderful day.");
		BankAccounts.userToPswd.put(getAccnName(), getAccnPswd());
		BankAccounts.bankIndex.put(getAccnName(), getUserINDEX());
		//s.close();
		
	}
	
	@Override
	public void signIn(String username, String password) {
		int userIndex = 0;
		//choice = s.nextLine();
		
		String checkPswd, checkUsername;
		checkUsername = username;
		boolean doHaveKey = false;
		
		do {
			doHaveKey = BankAccounts.adminDic.contains(checkUsername);
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
				System.out.println("If you wish not to login enter 'exit' to leave.");
				checkUsername = s.nextLine();
				if (checkUsername.equals("exit")) {
					System.out.println("Thank you, you'll return to the login page now.");
					return;
				}
			}
		} while(!doHaveKey);
		
		//s.close();
	}
	
}
