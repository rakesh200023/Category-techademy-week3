package com.techademy.category.CategoryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techademy.category.CategoryService.entity.Category;
import com.techademy.category.CategoryService.service.Categoryserlayer;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	Categoryserlayer cservice;

	@PostMapping("/create/")
	public ResponseEntity<Category> Addcategory(@RequestBody Category cat) {
		Category addedcategory = cservice.addcategory(cat);
		return new ResponseEntity<Category>(addedcategory, HttpStatus.CREATED);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Category> Updatecategory(@RequestBody Category cat, @PathVariable Integer id) {
		Category updatedCategory = cservice.updateCategory(cat, id);
		return new ResponseEntity<Category>(updatedCategory, HttpStatus.OK);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Category> getcategory(@PathVariable Integer id) {
		Category receivedcat = cservice.getCat(id);
		return new ResponseEntity<Category>(receivedcat, HttpStatus.OK);
	}

	@GetMapping("/get/all")
	public ResponseEntity<List<Category>> getcategoryall() {
		List<Category> receivedcat = cservice.getCatall();
		return new ResponseEntity<List<Category>>(receivedcat, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletecategory(@PathVariable Integer id) {

		cservice.deleteCategory(id);
		return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);

	}
}
