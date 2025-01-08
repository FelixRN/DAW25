package com.p01.model.repository;

import java.util.List;

import com.p01.model.IModel;
import com.p01.model.entities.Book;

public class ModelDatabase implements IModel {

	@Override
	public List<Book> list() {
		return null;
	}

	@Override
	public Book add(String isbn, String title) {
		return null;
	}
}
