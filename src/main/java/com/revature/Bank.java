package com.revature;

import java.util.Scanner;

public class Bank {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to RV Bank.");
		homePage();
		
		//String o = s.next();
		
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
			//System.out.println("5 - Leave");
			
			option = s.nextInt();
			i++;
		} while (option > 0 && option < 5);
		
		
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
			if (i > 0)
				System.out.println("That option is invalid.");
			
			System.out.println("Please select from the options below to continue.");
			System.out.println("1 - Login");
			System.out.println("2 - Exit to Home");
	
			option = s.nextInt();
			i++;
		} while (option > 0 && option < 3);
			
			// loop of some sort to make sure the username is correct
			System.out.println("Please enter your account username.");
			
				String username = s.next();
				// call method to check if username exist
				
				// if it correct continue to password
				System.out.println("Thank you.");
				
				// else ask for username again
				System.out.println("Please re-enter your account username.");
			
			System.out.println("Please enter your account password.");
			// loop of some sort to make sure the password is correct
				String password = s.nextLine();
				
				// if it is correct continue to login screen
				System.out.println("Thank you.");
						
				// else ask for password again
				System.out.println("Please re-enter your account password.");
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
		Scanner s = new Scanner(System.in);
		
		BankAccount newCustomer = new CustomerAccount(null, null, type);
		
		System.out.println("Welcome new potential customer!");
		System.out.println("Before you become one of our clients there's first a few"
				+ " things that need to be done");
		System.out.println("Please enter your First Name!");
		String fName = s.nextLine();
		newCustomer.setFirstN(fName);
		System.out.println("Please enter your Last Name!");
		String lName = s.nextLine();
		newCustomer.setFirstN(lName);
		
		
		System.out.println("Thank you for your time and patients an agent will review your case.");
		// end and goes to front
	}
	
	public static void empSU(int type) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Welcome employee!");
		
	}

	
}