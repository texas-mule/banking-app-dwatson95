package com.revature;

import java.util.Scanner;

public class Bank {
	
	public static BankAccount customer;// = new CustomerAccount ();
	public static BankAccount employee;// = new EmployeeAccount ();
	public static BankAccount admin;// = new BankAdminAccount ();
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int option;
		int o = 0;
		admin = new BankAdminAccount();
		admin.setApproved(true);
		admin.setAccnName("admin");
		admin.setAccnPswd("password");
		admin.setFirstN("Admin");
		admin.setLastN("RV");
		
		BankAccounts.userToPswd.put(admin.getAccnName(), admin.getAccnPswd());
		BankAccounts.bankIndex.put(admin.getAccnName(), admin.getUserINDEX());
		BankAccounts.userDic.add(admin.getAccnName());
		BankAccounts.adminDic.add(admin.getAccnName());
		BankAccounts.bankDic.add(admin);
		
		do {
			System.out.println("Welcome to RV Bank.");
			homePage();
			System.out.println("");
			do {
				System.out.println("You are about to leave RV Bank are you sure you want to do that.");
				System.out.println("1 - Yes");
				System.out.println("2 - No");
				option = s.nextInt();
				if (option == 1) {
					System.out.println("See you next time.");
					o = 1;
				}
				else if (option == 2) {
					System.out.println("Okay, let's continue.");
					o = 1;
				}
				else
					System.out.println("That's an invalid option");
			} while(o == 0);
			
		} while(option != 1);
		s.close();
	}

	public static void homePage() {
		Scanner s = new Scanner(System.in);
		int o = 0;
		do {
			System.out.println("Please select from the options below to continue.");
			System.out.println("1 - Login");
			System.out.println("2 - Sign-Up");
			System.out.println("3 - Leave");
			int option = Integer.parseInt(s.nextLine());
			
			if (option == 1)
				loginPortal();
			else if (option == 2)
				option2();
			else if (option == 3) {
				System.out.println("You are leaving RV Bank.");
				o = 1;
			}
			else
				System.out.println("Please choose one of the given options.");

		} while (o == 0);
		
		//s.close();
	}
	
	public static void option2() {
		Scanner s = new Scanner(System.in);
		int o = 0;
		
		System.out.println("Welcome to the sign-up page.");
		// loop in case they choose an option number not available
		do {		
			System.out.println("Please select from the options below to continue.");
			System.out.println("1 - Customer Sign-Up");
			System.out.println("2 - Employee Sign-Up");
			System.out.println("3 - Exit to Home");
			
			int option = Integer.parseInt(s.next());
			/*
			if(s.hasNextInt()) 
			{
				option = s.nextInt();
				 
			}*/
						
			if (option == 1) {
				custSU();
				////s.close();
				return;
			}
			else if (option == 2) {
				empSU();
				////s.close();
				return;
			}
			else if (option == 3) {
				System.out.println("Exiting to Home");
				o = 1;
			}
			else 
				System.out.println("That is an invalid option.");

		} while (o == 0);
		System.out.println("");
		////s.close();
	}
	
	public static void loginPortal() {
		Scanner s = new Scanner(System.in);
		int o = 0;
		
		// loop of some sort to make sure the option to leave is there
		// loop in case the incorrect option is chosen
		System.out.println("Welcome to the login page.");
		do {
			System.out.println("Please select from the options below to continue.");
			System.out.println("1 - Customer Login");
			System.out.println("2 - Employee Login");
			System.out.println("3 - Bank Admin Login");
			System.out.println("4 - Exit to Home");
			int option = Integer.parseInt(s.nextLine());
			
			if (option == 1 ){
				boolean empty = BankAccounts.customerDic.isEmpty();
				if (empty) {
					System.out.println("There are currently no customer accounts created.");
					return;
				}
				System.out.println("Please enter your account username.");
				String username = s.next();
			
				System.out.println("Please enter your account password.");
				String password = s.next();
				
				customer.signIn(username, password);
			}	
			else if (option == 2){
				boolean empty = BankAccounts.employeeDic.isEmpty();
				if (empty) {
					System.out.println("There are currently no customer accounts created.");
					return;
				}

				System.out.println("Please enter your account username.");
				String username = s.next();
			
				System.out.println("Please enter your account password.");
				String password = s.next();
				
				employee.signIn(username, password);
			}
			else if (option == 3){
				System.out.println("Please enter your account username.");
				String username = s.next();
			
				System.out.println("Please enter your account password.");
				String password = s.next();
				
				admin.signIn(username, password);
			}
			else if (option == 4) {
				o = 1;
			}
			else {
				System.out.println("That option is invalid.");
			}

		} while (o == 0);
					
		
		////s.close();
	}
	
	public static void custSU() {
				
		System.out.println("Welcome new potential customer!");
		System.out.println("Before you become one of our clients there's first a few"
				+ " things that need to be done");
		
		customer = new CustomerAccount ();
		customer.apply();
		
		BankAccounts.bankDic.add(customer);
		
		System.out.println("Thank you for your time and patience an agent will review your case.");
		System.out.println("You will be able to access your new account after it has been approved.");
		System.out.println("");

		// end and goes to front
	}
	
	public static void empSU() {
		Scanner s = new Scanner(System.in);
		int option, o;
		o = 0;
		System.out.println("Welcome new employee!");
		System.out.println("Before you become one of our new employee there's first a few"
				+ " things that need to be done");
		do {
			System.out.println("Please select from the options below to continue.");
			System.out.println("1 - Employee Sign-Up");
			System.out.println("2 - Admin Sign-Up");
			option = s.nextInt();
			
			if (option == 1) {
				employee = new EmployeeAccount ();
				employee.apply();
				BankAccounts.bankDic.add(employee);
				o = 1;
			}
			else if (option == 2) {
				admin = new BankAdminAccount ();
				admin.apply();
				BankAccounts.bankDic.add(admin);
				o = 1;
			}
			else
				System.out.println("Please choose one of the given options.");
			
		} while(o == 0);
		System.out.println("Thank you for your time and patience an agent will review your case.");
		System.out.println("You will be able to access your new account after it has been approved.");
		// end and goes to front
		//s.close();
	}
	
}