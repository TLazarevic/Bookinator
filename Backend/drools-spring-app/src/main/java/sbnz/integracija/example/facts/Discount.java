package sbnz.integracija.example.facts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Discount {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private int amount;

	public Discount() {
		super();
	};

}
