package com.p02.view;

import java.util.List;

import com.p02.model.entities.Car;

public interface IMainView {

	int mainMenu();

	void exit();

	void list(List<Car> list);

	Car add();

	void delete();

	String selectPlateCar();

	Car editCar(Car carForEdit);

	String getText();
	
	void showMessage(String message);

	String selectCarToDelete();
	boolean confirmDelete();

	void infoSaveData();
}
