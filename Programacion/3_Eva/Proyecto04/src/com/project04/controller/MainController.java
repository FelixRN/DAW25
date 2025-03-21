package com.project04.controller;

import java.util.List;

import com.project04.model.IModel;
import com.project04.model.entities.Personal;



public class MainController {
	private IModel model;
	private IMainView mainView;
	
	public MainController() {
		this.model = new ModelDatabase();
		this.mainView = new MainTerminalView();
	}
	
	public void run() {
		int option;
		
		do {
			option = mainView.mainMenu();
			switch(option) {
				case 0: // Salir
					mainView.exit();
					break;
					
				case 1: // Listar coches
					List<Personal> list = model.list();
					mainView.list(list);
					break;
					
				case 2: // Añadir coche
					Personal personal = mainView.add();
					model.add(personal);
					break;
					
				case 3: // Editar coche
					List<Personal> listForEdit = model.list();
					mainView.list(listForEdit);
					
					int idForEdit = mainView.selectIdPersonal();
					Personal personalForEdit = model.findById(idForEdit);
					
					Personal modifiedPersonal = mainView.editPersonal(personalForEdit);
					try {
						model.editPersonal(idForEdit, modifiedPersonal);
					} catch (Exception e) {
						mainView.showError(e);
					}
					break;
					
				case 4: // Eliminar coche
					List<Personal> listForRemove = model.list();
					mainView.list(listForRemove);
					
					int idForRemove = mainView.selectIdPersonal();
					Personal personalForRemove = model.findById(idForRemove);
					
					try {
						model.removePersonal(personalForRemove);
					} catch (Exception e) {
						mainView.showError(e);
					}
					break;
					
				default:
			}
		} while (option != 0);
	}
}