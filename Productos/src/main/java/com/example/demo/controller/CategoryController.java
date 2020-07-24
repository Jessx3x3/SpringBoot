package com.example.demo.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@Controller
public class CategoryController {

	private CategoryService categoryService;
	private Category category;
	private ProductService productService;
	
	public CategoryController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
		this.category = category;
	}

	@RequestMapping("/categorys/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCategory";
	}
	
	@RequestMapping(value="/categorys", method=RequestMethod.POST)
	public String create(@Validated @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory";
		}else {
			categoryService.createCategory(category);
			return "newCategory";
		}
	}
	
	@RequestMapping(value="/categorys/{id}", method=RequestMethod.GET)
	public String addProduct(@Validated @PathVariable("id") Long id, Model model) {
		
		model.addAttribute("category", categoryService.findCategory(id));
		
		List<Product> itemProducts = productService.allProducts();
		
		model.addAttribute("itemProducts", itemProducts);
		
		return "adjCategory";
	}
	
	@RequestMapping(value="/create/{idCategory}", method=RequestMethod.POST)
	public String addProductToCategory(@Validated @PathVariable("idCategory") Long idCategory, Model model, @ModelAttribute("product") Long product) {
		
		//categoryService.findCategory(idCategory).getProducts().add(productService.findProduct(product));
		//category.getProducts().add(productService.findProduct(product));
		
		//List<Product> productosCategoria = category.getProducts();
		
		//model.addAttribute("productosCategoria", productosCategoria);
		
		return "adjCategory";
	}
}
