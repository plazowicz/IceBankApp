package org.mateusz.server;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Chat.ClientCallbackPrx;
import Chat.Message;

public class Room {
	
	private String name;
	private Set<String> roommates = new HashSet<String>();
	private Map<String,String> messages = new HashMap<String,String>();
	private Map<String,ClientCallbackPrx> callbacks = new HashMap<String,ClientCallbackPrx>();
	
	public Room(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void leave(String nick) {
		roommates.remove(nick);
		callbacks.remove(nick);
	}
	
	public void addMessage(String nick,String message) {
		messages.put(nick,message);
		Collection<ClientCallbackPrx> c = callbacks.values();
		for(ClientCallbackPrx ccp : c) {
			ccp.stateDidChange(new Message(nick,message));
		}
	}
	
	public Map<String,String> getMessages() {
		return messages;
	}
	
	public Set<String> getRoommates() {
		return roommates;
	}
	
	public void join(String nick, ClientCallbackPrx callback) {
		roommates.add(nick);
		callbacks.put(nick, callback);
	}
	
}
