package com.project04.model.entities;



public class Personal {
	private int id_personal;
	private String name;
	private String occupation;
	private int id_room;


public Personal(int id_personal, String name, String occupation, int id_room) {
	super();
	this.id_personal = id_personal;
	this.name = name;
	this.occupation = occupation;
	this.id_room = id_room;
}

@Override
public String toString() {
    return "Personal =" + id_personal + ", Nombre=" + name + ", Ocupación=" + occupation + ", consumo=" + id_room;
}

@Override
public Personal clone() {
    return new Personal(this.id_personal, this.name, this.occupation, this.id_room);
}

public int getId_personal() {
    return id_personal;
}

public void setId_personal(int id_personal) {
    this.id_personal = id_personal;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getOccupation() {
    return occupation;
}

public void setOccupation(String occupation) {
    this.occupation = occupation;
}

public int getId_room() {
    return id_room;
}

public void setId_room(int id_room) {
    this.id_room = id_room;
}


}