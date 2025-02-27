package controller;

import java.util.List;

import View.IMainView;
import View.MainTerminalView;
import controller.model.entities.Pelis;
import model.IModel;
import model.ModelMemory;

public class MainController {
	
	private IModel model;
	private IMainView mainView;
	
	public MainController() {
		this.model = new ModelMemory();
		this.mainView = new MainTerminalView();
}
	
	public void run() {
		int option;
		
		do {
			option = mainView.mainMenu();
			switch(option) {
				case 0: // Salir
					mainView.exit();
					break;
					
				case 1: // Ver pelistelera
					List<Pelis> list = model.list();
					mainView.list(list);
					break;
					
				case 2: // Elegir película 
					Pelis pelis = mainView.add();
					model.add(pelis);
					break;
					
				case 3: // Editar lista de películas
				    List<Pelis> listForEdit = model.list(); //1.- Declaramos la variable, guardamos el resultado
				    mainView.list(listForEdit);

				    String listForEdit = mainView.selectPelis();
				    Pelis pelisForEdit = model.listfindByList(listForEdit);

				    if (pelisForEdit != null) { // Verifica si se encontró el coche
				        Pelis modifiedPelis = mainView.editPelis(pelisForEdit);
				        model.updatePelis(listForEdit, modifiedPelis); // Llama al nuevo método para actualizar
				    } else {
				        mainView.showMessage("No se encontró ninguna peli con esa nombre.");
				    }
				    break;
					
					
				case 4: // Eliminar peli de la lista propia 
					List<Pelis> listForDelete = model.list();
				    mainView.list(listForDelete); 

				    String listToDelete = mainView.selectPelisToDelete(); // Obtener la peli a eliminar
				    Pelis pelisToDelete = model.listfindByList(listToDelete); // Buscar la peli

				    if (pelisToDelete != null) { 
				        if (mainView.confirmDelete()) { 
				            model.delete(listToDelete); // Eliminar peli
				            mainView.showMessage("Peli eliminado correctamente.");
				        } else {
				            mainView.showMessage("Eliminación cancelada.");
				        }
				    } else {
				        mainView.showMessage("No se encontró ninguna peli ese nombre.");
				    }
				    break;
				    
				case 5: //Confirmar compra
					
					List<Pelis> listFor = model.list();
					File file = new File("");
					
					break;
					
					
				default:
			}
		} while (option != 0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Creamos una lista
    List<Pelis> PelisList;
    PelisList = new ArrayList<Pelis>();

    //Instanciamos y añadimos la lista de 5 frutas
    PelisList.add(new Pelis("La naranja mecánica", 1967, Stanley Kubrick, 2));
    PelisList.add(new Pelis("Amélie", 2001, Jean-Pierre Jeunet, 1.30));
    PelisList.add(new Pelis("Vértigo", 1958, Alfred Hitchcock, 1.40));
    PelisList.add(new Pelis("Con la muerte en los talones", 1959, Alfred Hitchcock, 1.20 ));
    PelisList.add(new Pelis("Cafarnaúm", 2018, Nadine Labak, 2.10));
    PelisList.add(new Pelis("Lawrence de Arabia", 1962, David Lean, 2.15));
    PelisList.add(new Pelis("M, el vampiro de Düsseldorf", 1931, Fritz Lang, 1.40));
    PelisList.add(new Pelis("Ciudadano Kane", 1940, Orson Welles, 1.42));
    PelisList.add(new Pelis("Masacre: Ven y mira", 1985, Elem Klimov, 1.21 ));
    PelisList.add(new Pelis("El truco final (El prestigio)", 2006, Christopher Nolan, 2.10));
	
	
	
	
	
	
	
}

