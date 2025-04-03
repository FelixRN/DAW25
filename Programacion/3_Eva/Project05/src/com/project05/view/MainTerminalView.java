package com.project05.view;

import java.util.List;

import com.project05.model.entities.User;
import com.project05.utils.TerminalUtils;

public class MainTerminalView {

	public int mainMenu() {
		int option;
		
		TerminalUtils.output("Menú de concesionario");
		TerminalUtils.output("================");

		TerminalUtils.output("1.- Listar user");
		TerminalUtils.output("2.- Añadir user");
		TerminalUtils.output("3.- Editar user");
		TerminalUtils.output("4.- Eliminar user");
		TerminalUtils.output("0.- Salir");
		
		try {
			option = TerminalUtils.inputInt();
		} catch (Exception e) {
			option = -1;
		}
		
		return option;
	}

	public void exit() {
		TerminalUtils.output("Adios");
	}

	public void list(List<User> listU) {
		TerminalUtils.output("Lista de user");
		TerminalUtils.output("Id - Nombre - Contraseña");
		
		for(User user : listU) {
			TerminalUtils.output(user.toString());
		}
	}
	
	public User add() {
		TerminalUtils.output("Nuevo user");
		TerminalUtils.output("================");

		TerminalUtils.output("Introduzca el nombre");
		String name = TerminalUtils.inputText();
		
		TerminalUtils.output("Introduzca la contraseña");
		String password = TerminalUtils.inputText();
		
		
		User user = new User(0, name, password);
		return user;
	}
	
	public int selectIdUser() {
		TerminalUtils.output("Introduzca el id:");
		int id = TerminalUtils.inputInt();
		return id;
	}

	public User editUser(User userForEdit) {
		TerminalUtils.output("Editar coche");
		TerminalUtils.output("================");

		TerminalUtils.output("Introduzca el nombre (si lo deja vacío no se modificará)");
		String name = TerminalUtils.inputText();
		if(isValidString(name)) {
			userForEdit.setName(name);
		}

		TerminalUtils.output("Introduzca la nueva contraseña (si lo deja vacío no se modificará)");
		String password = TerminalUtils.inputText();
			userForEdit.setPassword(password);
			
		return userForEdit;
	}
	
	public boolean isValidString(String value) {
		return value != null && !value.isEmpty() && !value.isBlank();
	}

	public void showError(Exception e) {
		TerminalUtils.output(e.getMessage());
	}
}
