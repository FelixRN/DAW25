package com.project04.controller;

import java.util.List;

import com.project04.model.IModel;
import com.project04.model.entities.Personal;
import com.project04.model.repository.ModelDatabase;
import com.project04.view.IMainView;
import com.project04.view.MainTerminalView;

import controller.model.entities.Room;



public class MainController {
	private IModel model;
	private IMainView mainView;
	
	public MainController() {
		this.model = new ModelDatabase();
		this.mainView = new MainTerminalView();
	}
	
	public void run() {
		int option;
		
		mainView.showMessage("MODO GESTION: Personal");
		
		do {
			option = mainView.mainMenu();
			switch(option) {
				case 0: // Salir
					mainView.exit();
					break;
					
				case 1: // Listar personal
					List<Personal> list = model.list();
					mainView.list(list);
					break;
					
				case 2: // Añadir personal
					Personal personal = mainView.add();
					model.add(personal);
					break;
					
				case 3: // Editar personal
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
					
				case 4: // Eliminar personal
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
	private void showRoomToCustomer() {
        int option;
        
        mainView.showMessage("MODO CLIENTE: Selección de compra");
        
        do {
            option = mainView.customerMenu();
            switch(option) {
                case 0: 
                    mainView.exit();
                    break;
                    
                case 1: 
                    List<Room> listR = model.list();
                    mainView.list(listR);
                    break;
                    
                case 2: 
                    List<Room> availableRoom = model.list();
                    mainView.list(availableRoom);
                    
                    if (!availableRoom.isEmpty()) {
                        String selectedElement = mainView.selectElementRoom();
                        Room selectedRoom = model.findByElement(selectedElement);
                        
                        if (selectedRoom != null) {
                            mainView.showRoomDetails(selectedRoom);
                            if (mainView.confirmPurchase()) {
                                mainView.completePurchase(selectedRoom);
                            }
                        } else {
                            mainView.showMessage("No se encontró ningún componente con esa matrícula.");
                        }
                    } else {
                        mainView.showMessage("No hay componente disponibles.");
                    }
                    break;
                    
                default:
                    mainView.showMessage("Opción no válida.");
            }
        } while (option != 0);
    }
    
}
