package com.divergentsl.springbootrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@Column(name = "username", length = 25)
	private String username;
	@Column(name = "password")
	private String password;

	public Admin() {
		super();
	}

}
