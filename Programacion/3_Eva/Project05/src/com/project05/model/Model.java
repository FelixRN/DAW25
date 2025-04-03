package com.project05.model;

import java.util.List;

import com.project05.model.entities.User;
import com.project05.model.entities.Rol;

public class Model {

    public List<User> listU() {
		return null;
	}
    public List<Rol> listR() {
		return null;
	}

    
    public User add(User user) throws Exception {
		return null;
	}
    public Rol add(Rol rol) {
		return null;
	}

    public User findById(int idForEdit) {
		return null;
	} 
    public Rol findByIdRol(int id) {
		return null;
	}
    
    public void editUser(int idForEdit, User modifiedUser) throws Exception {
	}
    public void editRol(int idForEdit, Rol modifiedRol) throws Exception {
	}
    
    public void removeUser(User userForRemove) throws Exception {
	}
    public void removeRol(Rol rolForRemove) throws Exception {
	}
}
