package com.project02.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.project02.model.IModel;
import com.project02.model.entities.Car;

public class ModelMemory implements IModel {

    private List<Car> list;
    private int autoIncrementId;

    public ModelMemory() {
        list = new ArrayList<>();
        autoIncrementId = 1;
    }

    @Override
    public List<Car> list() {
        return list;
    }

    @Override
    public Car add(Car car) {
        list.add(car);
        car.setId(autoIncrementId);
        return car;
    }

    @Override
    public Car findById(int idForEdit) {
        Car car = null;

        for(Car i : list) {
            if(i.getId() == idForEdit) {
                car = i.clone();
            }
        }

        return car;
    }

    @Override
    public void editCar(int idForEdit, Car modifiedCar) throws Exception {
        Car findCar = null;
        for(Car car : list) {
            if(car.getId() == idForEdit) {
                findCar = car;
            }
        }

        if(findCar == null) {
            throw new Exception("Car not found");
        }

        int indexOfCar = list.indexOf(findCar);

        list.set(indexOfCar, modifiedCar);
    }

    @Override
    public void removeCar(Car carForRemove) throws Exception {
        int indexOfCar = -1;
        for(Car car : list) {
            if(car.equals(carForRemove)) {
                indexOfCar = list.indexOf(car);
            }
        }

        if(indexOfCar == -1) {
            throw new Exception("Car not found");
        }

        list.remove(indexOfCar);
    }

}
