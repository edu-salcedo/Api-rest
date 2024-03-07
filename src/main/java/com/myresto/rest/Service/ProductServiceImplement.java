package com.myresto.rest.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myresto.rest.entity.Product;
import com.myresto.rest.repository.ProductRepository;

import jakarta.transaction.Transactional;
@Service
public class ProductServiceImplement  implements ProductServiceInterface{
 
	@Autowired
	ProductRepository productrepository;
	
	@Override
	@Transactional
	public List<Product> getAll() throws Exception {
		
		try {
		   List<Product>list = productrepository.findAll();
		   return list;	
		} catch (Exception e) {
            throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public Product save(Product product) throws Exception {
	
		try {
		    product = productrepository.save(product);	
			return product;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public Product getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return productrepository.getReferenceById(id);
	}

	@Override
	public Optional<Product> get(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Product product) throws Exception {
		productrepository.save(product);
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		productrepository.deleteById(id);;
		
	}

}
