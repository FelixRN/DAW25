package com.project05.model.entities;

public class User {

	private int id;
	private String name; 
	private String Password;
	

	public User(int id, String name, String password) {
		super();
		this.setId(id);
		this.setName(name);
		setPassword(password);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String toString() {
	    return id + " - " + name + " - " + Password;
	}
}
