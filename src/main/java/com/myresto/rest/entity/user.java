package com.myresto.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class user {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
	private String name;
	private String emailString;
	private String password;
	

}
