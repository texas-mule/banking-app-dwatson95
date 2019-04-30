package com.revature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class BankAccounts {
	//list of all users
	public static List<String> userDic = new ArrayList<String>();
	//list of all bank accounts objects
	public static List<BankAccount> bankDic = new ArrayList<BankAccount>();  //need to see if better way
	//list of all customers
	public static List<String> customerDic = new ArrayList<String>();
	//list of all employees
	public static List<String> employeeDic = new ArrayList<String>();
	//list of all admins
	public static List<String> adminDic = new ArrayList<String>();
	
	public static List<String> userJoiDic = new ArrayList<String>();
	//hashmap containing key username and value password
	public static HashMap<String, String> userToPswd = new HashMap<String, String>();
	//hashmap containing key of username and value of index number to bankDic
	public static HashMap<String, Integer> bankIndex = new HashMap<String, Integer>();
	//hashmap containing key of saving's account name and value of the user's username
	public static HashMap<String, String> usersSavingsAcc = new HashMap<String, String>();
	//hashtable containing key joint bank account name and value of the balance of joint account
	public static Hashtable<String, Double> usersJointAcc = new Hashtable<String, Double>();
}
