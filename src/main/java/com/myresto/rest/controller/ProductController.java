package com.myresto.rest.controller;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myresto.rest.Service.ProductServiceImplement;
import com.myresto.rest.entity.Product;

import ch.qos.logback.classic.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController

@RequestMapping("product")
public class ProductController {

	@Autowired
    ProductServiceImplement productservice;
	
	private final Logger LOGGER= (Logger) LoggerFactory.getLogger(ProductController.class);
	@GetMapping("")
	public ResponseEntity<?>getall() {
		
		try {
			return  ResponseEntity.status(HttpStatus.OK).body(productservice.getAll());
		} catch (Exception e) {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( "{\"error\":\"Error. intente mas tarde.\"}");                           
		}

	}
	@GetMapping("/{id}")
	public ResponseEntity<?>getOne(@PathVariable Integer id) {
		
		try {
			return  ResponseEntity.status(HttpStatus.OK).body(productservice.getById(id));
			
		} catch (Exception e) {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( "{\"error\":\"Error. intente mas tarde.\"}");                           
			
		}
	}
	
	@PostMapping("")
	public void save (@RequestBody Product product) {
		LOGGER.info("producto {}",product);
		
		try {	
			productservice.save(product);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?>  update(@PathVariable int id, @RequestBody Product product) {
		
		try {
			return  ResponseEntity.status(HttpStatus.OK).body(productservice.update(product));
			
		} catch (Exception e) {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( "{\"error\":\"Error. intente mas tarde.\"}");                           
			
		}
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>delete(@PathVariable int id){
		try {
			return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(productservice.delete(id));
			
		} catch (Exception e) {
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "{\"error\":\"Error.no se pudede borrar .\"}");                           
			
		}
	}
	
}
