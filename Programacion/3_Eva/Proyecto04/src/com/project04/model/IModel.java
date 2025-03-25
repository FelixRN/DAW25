package com.project04.model;

import java.util.List;

import com.project04.model.entities.Personal;
import com.project04.model.entities.Room;



public interface IModel {

    List<Personal> list();

    Personal add(Personal personal);

    Personal findById(int idForEdit);

    void editPersonal(int idForEdit, Personal modifiedPersonal) throws Exception;

    void removePersonal(Personal personalForRemove) throws Exception;

    
    List<Room> listR();

    Room add(Room room);

    Room findByIdRoom(int idForEdit);

    void editRoom(int idForEdit, Room modifiedRoom) throws Exception;

    void removeRoom(Room roomForRemove) throws Exception;
    
    
}