package com.example.sakila.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Category;

@Mapper
public interface CategoryMapper {
	
	// on/filmList에서 category 필터링 : 카테고리 리스트 출력
	List<Category> selectCategoryList();
}
