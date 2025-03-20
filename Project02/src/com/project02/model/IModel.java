package com.project02.model;

import java.util.List;

import com.project02.model.entities.Car;

public interface IModel {

    List<Car> list();

    Car add(Car car);

    Car findById(int idForEdit);

    void editCar(int idForEdit, Car modifiedCar) throws Exception;

    void removeCar(Car carForRemove) throws Exception;

}