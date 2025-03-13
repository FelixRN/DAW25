package com.p02.model;

import java.util.List;

import com.p02.model.entities.Car;

public interface IModel {
	
	Car modifiedCar = null;

	void updateCar(String plate, Car modifiedCar);//

	List<Car> list();

	Car add(Car car);

	Car findByPlate(String plateForEdit);

	void delete(String plate);

	void deleteList();
}
