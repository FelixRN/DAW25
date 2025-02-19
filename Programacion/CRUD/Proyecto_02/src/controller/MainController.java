package controller;

import java.util.List;

import controller.model.IModel;
import controller.model.ModelMemory;
import controller.model.entities.Car;
import controller.view.IMainView;
import controller.view.MainTerminalView;



public class MainController {
	private IModel model;
	private IMainView mainView;
	
	public MainController() {
		this.model = new ModelMemory();
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
					
				case 2: // Añadir coche
					Car car = mainView.add();
					model.add(car);
					break;
					
				case 3: // Editar coche
				    List<Car> listForEdit = model.list(); //1.- Declaramos la variable, guardamos el resultado
				    mainView.list(listForEdit);

				    String plateForEdit = mainView.selectPlateCar();
				    Car carForEdit = model.findByPlate(plateForEdit);

				    if (carForEdit != null) { // Verifica si se encontró el coche
				        Car modifiedCar = mainView.editCar(carForEdit);
				        model.updateCar(plateForEdit, modifiedCar); // Llama al nuevo método para actualizar
				    } else {
				        mainView.showMessage("No se encontró ningún coche con esa matrícula.");
				    }
				    break;
					
					
				case 4: // Eliminar coche
					List<Car> listForDelete = model.list();
				    mainView.list(listForDelete); 

				    String plateToDelete = mainView.selectCarToDelete(); // Obtener la matrícula a eliminar
				    Car carToDelete = model.findByPlate(plateToDelete); // Buscar el coche

				    if (carToDelete != null) { 
				        if (mainView.confirmDelete()) { 
				            model.delete(plateToDelete); // Eliminar el coche
				            mainView.showMessage("Coche eliminado correctamente.");
				        } else {
				            mainView.showMessage("Eliminación cancelada.");
				        }
				    } else {
				        mainView.showMessage("No se encontró ningún coche con esa matrícula.");
				    }
				    break;
					
				default:
			}
		} while (option != 0);
	}
}
