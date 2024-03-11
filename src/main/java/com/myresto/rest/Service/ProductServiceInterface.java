package com.myresto.rest.Service;

import java.util.List;
import java.util.Optional;

import com.myresto.rest.entity.Product;


public interface ProductServiceInterface {
	
   public List<Product> getAll() throws Exception;
   public Product save( Product product) throws Exception;
   public Product getById(Integer id)throws Exception;
   public Optional<Product> get(Integer id)throws Exception;
   public Product update(Product product)throws Exception;
   public boolean delete(Integer id)throws Exception;

}
