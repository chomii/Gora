package com.gora.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gora.domain.Manufacturer;
import com.gora.model.ManufacturerModel;

@Component
public class ManufacturerToManufacturerModel implements Converter<Manufacturer, ManufacturerModel> {

	@Override
	public ManufacturerModel convert(Manufacturer manufacturer) {
		
		ManufacturerModel manufacturerModel = new ManufacturerModel();
		
		manufacturerModel.setId(manufacturer.getId());
		manufacturerModel.setName(manufacturer.getName());
		
		return manufacturerModel;
	}

}
