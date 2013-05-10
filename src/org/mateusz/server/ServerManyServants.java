package org.mateusz.server;

import org.mateusz.ice.ManagerImpl;

public class ServerManyServants extends Ice.Application {

	@Override
	public int run(String[] args) {
		Ice.ObjectAdapter adapter = communicator().createObjectAdapter("RootAdapter");
		ManagerImpl manager = new ManagerImpl();
		AccountLocator locator = new AccountLocator();
		adapter.add(manager, communicator().stringToIdentity("Manager"));
		adapter.addServantLocator(locator, "AccountsLocator");
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