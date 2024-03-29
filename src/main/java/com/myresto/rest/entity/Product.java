package com.myresto.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="products")

public class Product {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
	private String name;
	private String description;
	private String img;
	private float price;
	private boolean state;
	
	@ManyToOne
	private Category category_id;	
 
}
