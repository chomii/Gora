package com.gora.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gora.domain.Manufacturer;
import com.gora.domain.Product;
import com.gora.model.ProductModel;

@Component
public class ProductModelToProductConverter implements Converter<ProductModel, Product> {
	
	@Autowired
	@Lazy
	private ConversionService manufacturerConv;
	
	public Product convert(ProductModel productModel) {
		Product product = new Product();
		
		product.setId(productModel.getId());
		product.setName(productModel.getName());
		product.setDescription(productModel.getDescription());
		product.setPrice(productModel.getPrice());
		product.setAvailable(productModel.isAvailable());
		product.setManufacturer(manufacturerConv.convert(productModel.getManufacturer(), Manufacturer.class));
				
		return product;
	}

}
