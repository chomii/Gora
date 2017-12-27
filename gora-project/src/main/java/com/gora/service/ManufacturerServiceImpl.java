package com.gora.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.gora.dao.ManufacturerDao;
import com.gora.domain.Manufacturer;
import com.gora.model.ManufacturerModel;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	
	@Autowired
	private ManufacturerDao manufacturerDao;
	
	@Autowired
	private ConversionService conversionService;

	@Override
	public List<ManufacturerModel> allManufacturers() {
		List<Manufacturer> allManufacturers = manufacturerDao.findAll();
		List<ManufacturerModel> allManufacturersModel = new ArrayList<>();
		
		for(Manufacturer manufacturer : allManufacturers) {
			allManufacturersModel.add(conversionService.convert(manufacturer, ManufacturerModel.class));
		}
		

		return allManufacturersModel;
	}

	@Override
	public ManufacturerModel findById(Long id) {
		ManufacturerModel manufacturer;
		
		manufacturer = conversionService.convert(manufacturerDao.findOne(id), ManufacturerModel.class);
		return manufacturer;
	}

}
