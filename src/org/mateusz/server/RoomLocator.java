package org.mateusz.server;

import java.util.HashMap;
import java.util.Map;

import org.mateusz.ice.RoomImpl;

import Ice.Current;
import Ice.LocalObjectHolder;
import Ice.Object;
import Ice.ServantLocator;
import Ice.UserException;

public class RoomLocator implements ServantLocator {

	private Map<String,RoomImpl> rooms = new HashMap<String,RoomImpl>();
	
	@Override
	public Object locate(Current curr, LocalObjectHolder cookie)
			throws UserException {
		String sessionToken = curr.ctx.get("token");
		if( rooms.containsKey(sessionToken) )
			return rooms.get(sessionToken);
		return null;
	}

	@Override
	public void finished(Current curr, Object servant, java.lang.Object cookie)
			throws UserException {
		System.out.println("finished");
		
	}

	@Override
	public void deactivate(String category) {
		System.out.println("deactivate");
	}
	
	public void addRoom(String sessionToken) {
		rooms.put(sessionToken, new RoomImpl());
	}
	
	public void removeRoom(String sessionToken) {
		rooms.remove(sessionToken);
	}

}
