package com.project05.view;

import java.util.List;

import com.project05.model.Model;
import com.project05.model.entities.User;
import com.project05.utils.TerminalUtils;

public class MainTerminalView {
    private Model model;
    private MainView mainView;
    
    public MainTerminalView() {
        this.model = new Model();
        this.mainView = new MainView();
    }
    
    public void run() throws Exception {
        int option;
        
        mainView.output("MODO GESTION: User"); //Instanciamos 
        
        do {
            option = mainView.mainMenu();
            switch(option) {
                case 0: // Salir
                    mainView.exit();
                    break;
                    
                case 1: // Listar user
                    try {
                        List<User> list = model.listU();
                        mainView.list(list);
                    } catch (Exception e) {
                        mainView.showError(e);
                    }
                    break;
                    
                case 2: // Añadir user
                    User user = mainView.add();
                    model.add(user);
                    break;
                    
                case 3: // Editar user
                    List<User> listForEdit = model.listU();
                    mainView.list(listForEdit);
                    
                    int idForEdit = mainView.selectIdUser();
                    User userForEdit = model.findById(idForEdit);
                    
                    User modifiedUser = mainView.editUser(userForEdit);
                    try {
                        model.editUser(idForEdit, modifiedUser);
                    } catch (Exception e) {
                        mainView.showError(e);
                    }
                    break;
                    
                case 4: // Eliminar user
                    List<User> listForRemove = model.listU();
                    mainView.list(listForRemove);
                    
                    int idForRemove = mainView.selectIdUser();
                    User userForRemove = model.findById(idForRemove);
                    
                    try {
                        model.removeUser(userForRemove);
                    } catch (Exception e) {
                        mainView.showError(e);
                    }
                    break;
                    
                default:
                    TerminalUtils.output("Opción no válida");
            }
        } while (option != 0);
    }

    
}