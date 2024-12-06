package com.example.sakila.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sakila.service.CategoryService;
import com.example.sakila.vo.Category;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CategoryController {
	@Autowired CategoryService categoryService;
	
	// addCategory : 카테고리 추가
	@GetMapping("/on/addCategory")
	public String addCategory(Model model) {
		
		return "on/addCategory";
	}
	// addCategory : 카테고리 추가
	@PostMapping("/on/addCategory")
	public String addCategory(Category category) {
		log.debug("category: ", category);
		int row = categoryService.addCategory(category);
		
		if(row == 0) {
			return "on/addCategory";
		}
		
		return "redirect:/on/categoryList";		
	}
	
	// categoryList : 카테고리 리스트 출력
	@GetMapping("/on/categoryList")
	public String categoryList(Model model) {
		
		List<Category> categoryList = categoryService.getCategoryList();
		log.debug("categoryList: " + categoryList);	// 디버깅	
		
		model.addAttribute("categoryList", categoryList);
		
		return "on/categoryList";
	}
	
}
