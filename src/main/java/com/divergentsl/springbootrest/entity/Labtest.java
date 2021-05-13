package com.divergentsl.springbootrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "`labtest`")
public class Labtest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private long price;

	public Labtest() {
		super();
	}

	public Labtest(String name, long price) {
		super();
		this.name = name;
		this.price = price;
	}

}
