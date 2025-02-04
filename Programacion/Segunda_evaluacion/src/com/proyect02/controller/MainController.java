package com.proyect02.controller;

import com.proyect02.model.IModel;
import com.proyect02.view.IMainView;
import com.proyect02.view.MainTerminalView;

public class MainController {
	private IModel model;
	private IMainView mainView;
	
	public MainController() {
		//this.model; 
		this.mainView = new MainTerminalView();
		
	}
	
	public void run() {
		int option = mainView.mainMenu();
		
	}
}
