package com.wipro.bank.service;

import java.util.Iterator;
import java.util.List;

import com.wipro.bank.bean.Account;
import com.wipro.bank.bean.Customer;
import com.wipro.bank.dao.AccountDao;

public class AccountService {
	
	
	
	public String addAccount(Account acc)
	{
		String addStatus=AccountDao.saveAccount(acc);
		if(addStatus!=null)
		{
			return "success";
		}
		else{
			return "failed";
		}
	}

	public List<Account> getAllAccounts(){
		return AccountDao.findAllAccounts();
	}
	
	public List<Customer> getAllCustomers()
	{
		return AccountDao.findAllCustomers();
	}
	
	public String transferFunds(int from,int to,double amount)
	{
		Account fromAccountDetails =getBalanceOf(from);
		Account toAccountDetails= getBalanceOf(to);
		if(fromAccountDetails==null)
		{
			return "From Account Does not Exist";
		}
		if(toAccountDetails==null)
		{
			return "To Account Does not Exist";
		}
		
		if(fromAccountDetails.getBalance()<amount)
		{
			return "insufficeint balance";
		}
		
		fromAccountDetails.setBalance(fromAccountDetails.getBalance()-amount);
		toAccountDetails.setBalance(toAccountDetails.getBalance()-amount);
		
		return "Funds Successfully Transferred";
		
		
		
	}
	
	public Account getBalanceOf(int accountNumber)
	{
		List<Account> accounts = getAllAccounts();
		Iterator<Account> acctItr = accounts.iterator();
		while(acctItr.hasNext())
		{
			Account account = (Account)acctItr.next();
			if(account.getAccountID()==accountNumber)
			{
				return account;
			}
		}
		
		return null;
	}
}
