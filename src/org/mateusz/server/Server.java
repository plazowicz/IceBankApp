package org.mateusz.server;

import org.mateusz.ice.AccountImpl;
import org.mateusz.ice.ManagerImpl;

public class Server extends Ice.Application {

	@Override
	public int run(String[] args) {
		
		Ice.ObjectAdapter adapter = communicator().createObjectAdapter("RootAdapter");
		
		AccountImpl account = new AccountImpl();
		ManagerImpl manager = new ManagerImpl();
		
		adapter.add(account, communicator().stringToIdentity("Account"));
		adapter.add(manager, communicator().stringToIdentity("Manager"));
		
		adapter.activate();
		communicator().waitForShutdown();
		
		return 0;
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		int status = server.main("BankServer",args,"config.server");
		System.exit(status);
	}
	
}
