package com.project02.controller;

import java.util.List;

import com.project02.model.IModel;
import com.project02.model.entities.Car;
import com.project02.model.repository.ModelDatabase;
import com.project02.model.repository.ModelMemory;
import com.project02.view.IMainView;
import com.project02.view.MainTerminalView;

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
					List<Car> list = model.list();
					mainView.list(list);
					break;
					
				case 2: // AÃ±adir coche
					Car car = mainView.add();
					model.add(car);
					break;
					
				case 3: // Editar coche
					List<Car> listForEdit = model.list();
					mainView.list(listForEdit);
					
					int idForEdit = mainView.selectIdCar();
					Car carForEdit = model.findById(idForEdit);
					
					Car modifiedCar = mainView.editCar(carForEdit);
					try {
						model.editCar(idForEdit, modifiedCar);
					} catch (Exception e) {
						mainView.showError(e);
					}
					break;
					
				case 4: // Eliminar coche
					List<Car> listForRemove = model.list();
					mainView.list(listForRemove);
					
					int idForRemove = mainView.selectIdCar();
					Car carForRemove = model.findById(idForRemove);
					
					try {
						model.removeCar(carForRemove);
					} catch (Exception e) {
						mainView.showError(e);
					}
					break;
					
				default:
			}
		} while (option != 0);
	}
}