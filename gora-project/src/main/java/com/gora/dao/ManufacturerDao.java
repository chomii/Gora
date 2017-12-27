package com.gora.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gora.domain.Manufacturer;

public interface ManufacturerDao extends CrudRepository<Manufacturer, Long>{

	public List<Manufacturer> findAll();
}
