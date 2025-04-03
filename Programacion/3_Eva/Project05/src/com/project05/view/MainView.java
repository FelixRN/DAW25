package com.project05.view;

import java.util.List;

import com.project05.model.entities.User;
import com.project05.controller.MainController;
import com.project05.model.Model;
import com.project05.view.MainTerminalView;

public class MainView {

	private Model model;
	
	
	public void run() throws Exception {
	    int option;
	    
	    showMessage("MODO GESTION: User");
	    
	    do {
	        option = mainMenu();
	        switch(option) {
	            case 0: // Salir
	                exit();
	                break;
	                
	            case 1: // Listar user
	                List<User> list = model.listU();
	                list(list);
	                break;
	                
	            case 2: // Añadir user
	                User user = add();
	                model.add(user);
	                break;
	                
	            case 3: // Editar user
	                List<User> listForEdit = model.listU();
	                list(listForEdit);
	                
	                int idForEdit = selectIdUser();
	                User userForEdit = model.findById(idForEdit);
	                
	                User modifiedUser = editUser(userForEdit);
	                try {
	                    model.editUser(idForEdit, modifiedUser);
	                } catch (Exception e) {
	                    showError(e);
	                }
	                break;
	                
	            case 4: // Eliminar user
	                List<User> listForRemove = model.listU();
	                list(listForRemove);
	                
	                int idForRemove = selectIdUser();
	                User userForRemove = model.findById(idForRemove);
	                
	                try {
	                    model.removeUser(userForRemove);
	                } catch (Exception e) {
	                    showError(e);
	                }
	                break;
	                
	            default:
	        }
	    } while (option != 0);
	}

	private void showError(Exception e) {
		// TODO Auto-generated method stub
		
	}

	private User editUser(User userForEdit) {
		// TODO Auto-generated method stub
		return null;
	}

	private int selectIdUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void exit() {
		// TODO Auto-generated method stub
		
	}

	private User add() {
		// TODO Auto-generated method stub
		return null;
	}

	private void list(List<User> list) {
		// TODO Auto-generated method stub
		
	}

	private int mainMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void showMessage(String string) {
		// TODO Auto-generated method stub
		
	}
	
}