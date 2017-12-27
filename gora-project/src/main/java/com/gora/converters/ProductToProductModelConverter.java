package com.gora.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gora.domain.Product;
import com.gora.model.ManufacturerModel;
import com.gora.model.ProductModel;

@Component
public class ProductToProductModelConverter implements Converter<Product, ProductModel> {
	
	@Autowired
	@Lazy
	private ConversionService manufacturerConversion;

	public ProductModel convert(Product product) {
		
		ProductModel productModel = new ProductModel();
		
		productModel.setId(product.getId());
		productModel.setName(product.getName());
		productModel.setDescription(product.getDescription());
		productModel.setPrice(product.getPrice());
		productModel.setAvailable(product.isAvailable());
		productModel.setManufacturer(manufacturerConversion.convert(product.getManufacturer(), ManufacturerModel.class));
		
		return productModel;
	}

}
