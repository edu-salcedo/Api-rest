package com.myresto.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myresto.rest.Service.ProductServiceImplement;
import com.myresto.rest.entity.Product;

import org.springframework.web.bind.annotation.PostMapping;



@RestController

@RequestMapping("product")
public class ProductController {

	@Autowired
    ProductServiceImplement productservice;
	@GetMapping("")
	public ResponseEntity<?>getall() {
		
		try {
			return  ResponseEntity.status(HttpStatus.OK).body(productservice.getAll());
		} catch (Exception e) {
			return  ResponseEntity.status(HttpStatus.OK).body("!!!erororr");
		}

	}
	
	@PostMapping("/save")
	public void save (Product product) {
		try {
			
			productservice.save(product);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
