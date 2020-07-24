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
public class ProductController {
	
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}

	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct";
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String createProduct(@Validated @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct";
		}else {
			productService.createProduct(product);
			return "newProduct";
		}
	}
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.GET)
	public String showId(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("product", productService.findProduct(id));
		
		List<Category> itemCategory = categoryService.allCategory();
		
		model.addAttribute("itemCategory", itemCategory);
		
		return "adjProduct";
	}
	
	@RequestMapping(value="/create/{id}", method=RequestMethod.POST)
	public String addCategory(@Validated  @PathVariable("id") Long id, @ModelAttribute("category") Long category, Model model) {
		
		
		
		return "adjProduct";
	}
}
