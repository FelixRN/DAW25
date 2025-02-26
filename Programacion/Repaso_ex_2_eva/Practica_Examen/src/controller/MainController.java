package controller;

import View.IMainView;
import View.MainTerminalView;
import model.IModel;
import model.ModelMemory;

public class MainController {
	
	private IModel model;
	private IMainView mainView;
	
	public MainController() {
		this.model = new ModelMemory();
		this.mainView = new MainTerminalView();
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

