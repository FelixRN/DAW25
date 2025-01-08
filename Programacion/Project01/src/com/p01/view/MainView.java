package com.p01.view;

import java.util.List;

import com.p01.controller.BookController;
import com.p01.model.entities.Book;
import com.p01.utils.TerminalUtils;

public class MainView {
	private BookController bookController;
	
	public MainView() {
		bookController = new BookController();
	}
	
	// Example
	public void hello() {
		TerminalUtils.output("Hola mundo desde el Main View!");

		TerminalUtils.output("Introduce un texto");
		String text = TerminalUtils.inputText();
		TerminalUtils.output("El valor introducido es: " + text);
	}
	
	public void run() {
		int option;
		do {
			TerminalUtils.output("Menú de librería");
			TerminalUtils.output("================");

			TerminalUtils.output("1.- Listar libros");
			TerminalUtils.output("2.- Añadir libro");
			TerminalUtils.output("0.- Salir");
			
			try {
				option = TerminalUtils.inputInt();
			} catch (Exception e) {
				option = -1;
			}
			
			switch(option) {
				case 0: // Salir
					TerminalUtils.output("Adios");
					break;
				case 1: // Listar libros
					TerminalUtils.output("Lista de libros");
					List<Book> books = bookController.list();
					TerminalUtils.output(Book.toTerminalTableHeader());
					for(Book book : books) {
						TerminalUtils.output(book.toTerminalTable());
					}
					break;
				case 2: // Añadir libro
					TerminalUtils.output("Añadir libro");
					TerminalUtils.output("Introduce titulo");
					String title = TerminalUtils.inputText();
					TerminalUtils.output("Introduce isbn");
					String isbn = TerminalUtils.inputText();
					Book book = bookController.add(isbn, title);
					TerminalUtils.output("Valida que los datos esten bien");
					TerminalUtils.output(book.toTerminalCreation());
					TerminalUtils.output("Si los datos estan incorrectos entra en la opcion 3");
					break;
				default:
					TerminalUtils.output("No ha introducido una opción correcta");
			}
		}
		while(option != 0);
	}
}
