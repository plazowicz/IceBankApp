package org.mateusz.ice;

import java.util.Map;
import java.util.Set;

import org.mateusz.server.Room;
import org.mateusz.server.RoomsContainer;

import Chat.ClientCallbackPrx;
import Chat.Message;
import Chat.RoomNotFoundException;
import Chat.UserAlreadyInRoomException;
import Chat.UserIsNotInRoomException;
import Chat._RoomDisp;
import Ice.Current;

public class RoomImpl extends _RoomDisp {

	private Room room;
	
	@Override
	public Message[] getHistory(Current __current) throws UserIsNotInRoomException {
		if( room == null )
			throw new UserIsNotInRoomException("User is not in room");
		Map<String,String> messages = room.getMessages();
		Message[] msgsToSend = new Message[messages.size()];
		Set<String> keys = messages.keySet();
		int i = 0;
		for(String key :keys) {
			msgsToSend[i] = new Message(key,messages.get(key));
			++i;
		}
		return msgsToSend;
	}

	@Override
	public boolean send(String message, Current __current) throws UserIsNotInRoomException {
		if( room == null )
			throw new UserIsNotInRoomException("User is not in room");
		String nick = ChatManagerImpl.getInstance().sessions.get(__current.ctx.get("token"));
		room.addMessage(nick, message);
		return true;
	}

	@Override
	public boolean join(String roomName, ClientCallbackPrx callback,
			Current __current) throws RoomNotFoundException,
			UserAlreadyInRoomException {
		RoomsContainer container = RoomsContainer.getInstance();
		Room r = container.getRoomByName(roomName);
		if( r == null )
			throw new RoomNotFoundException("Room "+roomName+" not found");
		String nick = ChatManagerImpl.getInstance().sessions.get(__current.ctx.get("token"));
		if( r.getRoommates().contains(nick))
			throw new UserAlreadyInRoomException("User is already in this room");
		r.join(nick,callback);
		this.room = r;
		return true;
	}

	@Override
	public boolean leave(String roomName, Current __current)
			throws RoomNotFoundException, UserIsNotInRoomException {
		RoomsContainer container = RoomsContainer.getInstance();
		Room r = container.getRoomByName(roomName);
		if( r == null )
			throw new RoomNotFoundException("Room "+roomName+" not found");
		if( room == null )
			throw new UserIsNotInRoomException("User is not in room");
		String nick = ChatManagerImpl.getInstance().sessions.get(__current.ctx.get("token"));
		room.leave(nick);
		room = null;
		return true;
	}

}
