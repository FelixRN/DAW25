package com.project02.controller;

import java.util.ArrayList;
import java.util.List;

import com.project02.entites.Car;
import com.project02.model.IModel;
import com.project02.view.IMainView;
import com.project02.view.MainTerminalView;

public class MainController {
	private IModel model;
	private IMainView mainView;
	
	public MainController() {
		//this.model;
		this.mainView = new MainTerminalView();
	}
	
	public void run() {
		int option = mainView.mainMenu();
		
		switch(option) {
			case 0: // Salir
				mainView.exit();
				break;
				
			case 1: // Listar coches
				List<car> list = new ArrayList<>();
				list.add(new Car ("44455","marca"));
				mainView.list(list);
				break;
				
			case 2: // Añadir coche
			    Car car = mainView.add(); // Obtenemos el coche desde la vista
			    model.add(car); // Añadimos el coche al modelo
			    break;
				
			case 3: // Editar coche
				mainView.edit();
				break;
				
			case 4: // Eliminar coche
				mainView.delete();
				break;
				
			default:
		}
	}
}
