package org.mateusz.ice;

import org.mateusz.server.Account;
import org.mateusz.server.AccountsContainer;

import Bank.UserAlreadyExistException;
import Bank._ManagerDisp;
import Ice.Current;

public class ManagerImpl extends _ManagerDisp{

	@Override
	public boolean register(String PESEL, String password, Current __current)
			throws UserAlreadyExistException {
		AccountsContainer container = AccountsContainer.getInstance();
		if( container.getAccount(PESEL) != null )
			throw new UserAlreadyExistException("User "+PESEL+" has already exists");
		Account account = new Account(PESEL,password);
		container.addAccount(account);
		return true;
	}

}
