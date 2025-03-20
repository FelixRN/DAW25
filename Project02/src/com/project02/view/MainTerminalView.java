package com.project02.view;

import java.util.List;

import com.project02.model.entities.Car;
import com.project02.utils.TerminalUtils;

public class MainTerminalView implements IMainView {

	@Override
	public int mainMenu() {
		int option;
		
		TerminalUtils.output("Menú de concesionario");
		TerminalUtils.output("================");

		TerminalUtils.output("1.- Listar coche");
		TerminalUtils.output("2.- Añadir coche");
		TerminalUtils.output("3.- Editar coche");
		TerminalUtils.output("4.- Eliminar coche");
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

	@Override
	public void list(List<Car> list) {
		TerminalUtils.output("Lista de coches");
		TerminalUtils.output("Id - Marca - Modelo - Consumo - Emisiones - Imagen");
		
		for(Car car : list) {
			TerminalUtils.output(car.toString());
		}
	}
	
	@Override
	public Car add() {
		TerminalUtils.output("Nuevo coche");
		TerminalUtils.output("================");

		TerminalUtils.output("Introduzca la marca");
		String brand = TerminalUtils.inputText();
		
		TerminalUtils.output("Introduzca la modelo");
		String model = TerminalUtils.inputText();
		
		TerminalUtils.output("Introduzca la consumo");
		float consume = TerminalUtils.inputFloat();
		
		TerminalUtils.output("Introduzca la emisiones");
		int emissions = TerminalUtils.inputInt();
		
		Car car = new Car(0, brand, model, consume, emissions, "");
		return car;
	}
	
	@Override
	public int selectIdCar() {
		TerminalUtils.output("Introduzca el id:");
		int id = TerminalUtils.inputInt();
		return id;
	}

	@Override
	public Car editCar(Car carForEdit) {
		TerminalUtils.output("Editar coche");
		TerminalUtils.output("================");

		TerminalUtils.output("Introduzca la nueva marca (si lo deja vacío no se modificará)");
		String brand = TerminalUtils.inputText();
		if(isValidString(brand)) {
			carForEdit.setBrand(brand);
		}

		TerminalUtils.output("Introduzca el nuevo modelo (si lo deja vacío no se modificará)");
		String model = TerminalUtils.inputText();
			carForEdit.setModel(model);
			
		TerminalUtils.output("Introduzca el nuevo consumo (si lo deja vacío no se modificará)");
		float consume = TerminalUtils.inputFloat();
			carForEdit.setConsume(consume);
		
		TerminalUtils.output("Introduzca el nuevo emisiones (si lo deja vacío no se modificará)");
		int emissions = TerminalUtils.inputInt();
			carForEdit.setEmissions(emissions);
		
		return carForEdit;
	}
	
	public boolean isValidString(String value) {
		return value != null && !value.isEmpty() && !value.isBlank();
	}

	@Override
	public void showError(Exception e) {
		TerminalUtils.output(e.getMessage());
	}
}
