package sbnz.integracija.example.facts;

import java.io.Serializable;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class Book implements Serializable , Comparable< Book >{
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private double rating;
	@Column
	private int avaivableNo;
	
	private double searchMatch=0;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Book(Long id) {
		this.id=id;
	}

	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", rating=" + rating + ", avaivableNo=" + avaivableNo + "]";
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getAvaivableNo() {
		return avaivableNo;
	}
	public void setAvaivableNo(int avaivableNo) {
		this.avaivableNo = avaivableNo;
	}
	public double getMatch() {
		return searchMatch;
	}
	public void setMatch(double match) {
		this.searchMatch = match;
	}
	
    @Override
    public int compareTo(Book b) {
        return Double.compare(this.getMatch(), b.getMatch());
    }
}
