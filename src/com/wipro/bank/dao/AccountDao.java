package com.wipro.bank.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.wipro.bank.bean.Account;
import com.wipro.bank.bean.Customer;

public class AccountDao {
	
	public static List<Account> accounts;
	public static List<Customer> customers;
	
	public static void  defineDB(List<Account> accts)
	{
		accounts=accts;
		customers=new ArrayList<Customer>();
		Iterator<Account> acctItr = accounts.iterator();
		while(acctItr.hasNext())
		{
			Account account = (Account)acctItr.next();
			customers.add(account.getCustomer());
		}
	}

	public static String saveAccount(Account account)
	{
		if(accounts.add(account))
		{
			customers.add(account.getCustomer());
			return "Account Succesfully Added";
		}
		else
			return null;
	}
	
	public static  List<Account> findAllAccounts()
	{
		return accounts;
	}
	
	public static String saveCustomer (Customer customer) 
	{
		if(customers.add(customer))
		{
			return "Customer Succesfully Added";
		}
		else
			return null;
	}
	
	static public List<Customer> findAllCustomers() 
	{
		return customers;
	}

	public static List<Account> getAccounts() {
		return accounts;
	}

	public static void setAccounts(List<Account> accounts) {
		AccountDao.accounts = accounts;
	}

	public static List<Customer> getCustomers() {
		return customers;
	}

	public static void setCustomers(List<Customer> customers) {
		AccountDao.customers = customers;
	}
	
	
}
