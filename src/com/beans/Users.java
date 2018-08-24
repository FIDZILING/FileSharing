package com.beans;

public class Users {
	private String name;
	private String password;
	/*
	 * 0 == administrator, 1 == normal user
	 */
	private int numLevel;

	public Users() {
	}

	public Users(String name, String password, int numlevel) {
		this.name = name;
		this.password = password;
		this.numLevel = numlevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNumLevel() {
		return numLevel;
	}

	public void setNumLevel(int numLevel) {
		this.numLevel = numLevel;
	}
}
