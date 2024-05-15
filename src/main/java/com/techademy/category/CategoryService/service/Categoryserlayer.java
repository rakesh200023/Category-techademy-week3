package com.techademy.category.CategoryService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techademy.category.CategoryService.entity.Category;
import com.techademy.category.CategoryService.repository.CategoryRepository;

@Service
public class Categoryserlayer {
	@Autowired
	CategoryRepository crepo;

	public Category addcategory(Category cat) {
		// TODO Auto-generated method stub
		return crepo.save(cat);

	}

	public Category updateCategory(Category cat, Integer id) {
		// TODO Auto-generated method stub

		Category c = crepo.findById(id).orElseThrow();
		c.setCode(cat.getCode());
		c.setDescription(cat.getDescription());

		return crepo.save(c);

	}

	public Category getCat(Integer id) {
		// TODO Auto-generated method stub
		return crepo.findById(id).orElseThrow();
	}

	public void deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		crepo.deleteById(id);

	}

	public List<Category> getCatall() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

}
