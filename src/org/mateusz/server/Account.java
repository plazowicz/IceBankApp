package org.mateusz.server;

public class Account {

	private int stake;
	private String PESEL;
	private String password;
	
	public Account(String PESEL, String password) {
		this.PESEL = PESEL;
		this.password = password;
		this.stake = 0;
	}
	
	public String getPESEL() {
		return PESEL;
	}
	
	public String getPassword() {
		return password;
	}
	
	public synchronized int getStake() {
		return this.stake;
	}
	
	public synchronized boolean withdraw(int stake) {
		if( this.stake < stake )
			return false;
		this.stake -= stake;
		return true;
	}
	
	public synchronized void deposit(int stake) {
		this.stake += stake;
	}
	
}
