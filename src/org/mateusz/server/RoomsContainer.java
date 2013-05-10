package org.mateusz.server;

import java.util.ArrayList;
import java.util.List;

public class RoomsContainer {

	private static RoomsContainer container;
	
	private List<Room> rooms = new ArrayList<Room>();
	
	private RoomsContainer() {
		
	}
	
	public static RoomsContainer getInstance() {
		if( container == null ) {
			container = new RoomsContainer();
		}
		return container;
	}
	
	public void addRoom(Room r) {
		rooms.add(r);
	}
	
	public void removeRoom(String roomName) {
		Room r = null;
		for(Room room : rooms) {
			if( room.getName().equals(roomName)) {
				r = room;
				break;
			}
		}
		if( r != null)
			rooms.remove(r);
	}
	
	public List<Room> getRooms() {
		return rooms;
	}
	
	public boolean doesRoomExist(String name) {
		for(Room r : rooms) {
			if( r.getName().equals(name))
				return true;
		}
		return false;
	}
	
	public Room getRoomByName(String name) {
		for(Room r : rooms) {
			if( r.getName().equals(name) )
				return r;
		}
		return null;
	}
}