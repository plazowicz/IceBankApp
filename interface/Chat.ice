module Chat {
	
	exception UserAlreadyInRoomException {
		string description;
	};
	
	exception UserIsNotInRoomException {
		string description;
	};
	
	exception UserAlreadyExistException {
		string description;
	}; 
	
	exception UserNotExistException {
		string description;
	};
	
	exception IncorrectPasswordException {
		string description;
	};
	
	exception RoomAlreadyExistException {
		string description;
	};
	
	exception RoomNotFoundException {
		string description;
	};
	
	exception UserAlreadyLoggedInException {
		string description;
	};
	
	exception UserNotLoggedInException {
		string description;
	};
	
	class Message {
		string user;
		string msg;
	};
	
	interface ClientCallback {
		void stateDidChange(Message change);
	};
	
	sequence<Message> Messages;
	
	interface Room {
	
		Messages getHistory() throws UserIsNotInRoomException;
		
		bool send(string message) throws UserIsNotInRoomException;
	
		bool join(string roomName,ClientCallback* callback) throws UserAlreadyInRoomException, RoomNotFoundException;
		
		bool leave(string roomName) throws UserIsNotInRoomException, RoomNotFoundException;
	};
	
	sequence<string> Rooms;
	
	interface Manager {
	
		Rooms getRooms();
		
		bool register(string nick,string password) throws UserAlreadyExistException;
		
		bool login(string nick, string password) throws UserAlreadyLoggedInException,IncorrectPasswordException,
													UserNotExistException;
		
		bool logout(string nick) throws UserNotLoggedInException;
		
		bool createRoom(string roomName) throws RoomAlreadyExistException;
		
		bool removeRoom(string roomName) throws RoomNotFoundException;
	};
};