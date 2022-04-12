package com.baeldung.boot.jsp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
	private String isbn;
    private String name;
    private String author;
    
    public Book() {	}
    public Book(String pIsbn, String pName, String pAuthor) {
    	isbn=pIsbn;
    	name =pName;
    	author = pAuthor;
		
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
