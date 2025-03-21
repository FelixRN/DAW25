package com.project04.view;

import java.util.List;

import com.project04.model.entities.Personal;


public interface IMainView {

    int mainMenu();

    void exit();

    void list(List<Personal> list);

    Personal add();

    int selectIdPersonal();

    Personal editPersonal(Personal personalForEdit);

    void showError(Exception e);

}
