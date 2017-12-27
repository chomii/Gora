package com.gora.model;

public class ProductModel {

	private Long id;
	
	private String name;
	private String description;
	private Double price;
	private boolean available;
	private ManufacturerModel manufacturer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public ManufacturerModel getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerModel manufacturer) {
		this.manufacturer = manufacturer;
	}

	

	
	

}
