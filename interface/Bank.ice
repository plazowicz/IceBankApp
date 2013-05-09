module Bank {

	exception UserAlreadyLoggedInException {
		string description;
	};
	
	exception UserNotExistException {
		string description;
	};
	
	exception IncorrectPasswordException {
		string description;
	};
	
	exception UserAlreadyLoggedOutException {
		string description;
	};
	
	exception InsufficientFundsException {
		string description;
	};
	
	exception UserAlreadyExistException {
		string description;
	};
	
	exception UserNotLoggedIn {
		string description;
	};

	interface Account {
		string login(string PESEL, string password) throws UserAlreadyLoggedInException, UserNotExistException,
			IncorrectPasswordException;
			
		bool logout() throws UserAlreadyLoggedOutException;
		
		idempotent int getState() throws UserNotLoggedIn;
		
		int withdraw(int stake) throws UserNotLoggedIn, InsufficientFundsException;
		
		bool deposit(int stake) throws UserNotLoggedIn;
	};
	
	interface Manager {
		bool register(string PESEL, string password) throws UserAlreadyExistException;
	};
	
};