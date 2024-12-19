package com.p01.model.entities;

public class Book {
	private int id;
	private String isbn;
	private String title;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toTerminalTable() {
		return this.id + "\t" + this.isbn + "\t"+ this.title;
	}

	public static String toTerminalTableHeader() {
		return "id\tisbn\ttitle";
	}

	public String toTerminalCreation() {
		return "Libro creado: con id" + this.id + "; isbn " + this.isbn + ", titulo "+ this.title;
	}
}
