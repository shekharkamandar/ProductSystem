package com.abc.vcode.service;

import java.util.List;
import java.util.Optional;

import com.abc.vcode.model.Product;

public interface ProductService {
	
	public Product saveProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Product updateProduct(int id,Product newProduct);
	
	public void deleteProduct(int id);

	public Optional<Product> getProductById(int id);

}
