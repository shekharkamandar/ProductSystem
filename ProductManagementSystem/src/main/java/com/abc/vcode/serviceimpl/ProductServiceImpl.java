package com.abc.vcode.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.vcode.model.Product;
import com.abc.vcode.repository.ProductRepository;
import com.abc.vcode.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;
	
	@Override
	public Product saveProduct(Product product) {
		
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepo.findAll();
	}

	@Override
	public Product updateProduct(int id, Product newEntity) {
		
		Optional<Product> prod=productRepo.findById(id);
		
		Product availableEntity=null;
		
		if(prod.isPresent()) {
			
			availableEntity=prod.get();
		}
		if(availableEntity!=null) {
			if(newEntity.getProductPrice()!=0) {
				availableEntity.setProductPrice(newEntity.getProductPrice());
			}
		}
		
		productRepo.save(availableEntity);
		return availableEntity;
		
	}

	@Override
	public void deleteProduct(int id) {
		
		productRepo.deleteById(id);
		
	}

	@Override
	public Optional<Product> getProductById(int id) {
		
		return productRepo.findById(id);
	}
	

}
