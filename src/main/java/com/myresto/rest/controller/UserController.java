package com.myresto.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myresto.rest.Service.UserServiceImplement;
import com.myresto.rest.entity.User;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PutMapping;


@RestController()

@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserServiceImplement userService ;
	
	@GetMapping("")
	public ResponseEntity<?>getall() {
		
		try {
			return  ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
		} catch (Exception e) {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( "{\"error\":\"Error. intente mas tarde.\"}");                           
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getOne(@PathVariable Integer id) {
		
		try {
			return  ResponseEntity.status(HttpStatus.OK).body(userService.getById(id));
			
		} catch (Exception e) {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( "{\"error\":\"Error. intente mas tarde.\"}");                           
			
		}
	}
	
	@PostMapping("")
	public void save (@RequestBody User user) {
		
		
		try {	
			userService.save(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody User user){
		
		try {
			
			return  ResponseEntity.status(HttpStatus.OK).body(userService.update(user));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body( "{\"error\":\"Error. intente mas tarde.\"}");  
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>delete(@PathVariable int id){
		try {
			return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(userService.delete(id));
			
		} catch (Exception e) {
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "{\"error\":\"Error.no se pudede borrar .\"}");                           
			
		}
	}
	
	

}
