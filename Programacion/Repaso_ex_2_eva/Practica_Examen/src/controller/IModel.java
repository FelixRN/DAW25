package controller;

import java.util.List;

import controller.model.entities.Pelis;

public class IModel {
	
	public interface IModel {
		
		Pelis modifiedPelis = null;

		void updatePelis(String plate, Pelis modifiedPelis);//

		List<Pelis> list();

		void add(Pelis car);

		Pelis findByPlate(String plateForEdit);

		void editPelis(String plateForEdit, Pelis modifiedPelis);

		void delete(String plate);
	}


}
