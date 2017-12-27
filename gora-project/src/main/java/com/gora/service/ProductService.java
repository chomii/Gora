package com.gora.service;

import java.util.List;

import com.gora.model.ProductModel;

public interface ProductService {

	public void saveProduct(ProductModel productModel);

	public List<ProductModel> listAllProducts();

	public ProductModel findById(Long id);

	public void updateProduct(ProductModel productModel);

	public void deleteProduct(String id);
}
