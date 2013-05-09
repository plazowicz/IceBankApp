package org.mateusz.server;
import java.util.ArrayList;
import java.util.List;

public class AccountsContainer {

	private static AccountsContainer container;
	
	private List<Account> accounts = new ArrayList<Account>();
	
	private AccountsContainer() {
		
	}
	
	public static AccountsContainer getInstance() {
		if( container == null ) {
			container = new AccountsContainer();
		}
		return container;
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	public Account getAccount(String PESEL) {
		Account account = null;
		for(Account a : accounts) {
			if( a.getPESEL().equals(PESEL) ) {
				account = a;
				break;
			}
		}
		return account;
	}
	
}
