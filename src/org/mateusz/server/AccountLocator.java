package org.mateusz.server;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.mateusz.ice.AccountImpl;

import Ice.Current;
import Ice.LocalObjectHolder;
import Ice.Object;
import Ice.UserException;

public class AccountLocator implements Ice.ServantLocator {

	public static final Logger logger = Logger.getLogger(AccountLocator.class.getSimpleName());

	private Map<String, AccountImpl> accounts = new HashMap<String,AccountImpl>();
	private AccountImpl loginAccount = new AccountImpl();
	
	@Override
	public Object locate(Current curr, LocalObjectHolder cookie)
			throws UserException {
		if(accounts.containsKey(curr.ctx.get("token"))) {
			return (Object) accounts.get("token");
		}
		return loginAccount;
	}

	@Override
	public void finished(Current curr, Object servant, java.lang.Object cookie)
			throws UserException {
		logger.info("Finished");
	}

	@Override
	public void deactivate(String category) {
		logger.info("Deactivate");
	}
	
	public void addAccount(String token) {
		AccountImpl account = new AccountImpl();
		account.setLocator(this);
		accounts.put(token, account);
	}
	
	public void removeAccount(String token) {
		accounts.remove(token);
	}
	

}
