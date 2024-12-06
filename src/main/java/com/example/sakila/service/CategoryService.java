package com.example.sakila.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sakila.mapper.CategoryMapper;
import com.example.sakila.vo.Category;

@Service
@Transactional
public class CategoryService {
	@Autowired CategoryMapper categoryMapper;
	
	// /on/addCategory : 카테고리 추가
	public Integer addCategory(Category category) {
		return categoryMapper.insertCategory(category);
	}
	
	// /on/categoryList : 카테고리 리스트 출력
	// on/filmList에서 category 필터링 : 카테고리 리스트 출력
	public List<Category> getCategoryList() {
		return categoryMapper.selectCategoryList();
	}
}
