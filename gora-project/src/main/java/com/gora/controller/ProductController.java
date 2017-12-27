package com.gora.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gora.model.ManufacturerModel;
import com.gora.model.ProductModel;
import com.gora.service.ManufacturerService;
import com.gora.service.ProductService;
import com.gora.validation.ProductValidator;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	
	@Autowired
	public ProductValidator productValidator;
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		
		//trimming whitespace off every string
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String showAdminPage(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		response.sendRedirect(request.getContextPath() + "/listAllProducts");
		return null;
	}

	@RequestMapping(value = "/addNewProduct")
	public String showNewProductPage(Model model) {

		List<ManufacturerModel> manufacturerList = manufacturerService.allManufacturers();
		
		model.addAttribute("manufacturerList", manufacturerList);
		model.addAttribute("product", new ProductModel());
		model.addAttribute("manufacturer", new ManufacturerModel());
		return "newProduct";
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveNewProduct(@ModelAttribute("product") ProductModel productModel, BindingResult result,
			Model model, HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		productValidator.validate(productModel, result);

		if (result.hasErrors()) {
			model.addAttribute("hasErrors", true);
			System.out.println("Greska u upisu");
			return "newProduct";
		}
		
		productService.saveProduct(productModel);
		response.sendRedirect(request.getContextPath() + "/listAllProducts");
		return null;
	}
	
	@RequestMapping(value="/listAllProducts", method=RequestMethod.GET)
	public String listAllProduct(Model model) {
		
		List<ProductModel> allProducts = productService.listAllProducts();
		 
		model.addAttribute("allProductsList", allProducts);
		return "admin";
	}
	
	@GetMapping(value="/updateProduct/{id}")
	public String getProductToUpdate(@ModelAttribute("product") ProductModel productModel, 
			@PathVariable String id, Model model) {
		
		List<ManufacturerModel> manufacturerList = manufacturerService.allManufacturers();
		
		ProductModel productToUpdate = productService.findById(Long.parseLong(id));
		model.addAttribute("product", productToUpdate);
		model.addAttribute("manufacturerList", manufacturerList);
		return "newProduct";
		
	}
	@PostMapping("/updateProduct/saveProduct")
	public String updateProduct(@Valid @ModelAttribute("product") ProductModel productModel, 
			BindingResult bindingResult, Model model, HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("hasErros", true);
			System.out.println("greska u unosu");
			return "newProduct";
		}
		productService.updateProduct(productModel);
		response.sendRedirect(request.getContextPath() + "/listAllProducts");
		return null;
	}
	@GetMapping(value="deleteProduct/{id}")
	public String getProductToDelete(@ModelAttribute("product") ProductModel productModel, 
			@PathVariable String id, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		productService.deleteProduct(id);
		response.sendRedirect(request.getContextPath() + "/listAllProducts");
		return null;
	}
	
//	@GetMapping(value="")
//	public String populateManufacturer() {
//		
//		List<ManufacturerModel> allManufacturers = manufacturerService.allManufacturers();
//		return null;
//	}
	

}
