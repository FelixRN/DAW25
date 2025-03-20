package controller.model;

import java.util.List;

import controller.model.entities.Components;

public interface IModel {
	
	Components modifiedComponents = null;

	void updateComponents(String element, Components modifiedComponents);//

	List<Components> list();

	void add(Components components);

	Components findByPlate(String plateForEdit);

	void editComponents(String plateForEdit, Components modifiedComponents);

	void delete(String element);

	Components findByElement(String elementForEdit);
}