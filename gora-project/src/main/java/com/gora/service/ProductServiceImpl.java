package com.gora.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gora.dao.ProductDao;
import com.gora.domain.Product;
import com.gora.model.ProductModel;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ConversionService conversionService;

	
	@Autowired
	private ProductDao productDao;

	@Transactional
	@Override
	public void saveProduct(ProductModel productModel) {
	
		productDao.save(conversionService.convert(productModel, Product.class));
	}

	@Transactional
	@Override
	public List<ProductModel> listAllProducts() {
		
		List<Product> allProducts = productDao.findAll();
		List<ProductModel> allProductModels = new ArrayList<>();
		for(Product product : allProducts) {
			allProductModels.add(conversionService.convert(product, ProductModel.class));
		}
		
		return allProductModels;
	}

	@Transactional
	@Override
	public ProductModel findById(Long id) {
		
		ProductModel productToFind = conversionService.convert(productDao.findById(id), ProductModel.class);
		return productToFind;
	}

	@Transactional
	@Override
	public void updateProduct(ProductModel productModel) {
		
		productDao.save(conversionService.convert(productModel, Product.class));
		
	}

	@Transactional
	@Override
	public void deleteProduct(String id) {
		
		productDao.delete(Long.parseLong(id));
	}




}
