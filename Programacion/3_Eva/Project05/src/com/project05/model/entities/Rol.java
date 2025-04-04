package com.project05.model.entities;

public class Rol {

	private int id;
	private String occupation;
	
	
	public Rol(int id, String occupation) {
		super();
		this.setId(id);
		this.setOccupation(occupation);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	
	@Override
	public String toString() {
	    return id + " - " + occupation;
	}
	
}
