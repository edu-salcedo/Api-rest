package com.myresto.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myresto.rest.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer >  {
                                       
}
