package com.myresto.rest.entity;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Categories")
public class Category {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "category")
	private List<Product>listProduct;
}
