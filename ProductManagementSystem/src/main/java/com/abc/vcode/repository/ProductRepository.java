package com.abc.vcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.vcode.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	

}
