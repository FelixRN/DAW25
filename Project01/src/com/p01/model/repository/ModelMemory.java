package com.p01.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.p01.model.IModel;
import com.p01.model.entities.Book;

public class ModelMemory implements IModel {
	private int idCounter;
	private List<Book> bookList;
	
	public ModelMemory() {
		idCounter = 1;
		bookList = new ArrayList<Book>();
	}

	@Override
	public List<Book> list() {
		return bookList;
	}

	@Override
	public Book add(String isbn, String title) {
		Book book = new Book();
		book.setId(idCounter);
		book.setIsbn(isbn);
		book.setTitle(title);
		bookList.add(book);
		idCounter++;
		return book;
	}
}
