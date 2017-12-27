package com.gora.service;

import java.util.List;

import com.gora.model.ManufacturerModel;

public interface ManufacturerService {
	
	public List<ManufacturerModel> allManufacturers();
	
	public ManufacturerModel findById(Long id);

}
