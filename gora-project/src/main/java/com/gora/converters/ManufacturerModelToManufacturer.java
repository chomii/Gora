package com.gora.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gora.domain.Manufacturer;
import com.gora.model.ManufacturerModel;

@Component
public class ManufacturerModelToManufacturer implements Converter<ManufacturerModel, Manufacturer> {

	@Override
	public Manufacturer convert(ManufacturerModel manufacturerModel) {
		
		Manufacturer manufacturer = new Manufacturer();
		
		manufacturer.setId(manufacturerModel.getId());
		manufacturer.setName(manufacturerModel.getName());
		
		return manufacturer;
	}

}
