package org.mateusz.server;

import org.mateusz.ice.AccountImpl;
import org.mateusz.ice.ManagerImpl;

public class Server {

//	@Override
//	public int run(String[] args) {
//		
//		Ice.ObjectAdapter adapter = communicator().createObjectAdapter("RootAdapter");
//		
//		AccountImpl account = new AccountImpl();
//		ManagerImpl manager = new ManagerImpl();
//		
//		adapter.add(account, communicator().stringToIdentity("Account"));
//		adapter.add(manager, communicator().stringToIdentity("Manager"));
//		
//		adapter.activate();
//		communicator().waitForShutdown();
//		
//		return 0;
//	}
//	
//	public static void main(String[] args) {
//		Server server = new Server();
//		int status = server.main("BankServer",args,"config.server");
//		System.exit(status);
//	}
	public static void main(String[] args)
    {
        int status = 0;
        Ice.Communicator ic = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectAdapter adapter =
                ic.createObjectAdapterWithEndpoints("RootAdapter", "default -p 10000");
            adapter.add(new AccountImpl(), ic.stringToIdentity("Account"));
            adapter.add(new ManagerImpl(), ic.stringToIdentity("Manager"));
            adapter.activate();
            ic.waitForShutdown();
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        }
        if (ic != null) {
            // Clean up
            //
            try {
                ic.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                status = 1;
            }
        }
        System.exit(status);
    }
	
	
}
