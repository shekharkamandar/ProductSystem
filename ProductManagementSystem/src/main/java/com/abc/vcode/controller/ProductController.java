package com.abc.vcode.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.vcode.model.Product;
import com.abc.vcode.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product productRequest){
		
		Product saveprod=productservice.saveProduct(productRequest);
		return ResponseEntity.ok().body(saveprod);
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id")int id){
		
		Optional<Product> pro=productservice.getProductById(id);
		
		if(pro.isPresent()) {
			return new ResponseEntity<>(pro.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity(null,HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getAllProduct(){
		
		List<Product> listProduct=productservice.getAllProduct();
		return new ResponseEntity<>(listProduct,HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable("id")int id,@RequestBody Product newEntity) {
		
		return productservice.updateProduct(id, newEntity);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id")int id){
		
		Optional<Product> prod= productservice.getProductById(id);
		if(prod.isPresent()) {
			productservice.deleteProduct(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	

}
