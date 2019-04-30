package com.revature;

import java.util.Scanner;

public class CustomerAccount extends BankAccount {

	Scanner s = new Scanner(System.in);
	
	public CustomerAccount() {
		super();
		this.userID = 0;
	}
	
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
						exit = 1;
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
							////s.close();
							return;
						}
					}
				}
				
				curentBalance = BankAccounts.bankDic.get(indexNum).savingsAcc.get(keyLookUp);
				int exit = 0;
				do {
					System.out.println("Please enter your withdraw amount.");
					input = s.nextDouble();
					System.out.println("");
					
					if(input < curentBalance && input >= 0) {
						System.out.println("Your input of " + input + " has been withdrawn.");
						curentBalance = curentBalance - input;
						BankAccounts.bankDic.get(indexNum).setBalance(curentBalance);
						System.out.println("Your current balance is now $" + curentBalance + ".");
						BankAccounts.bankDic.get(indexNum).savingsAcc.replace(keyLookUp, curentBalance);
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
							////s.close();
							return;
						}
					}
				}
				
				curentBalance = BankAccounts.usersJointAcc.get(keyLookUp);
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
				
			} else {
				System.out.println("That value is invalid please input one of the given options.");
				System.out.println("");
			}
			
		} while (option != 4);
		////s.close();
	}
	
	public void deposit(int indexNum) {
		double curentBalance;
		double input;
		int attempts = 0;
		int option;
		String keyLookUp;
		boolean contains;
		
		do {
			contains = false;
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
				System.out.println("Your current savings accounts are.");
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
							////s.close();
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
						BankAccounts.bankDic.get(indexNum).savingsAcc.replace(keyLookUp, curentBalance);
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
							////s.close();
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
						BankAccounts.usersJointAcc.replace(keyLookUp, curentBalance);
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
		////s.close();
	}
	
	public void transfer(int indexNum) {
		double input;
		int attempts = 0;
		int option, choice;
		String keyLookUp;
		boolean contains;
		
		do {
			contains = false;
			System.out.println("Please enter the option which you would like to make.");
			System.out.println("1 - Transfer between Checkings Account and Savings Account");
			System.out.println("2 - Transfer between Checkings Account and Joint Account");
			System.out.println("3 - Transfer between Savings Account and Savings Account");
			System.out.println("4 - Transfer between Savings Account and Joint Account");
			System.out.println("5 - Transfer between Joint Account and Joint Account");
			System.out.println("6 - Logout");
			option = s.nextInt();
			System.out.println("");
			
			if (option == 1) {
				
				int i = 0;
				double checkingsBalance, savingsBalance;
				do {
					System.out.println("Your current savings accounts are.");
					System.out.println(BankAccounts.bankDic.get(indexNum).getSavingsAcc());
					
					while(!contains) {
						System.out.println("Please enter the savings account you would like to trasnfer with.");
						keyLookUp = s.nextLine();
						System.out.println("");
						contains = BankAccounts.bankDic.get(indexNum).savingsAcc.containsKey(keyLookUp);
						if (!contains) {
							System.out.println("Sorry that savings account does not exist.");
							System.out.println("Please enter another name.");
							attempts++;
							
							if (attempts > 3) {
								System.out.println("Sorry for the inconvience, but you've reached your"
										+ " limit on account access attempts.");
								System.out.println("Please try again later.");
								System.out.println("");
								////s.close();
								return;
							}
						}
						else {
							savingsBalance = BankAccounts.bankDic.get(indexNum).savingsAcc.get(keyLookUp);
							System.out.println("The current balance in your savings account is"
									+ " $" + savingsBalance);
							checkingsBalance = BankAccounts.bankDic.get(indexNum).getBalance();
							System.out.println("The current balance in your checkings account is"
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
											BankAccounts.bankDic.get(indexNum).setBalance(checkingsBalance);
											savingsBalance = savingsBalance + input;
											BankAccounts.bankDic.get(indexNum).savingsAcc.replace(keyLookUp, savingsBalance);
											
											System.out.println("The current balance in your savings account now is"
													+ " $" + savingsBalance);
											System.out.println("The current balance in your checkings account now is"
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
											
											System.out.println("The current balance in your savings account now is"
													+ " $" + savingsBalance);
											System.out.println("The current balance in your checkings account now is"
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
				
				int i = 0;
				double checkingsBalance, jointBalance;
				do {
					System.out.println("Your current joint accounts are.");
					System.out.println(BankAccounts.bankDic.get(indexNum).getJointAccs());
					
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
								////s.close();
								return;
							}
						}
						else {
							jointBalance = BankAccounts.usersJointAcc.get(keyLookUp);
							System.out.println("The current balance in your joint account is"
									+ " $" + jointBalance);
							checkingsBalance = BankAccounts.bankDic.get(indexNum).getBalance();
							System.out.println("The current balance in your checkings account is"
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
											BankAccounts.bankDic.get(indexNum).setBalance(checkingsBalance);
											jointBalance = jointBalance + input;
											BankAccounts.usersJointAcc.replace(keyLookUp, jointBalance);
											
											System.out.println("The current balance in your joint account now is"
													+ " $" + jointBalance);
											System.out.println("The current balance in your checkings account now is"
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
											BankAccounts.bankDic.get(indexNum).setBalance(checkingsBalance);
											jointBalance = jointBalance - input;
											BankAccounts.usersJointAcc.replace(keyLookUp, jointBalance);
											
											System.out.println("The current balance in your joint account now is"
													+ " $" + jointBalance);
											System.out.println("The current balance in your checkings account now is"
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
				
				int i = 0;
				double savingsBalance_1, savingsBalance_2;
				do {
					System.out.println("Your current savings accounts are.");
					System.out.println(BankAccounts.bankDic.get(indexNum).getSavingsAcc());
					
					while(!contains) {
						System.out.println("Please enter the savings account you would like to transfer from.");
						System.out.println("This will be the savings account you are withdrawing from.");
						keyLookUp = s.nextLine();
						System.out.println("");
						contains = BankAccounts.bankDic.get(indexNum).savingsAcc.containsKey(keyLookUp);
						if (!contains) {
							System.out.println("Sorry that savings account does not exist.");
							System.out.println("Please enter another name.");
							attempts++;
							
							if (attempts > 3) {
								System.out.println("Sorry for the inconvience, but you've reached your"
										+ " limit on account access attempts.");
								System.out.println("Please try again later.");
								System.out.println("");
								////s.close();
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
								contains_2 = BankAccounts.bankDic.get(indexNum).savingsAcc.containsKey(keyLookUp_2);
								if (!contains_2) {
									System.out.println("Sorry that savings account does not exist.");
									System.out.println("Please enter another name.");
									attempts++;
									
									if (attempts > 3) {
										System.out.println("Sorry for the inconvience, but you've reached your"
												+ " limit on account access attempts.");
										System.out.println("Please try again later.");
										System.out.println("");
										////s.close();
										return;
									}
								}
								else if (keyLookUp_2.equals(keyLookUp)) {
									System.out.println("The accounts can't be the same account.");
								}
								else {
							
									savingsBalance_1 = BankAccounts.bankDic.get(indexNum).savingsAcc.get(keyLookUp);
									System.out.println("The current balance in the savings account " + keyLookUp
											+ " is $" + savingsBalance_1);
									savingsBalance_2 = BankAccounts.bankDic.get(indexNum).savingsAcc.get(keyLookUp_2);
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
											BankAccounts.bankDic.get(indexNum).savingsAcc.replace(keyLookUp, savingsBalance_1);
											savingsBalance_2 = savingsBalance_2 + input;
											BankAccounts.bankDic.get(indexNum).savingsAcc.replace(keyLookUp_2, savingsBalance_2);
											
											System.out.println("The current balance in your savings account " + keyLookUp
													+ "now is $" + savingsBalance_1);
											System.out.println("The current balance in your savings account " + keyLookUp_2
													+ "now is $" + savingsBalance_2);
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
				
				int i = 0;
				double savingsBalance, jointBalance;
				do {
					System.out.println("Your current savings accounts are.");
					System.out.println(BankAccounts.bankDic.get(indexNum).getSavingsAcc());
					
					while(!contains) {
						System.out.println("Please enter the savings account you would like to transfer with.");
						keyLookUp = s.nextLine();
						System.out.println("");
						contains = BankAccounts.bankDic.get(indexNum).savingsAcc.containsKey(keyLookUp);
						if (!contains) {
							System.out.println("Sorry that savings account does not exist.");
							System.out.println("Please enter another name.");
							attempts++;
							
							if (attempts > 3) {
								System.out.println("Sorry for the inconvience, but you've reached your"
										+ " limit on account access attempts.");
								System.out.println("Please try again later.");
								System.out.println("");
								////s.close();
								return;
							}
						}
						else {
							boolean contains_2 = false;
							String keyLookUp_2;
							while(!contains) {
								System.out.println("Your current joint accounts are.");
								System.out.println(BankAccounts.bankDic.get(indexNum).getJointAccs());
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
										////s.close();
										return;
									}
								} else {
							
									savingsBalance = BankAccounts.bankDic.get(indexNum).savingsAcc.get(keyLookUp);
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
													BankAccounts.bankDic.get(indexNum).savingsAcc.replace(keyLookUp, savingsBalance);
													jointBalance = jointBalance + input;
													BankAccounts.usersJointAcc.replace(keyLookUp, jointBalance);
													
													System.out.println("The current balance in your joint account now is"
															+ " $" + jointBalance);
													System.out.println("The current balance in your savings account now is"
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
													BankAccounts.bankDic.get(indexNum).savingsAcc.replace(keyLookUp, savingsBalance);
													jointBalance = jointBalance - input;
													BankAccounts.usersJointAcc.replace(keyLookUp, jointBalance);
													
													System.out.println("The current balance in your joint account now is"
															+ " $" + jointBalance);
													System.out.println("The current balance in your savings account now is"
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
				
				int i = 0;
				double jointBalance_1, jointBalance_2;
				do {
					System.out.println("Your current joint accounts are.");
					System.out.println(BankAccounts.bankDic.get(indexNum).getJointAccs());
					
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
								////s.close();
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
										////s.close();
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
													+ "now is $" + jointBalance_1);
											System.out.println("The current balance in your joint account " + keyLookUp_2
													+ "now is $" + jointBalance_2);
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
				System.out.println("Thank you, you now will be returned to the Customer menu.");
				System.out.println("");
			} else {
				System.out.println("That value is invalid please input one of the given options.");
				System.out.println("");
			}
			
		} while (option != 6);
		////s.close();
	}
	
	public void savingsAccount(int indexNum) {
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
			else if(newSavAccn.equals("exit")) {
				System.out.println("This is not a valid entry");
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
		
		////s.close();
	}
	
	public void jointAccount(int indexNum) {
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
			else if(newJoiAccn.equals("exit")) {
				System.out.println("This is not a valid entry");
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
		
		////s.close();
	}
	
	@Override
	public void usersInfo(int indexNum) {
		
		System.out.println(BankAccounts.bankDic.get(indexNum).toString());
	}
	
	@Override
	public void viewMenu(int indexNum) {
		
		int choice;
		double curentBalance;
		boolean approvedOrNot = BankAccounts.bankDic.get(indexNum).isApproved();
		
		if (approvedOrNot == true) {
			System.out.println("Welcome to Revature Bank!");
		} else {
			System.out.println("Sorry for the inconveince, it seems your account isn't approved.");
			//s.close(); 
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
			System.out.println("7 - Transfer Funds");
			System.out.println("8 - Log out");
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
				transfer(indexNum);
			else if (choice == 8)
				System.out.println("Thank you for choosing RV Bank");
			else {
				System.out.println("That's an invalid option.");
				System.out.println("");
			}
		
		} while (choice != 8);
		
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
				BankAccounts.customerDic.add(username);
				setAccnName(username);
			}
		}
		
		int choice = 0;
		String password;
		do {
			// loop if No is selected
			// also if the incorrect option is chosen
			System.out.println("Please enter a password!");
			password = s.nextLine();
			System.out.println("Are you sure you want, " + password + " to be your password?");
			System.out.println("1 - Yes");
			System.out.println("2 - No");
			
			choice = Integer.parseInt(s.nextLine());
			
			if (choice == 1) 
				setAccnPswd(password);
		} while (choice != 1);
		System.out.println("");
		System.out.println("Your checkings account has been created!");
		System.out.println("You will need to wait for our systems to proccess your account.");
		System.out.println("Until then you'll have to wait to access our banking system, "
				+ "so please return later.");
		System.out.println("Thank you for choosing Revature Bank and have a wonderful day.");
		BankAccounts.userToPswd.put(getAccnName(), getAccnPswd());
		BankAccounts.bankIndex.put(getAccnName(), getUserINDEX());
		////s.close();
	}
	
	@Override
	public void signIn(String username, String password) {
		int userIndex = 0;
		//choice = s.nextLine();
		
		String checkPswd, checkUsername;
		checkUsername = username;
		boolean doHaveKey = false;
		do {
			doHaveKey = BankAccounts.customerDic.contains(checkUsername);
			if (doHaveKey == true) {
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
	
	@Override
	public void approval() {
		System.out.println("Customer does not have access to this method.");
	}
}
