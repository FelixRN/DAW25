package com.project04.model;

import java.util.List;

import com.project04.model.entities.Personal;
import com.project04.model.entities.Room;

public interface IModel {

    List<Personal> list();
    List<Room> listR();

    Personal add(Personal personal);
    Room add(Room room);

    Personal findById(int idForEdit); 
    Room findByIdRoom(int id);
    
    void editPersonal(int idForEdit, Personal modifiedPersonal) throws Exception;
    void editRoom(int idForEdit, Room modifiedRoom) throws Exception;
    
    void removePersonal(Personal personalForRemove) throws Exception;
    void removeRoom(Room roomForRemove) throws Exception;
}