package com.gora.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.gora.domain.Product;

public interface ProductDao extends CrudRepository<Product, Long>{

	
	
	public List<Product> findAll();

	public Product findById(Long id);

}
