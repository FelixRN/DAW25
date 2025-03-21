package com.project04.model;

import java.util.List;

import com.project04.model.entities.Personal;



public interface IModel {

    List<Personal> list();

    Personal add(Personal personal);

    Personal findById(int idForEdit);

    void editPersonal(int idForEdit, Personal modifiedPersonal) throws Exception;

    void removePersonal(Personal personalForRemove) throws Exception;

}