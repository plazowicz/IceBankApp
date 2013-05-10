package org.mateusz.ice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mateusz.server.Room;
import org.mateusz.server.RoomLocator;
import org.mateusz.server.RoomsContainer;
import org.mateusz.server.TokenGenerator;

import Chat.IncorrectPasswordException;
import Chat.RoomAlreadyExistException;
import Chat.RoomNotFoundException;
import Chat.UserAlreadyExistException;
import Chat.UserAlreadyLoggedInException;
import Chat.UserNotExistException;
import Chat.UserNotLoggedInException;
import Chat._ManagerDisp;
import Ice.Current;

public class ChatManagerImpl extends _ManagerDisp {

	public Map<String,String> users = new HashMap<String,String>();
	public Map<String,String> sessions = new HashMap<String,String>();
	
	private static ChatManagerImpl manager;
	private RoomLocator locator;
	
	private ChatManagerImpl() {
		
	}
	
	public void setRoomLocator(RoomLocator locator) {
		this.locator = locator;
	}
	
	public static ChatManagerImpl getInstance() {
		if( manager == null ) {
			manager = new ChatManagerImpl();
		}
		return manager;
	}
	
	@Override
	public String[] getRooms(Current __current) {
		RoomsContainer container = RoomsContainer.getInstance();
		List<Room> rooms = container.getRooms();
		String[] names = new String[rooms.size()];
		for( int i = 0 ; i < rooms.size() ; i++ )
			names[i] = rooms.get(i).getName();
		return names;
	}

	@Override
	public boolean register(String nick, String password, Current __current)
			throws UserAlreadyExistException {
		if( users.containsKey(nick))
			throw new UserAlreadyExistException("User "+nick+" already exists");
		users.put(nick, password);
		return true;
	}

	@Override
	public boolean login(String nick, String password, Current __current)
			throws IncorrectPasswordException, UserAlreadyLoggedInException,
			UserNotExistException {
		if( !users.containsKey(nick))
			throw new UserNotExistException("User "+nick+" does not exist");
		String sessionToken = __current.ctx.get("token");
		if( sessionToken != null && sessions.get(sessionToken) != null )
			throw new UserAlreadyLoggedInException("User "+nick+" is already logged in");
		String passwd = users.get(nick);
		if( !passwd.equals(password) )
			throw new IncorrectPasswordException("Incorrect password");
		sessionToken = TokenGenerator.generate();
		sessions.put(sessionToken,nick);
		if( locator != null )
			locator.addRoom(sessionToken);
		return true;
	}

	@Override
	public boolean logout(String nick, Current __current)
			throws UserNotLoggedInException {
		String sessionToken = __current.ctx.get("token");
		if( sessionToken == null || sessions.remove(sessionToken) == null )
			throw new UserNotLoggedInException("User is currently logged out");
		if( locator != null)
			locator.removeRoom(sessionToken);
		return true;
	}

	@Override
	public boolean createRoom(String roomName, Current __current)
			throws RoomAlreadyExistException {
		RoomsContainer container = RoomsContainer.getInstance();
		if( container.doesRoomExist(roomName) )
			throw new RoomAlreadyExistException(roomName+" already exists");
		container.addRoom(new Room(roomName));
		return true;
	}

	@Override
	public boolean removeRoom(String roomName, Current __current)
			throws RoomNotFoundException {
		RoomsContainer container = RoomsContainer.getInstance();
		if( !container.doesRoomExist(roomName))
			throw new RoomNotFoundException(roomName+" not found");
		container.removeRoom(roomName);
		return true;
	}

}
