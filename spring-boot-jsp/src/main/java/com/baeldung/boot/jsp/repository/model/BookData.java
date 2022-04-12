package com.baeldung.boot.jsp.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookData {
	private String isbn;
    private String name;
    private String author;
    
    public BookData() {	}
	public BookData(String pIsbn, String pName, String pAuthor) {
    	isbn=pIsbn;
    	name = pName;
    	author =pAuthor;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	

}
