package com.gora.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gora.domain.Product;

@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors err) {
		
		//Product product = (Product)obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "name", "", "Name cannot be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "description", "", "Description cannot be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "price", "", "Price cannot be empty");
		
		
	}

}
