package com.techademy.category.CategoryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techademy.category.CategoryService.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
