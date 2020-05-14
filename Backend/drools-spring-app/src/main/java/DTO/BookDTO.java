package DTO;

import java.util.ArrayList;
import java.util.HashMap;

import sbnz.integracija.example.facts.Book;
import sbnz.integracija.example.facts.BookTag;

public class BookDTO {

	private Long id;
	private ArrayList<BookTag> tags = new ArrayList<>();
	
	public BookDTO(Long id, ArrayList<BookTag> tags) {
		super();
		this.id = id;
		this.tags = tags;
	}

	public BookDTO() {
		super();
	}
	
	public BookDTO(Book b) {
		this.id = b.getId();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public ArrayList<BookTag> getTags() {
		return tags;
	}

	public void setTags(ArrayList<BookTag> tags) {
		this.tags = tags;
	}


	
	
}
