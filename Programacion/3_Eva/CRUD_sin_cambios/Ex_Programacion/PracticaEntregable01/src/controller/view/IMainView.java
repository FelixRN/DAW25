package controller.view;

import java.util.List;

import controller.model.entities.Components;

public interface IMainView {

	int mainMenu();

	void exit();

	void list(List<Components> list);

	Components add();

	void edit();

	void delete();

	String selectElementComponents();

	Components editComponents(Components componentsForEdit);

	String getText();
	
	void showMessage(String message);

	String selectComponentsToDelete();
	boolean confirmDelete();
}