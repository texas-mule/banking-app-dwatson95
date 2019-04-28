package com.revature;

import java.util.Scanner;

public class Bank {
	
	static BankAccount person;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int option;
		
		do {
			System.out.println("Welcome to RV Bank.");
			homePage();
			do {
				System.out.println("You are about to leave RV Bank are you sure you want to do that.");
				System.out.println("1 - Yes");
				System.out.println("2 - No");
				option = s.nextInt();
				if (option != 1 || option != 2)
					System.out.println("Please choose one of the given options.");
			} while(option != 1 || option !=2);
			
		} while(option != 2);
		s.close();
		//maybe while loop to make sure they really want to leave
	}
	
	public static void homePage() {
		Scanner s = new Scanner(System.in);
		int option;
		do {
			System.out.println("Please select from the options below to continue.");
			System.out.println("1 - Login");
			System.out.println("2 - Sign-Up");
			System.out.println("3 - Leave");
			System.out.println("");
			
			option = s.nextInt();
			
			if (option == 1)
				loginPortal();
			else if (option == 2)
				option2();
			
			if (option != 1 || option != 2 || option != 3)
				System.out.println("Please choose one of the given options.");

		} while (option != 3);
		
		s.close();
	}
	
	public static void option2() {
		Scanner s = new Scanner(System.in);
		int option;
		
		System.out.println("Welcome to the sign-up page.");
		// loop in case they choose an option number not available
		do {		
			System.out.println("Please select from the options below to continue.");
			System.out.println("1 - Customer Sign-Up");
			System.out.println("2 - Employee Sign-Up");
			System.out.println("3 - Exit to Home");
	
			option = s.nextInt();
			if (option != 1 || option != 2 || option !=3)
				System.out.println("That option is invalid.");
			if (option == 1)
				custSU();

		} while (option != 3);
	}
	
	public static void loginPortal() {
		Scanner s = new Scanner(System.in);
		int option;
		
		// loop of some sort to make sure the option to leave is there
		// loop in case the incorrect option is chosen
		System.out.println("Welcome to the login page.");
		do {
			System.out.println("Please select from the options below to continue.");
			System.out.println("1 - Login");
			System.out.println("2 - Exit to Home");
	
			option = s.nextInt();
			
			if (option != 1 || option != 2)
				System.out.println("That option is invalid.");
			else if (option == 2)
				return;

		} while (option != 1);
					
		System.out.println("Please enter your account username.");
		String username = s.next();
	
		System.out.println("Please enter your account password.");
		String password = s.nextLine();
		System.out.println("Thank you.");
		
		person.signIn(username, password);
		s.close();
	}
	
	public static void custSU() {
		
		BankAccount newCustomer = new CustomerAccount();
		
		System.out.println("Welcome new potential customer!");
		System.out.println("Before you become one of our clients there's first a few"
				+ " things that need to be done");
		
		newCustomer.apply();
		
		BankAccounts.bankDic.add(newCustomer);
		
		System.out.println("Thank you for your time and patients an agent will review your case.");
		System.out.println("Then you'll be able to access your new account.");

		// end and goes to front
	}
	
	public static void empSU(int type) {
		Scanner s = new Scanner(System.in);
		int option;
		
		System.out.println("Welcome new employee!");
		System.out.println("Before you become one of our new employee there's first a few"
				+ " things that need to be done");
		do {
			System.out.println("Please select from the options below to continue.");
			System.out.println("1 - Employee Sign-Up");
			System.out.println("2 - Admin Sign-Up");
			option = s.nextInt();
			
			if (option == 1) {
				BankAccount newEmployee = new EmployeeAccount();
				newEmployee.apply();
				BankAccounts.bankDic.add(newEmployee);
			}
			else if (option == 2) {
				BankAccount newAdmin = new BankAdminAccount();
				newAdmin.apply();
				BankAccounts.bankDic.add(newAdmin);
			}
			else
				System.out.println("Please choose one of the given options.");
			
			
		} while(option != 1 || option != 2);
		System.out.println("Thank you for your time and patients an agent will review your case.");
		System.out.println("Then you'll be able to access your new account.");
		// end and goes to front
		s.close();
	}
	
}