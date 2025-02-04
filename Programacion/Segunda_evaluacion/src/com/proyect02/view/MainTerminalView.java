package com.proyect02.view;

import com.proyect02.utils.TerminalUtils;

public class MainTerminalView implements IMainView{
	
	@Override
	public int  mainMenu() {
		int option;
		
		TerminalUtils.output("Menú de concesionario");
		TerminalUtils.output("========================");
		
		TerminalUtils.output("1.- Listar coche");
		TerminalUtils.output("2.- Añadir coche");
		TerminalUtils.output("3.- Editar coche");
		TerminalUtils.output("4.- Eliminar coche");
		TerminalUtils.output("0.- Salir");
		
		try {
			option = TerminalUtils.inputInt();
		}catch(Exception e) {
			option = -1;
		}
		
	}
}
