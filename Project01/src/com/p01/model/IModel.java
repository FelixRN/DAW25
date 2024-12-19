package com.p01.model;

import java.util.List;

import com.p01.model.entities.Book;

public interface IModel {
	List<Book> list();
	Book add(String isbn, String title);
}
