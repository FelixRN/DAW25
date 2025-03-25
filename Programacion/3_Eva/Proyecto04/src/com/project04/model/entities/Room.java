package com.project04.model.entities;

public class Room {
	private int id_room;
	private String name;
	private String capacity;
	private int type;


public Room(int id_room, String name, String capacity, int type) {
	super();
	this.id_room = id_room;
	this.name = name;
	this.capacity = capacity;
	this.type = type;
}

@Override
public String toString() {
    return "Room =" + id_room + ", Nombre=" + name + ", Ocupación=" + capacity + ", consumo=" + type;
}

@Override
public Room clone() {
    return new Room(this.id_room, this.name, this.capacity, this.type);
}

public int getId_room() {
    return id_room;
}

public void setId_room(int id_room) {
    this.id_room = id_room;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getOccupation() {
    return capacity;
}

public void setOccupation(String capacity) {
    this.capacity = capacity;
}

public int getType() {
    return type;
}

public void setType(int type) {
    this.type = type;
}


}
