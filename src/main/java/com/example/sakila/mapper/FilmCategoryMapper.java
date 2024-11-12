package com.example.sakila.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FilmCategoryMapper {
	// 필름 삭제 시 film_category 삭제
	Integer deleteFilmCategoryByFilm(int filmId);
	
	// 카테고리 삭제 시 : 11/12 pm 숙제
	Integer deleteFilmCategoryByCategory(int categoryId);
	
}
