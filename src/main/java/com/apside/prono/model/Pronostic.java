package com.apside.prono.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pronostic")
public class Pronostic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

}
