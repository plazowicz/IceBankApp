package org.mateusz.ice;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.mateusz.server.Account;
import org.mateusz.server.AccountLocator;
import org.mateusz.server.AccountsContainer;
import org.mateusz.server.TokenGenerator;

import Bank.IncorrectPasswordException;
import Bank.InsufficientFundsException;
import Bank.UserAlreadyLoggedInException;
import Bank.UserAlreadyLoggedOutException;
import Bank.UserNotExistException;
import Bank.UserNotLoggedIn;
import Bank._AccountDisp;
import Ice.Current;

public class AccountImpl extends _AccountDisp {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4047017850639388499L;

	public static final Logger logger = Logger.getLogger(AccountImpl.class.getSimpleName());
	
	private Map<String,String> sessions;
	private AccountLocator locator;
	
	public AccountImpl() {
		sessions = new HashMap<String, String>();
	}
	
	public void setLocator(AccountLocator locator) {
		this.locator = locator;
	}
	
	@Override
	public String login(String PESEL, String password, Current __current)
			throws IncorrectPasswordException, UserAlreadyLoggedInException,
			UserNotExistException {
		Account account = AccountsContainer.getInstance().getAccount(PESEL);
		if( account == null )
			throw new UserNotExistException("There is no user "+PESEL);
		if( sessions.get(PESEL) != null )
			throw new UserAlreadyLoggedInException("User "+PESEL+" is already logged in");
		if( !account.getPassword().equals(password) )
			throw new IncorrectPasswordException("Password is incorrect");
		logger.info("Generating token for new session...");
		String sessionToken = TokenGenerator.generate();
		sessions.put(sessionToken,PESEL);
		if( locator != null ) {
			locator.addAccount(sessionToken);
		}
		return sessionToken;
	}

	@Override
	public boolean logout(Current __current) throws UserAlreadyLoggedOutException {
		String sessionToken = __current.ctx.get("token");
		if( sessionToken == null || sessions.remove(sessionToken) == null )
			throw new UserAlreadyLoggedOutException("This user is already logged out");
		if( locator != null ) {
			locator.removeAccount(sessionToken);
		}
		return true;
	}

	@Override
	public int getState(Current __current) throws UserNotLoggedIn {
		String PESEL = getPESELBySessionToken(__current);
		return AccountsContainer.getInstance().getAccount(PESEL).getStake();
	}

	@Override
	public int withdraw(int stake, Current __current)
			throws UserNotLoggedIn, InsufficientFundsException {
		String PESEL = getPESELBySessionToken(__current);
		Account account = AccountsContainer.getInstance().getAccount(PESEL);
		if( !account.withdraw(stake) )
			throw new InsufficientFundsException("Insufficient funds. You have only: "+account.getStake());
		logger.info("Withdrawal succeeded");
		return stake;
	}

	@Override
	public boolean deposit(int stake, Current __current) throws UserNotLoggedIn {
		String PESEL = getPESELBySessionToken(__current);
		Account account = AccountsContainer.getInstance().getAccount(PESEL);
		account.deposit(stake);
		logger.info("Deposit succeeded");
		return true;
	}
	
	private String getPESELBySessionToken(Current __current) throws UserNotLoggedIn {
		String sessionToken = __current.ctx.get("token");
		String PESEL = null;
		if( sessionToken == null || (PESEL = sessions.get(sessionToken)) == null)
			throw new UserNotLoggedIn("User is not logged in");
		return PESEL;
	}
}
