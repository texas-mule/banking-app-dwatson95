package com.revature;

import java.util.Scanner;

public class Bank {
	
	static BankAccount person;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to RV Bank.");
		homePage();
		
		//maybe while loop to make sure they really want to leave
	}
	
	public static void homePage() {
		Scanner s = new Scanner(System.in);
		int option;
		int i = 0;
		do {
			if (i > 0)
				System.out.println("That option is invalid.");
			
			System.out.println("Please select from the options below to continue.");
			System.out.println("1 - Customer Login");
			System.out.println("2 - Employee Login");
			System.out.println("3 - Bank Admin Login");
			System.out.println("4 - Sign-Up");
			System.out.println("5 - Leave");
			
			option = s.nextInt();
			
			if (i == 1)
				option1();
			else if (i == 2)
				option2();
			else if (i == 3)
				option3();
			else if (i == 4)
				option4();
			
			if (i != 1 || i != 2 || i != 3 || i != 4 || i != 5)
				System.out.println("Please choose one of the given options.");
			i++;
		} while (option != 5);
		
		s.close();
	}
	
	public static void option1() {
		loginNP();
	}
	
	public static void option2() {
		int type = 0;
		loginNP();
		loginEA(type);
	}
	
	public static void option3() {
		int type = 1;
		loginNP();
		loginEA(type);
	}
	
	public static void option4() {
		Scanner s = new Scanner(System.in);
		int option;
		int i = 0;
		
		System.out.println("Welcome to the sign-up page.");
		// loop in case they choose an option number not available
		do {
			if (i > 0)
				System.out.println("That option is invalid.");
			
			System.out.println("Please select from the options below to continue.");
			System.out.println("1 - Customer Sign-Up");
			System.out.println("2 - Employee Sign-Up");
			System.out.println("3 - Exit to Home");
	
			option = s.nextInt();
			i++;
		} while (option > 0 && option < 4);
	}
	
	public static void loginNP() {
		Scanner s = new Scanner(System.in);
		int option;
		int i = 0;
		
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
			else if (option == 1)
				i = 1;
			else if (option == 2)
				return;

		} while (i != 1);
					
		System.out.println("Please enter your account username.");
		String username = s.next();
	
		System.out.println("Please enter your account password.");
		String password = s.nextLine();
		System.out.println("Thank you.");
		
		person.signIn(username, password);
	}
	
	public static void loginEA(int type) {
		Scanner s = new Scanner(System.in);
		int option;
		int i = 0;
		// loop of some sort to make sure the option to leave is there
		// loop in case the incorrect option is chosen
		System.out.println("Welcome employee!");
		do {
			if (i > 0)
				System.out.println("That option is invalid.");
		
			System.out.println("Please select from the options below to continue.");
			System.out.println("1 - Enter employee number");
			System.out.println("2 - Exit to Home");
			
			option = s.nextInt();
		} while (option > 0 && option < 3);
		
			// if int a is 0, then started from option 2, 
			// if int a is 1, then started from option 3,
			// separate array of numbers for employees and bank admins
			// will check for the corresponding one
			
			System.out.println("Please enter your employee number.");
			// loop of some sort to make sure the username is correct
				String empNumb = s.nextLine();
				// call method to check if username exist
				
				// if it correct continue to password
				System.out.println("Thank you.");
				
				// else ask for username again
				System.out.println("Please re-enter your account username.");
	}

	public static void custSU(int type) {
		
		BankAccount newCustomer = new CustomerAccount();
		
		System.out.println("Welcome new potential customer!");
		System.out.println("Before you become one of our clients there's first a few"
				+ " things that need to be done");
		
		newCustomer.apply();
		
		BankAccounts.bankDic.add(newCustomer);
		
		System.out.println("Thank you for your time and patients an agent will review your case.");
		// end and goes to front
	}
	
	public static void empSU(int type) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Welcome employee!");
		
	}

	
	
}