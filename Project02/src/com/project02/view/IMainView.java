package com.project02.view;

import java.util.List;

import com.project02.model.entities.Car;

public interface IMainView {

    int mainMenu();

    void exit();

    void list(List<Car> list);

    Car add();

    int selectIdCar();

    Car editCar(Car carForEdit);

    void showError(Exception e);

}