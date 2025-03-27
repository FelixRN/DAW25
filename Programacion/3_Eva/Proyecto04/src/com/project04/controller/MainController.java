package com.project04.controller;

import java.util.List;

import com.project04.model.IModel;
import com.project04.model.entities.Personal;
import com.project04.model.repository.ModelDatabase;
import com.project04.view.IMainView;
import com.project04.view.MainTerminalView;
import com.project04.model.entities.Room; 

public class MainController<Room> {
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
        
        mainView.showMessage("MODO CLIENTE: Selección de room");
        
        do {
            option = mainView.customerMenu();
            switch(option) {
                case 0: 
                    mainView.exit();
                    break;
                    
                case 1: 
                    List<Room> listR = model.listR();
                    mainView.listRooms(listR); //New method for listing rooms
                    break;
                    
                case 2: 
                    List<Room> availableRoom = model.listR();
                    mainView.listRooms(availableRoom);
                    
                    if (!availableRoom.isEmpty()) {
                        int selectedRoomId = mainView.selectRoomById();  // Change to select by ID
                        Room selectedRoom = model.findByIdRoom(selectedRoomId);  // Use existing method
                        
                        if (selectedRoom != null) {
                            mainView.showRoom(selectedRoom);  // Simplified method name
                            // Remove purchase-related methods if not applicable
                        } else {
                            mainView.showMessage("No se encontró ningún room con ese ID.");
                        }
                    } else {
                        mainView.showMessage("No hay rooms disponibles.");
                    }
                    break;
                    
                default:
                    mainView.showMessage("Opción no válida.");
            }
        } while (option != 0);
    }
    
}
