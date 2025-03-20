package controller.model;

import java.util.ArrayList;
import java.util.List;

import controller.model.entities.Components;


public class ModelMemory implements IModel {

	private List<Components> list;
	
	public ModelMemory() {
		list = new ArrayList<>();
	}
	
	@Override
	public List<Components> list() {
		return list;
	}

	@Override
	public void add(Components components) {
		list.add(components);
	}

	@Override
	public Components findByElement(String elementForEdit) {
		Components components = null;
		
		for(Components i : list) {
			if(i.getElement().equals(elementForEdit)) {
				components = i.clone();
			}
		}
		
		return components;
	}
	
	@Override
	public void updateComponents(String element, Components modifiedComponents) {
	    for (int i = 0; i < list.size(); i++) {
	        Components components = list.get(i);
	        if (components.getElement().equals(element)) {
	            list.set(i, modifiedComponents); 
	            break;
	        }
	    }
	}
	

	@Override
	public void editComponents(String elementForEdit, Components modifiedComponents) {
		
	}

	@Override
	public void delete(String element) {
	    list.removeIf(components -> components.getElement().equals(element));
	}
}
