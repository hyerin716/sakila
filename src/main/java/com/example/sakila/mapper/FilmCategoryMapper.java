package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.FilmCategory;

@Mapper
public interface FilmCategoryMapper {
	
	// /on//on/removeFilmCategory : filmOne에서 카테고리 삭제
	Integer deleteFilmCategory(FilmCategory filmCategory);
	
	// /on/addFilmCategory : filmOne에서 카테고리 추가
	Integer insertFilmCategory(FilmCategory filmCategory);
	
	// /on/filmOne : 특정필름의 카테고리 리스트 출력
	List<Map<String, Object>> selectFilmCategoryListByFilm(Integer filmId);
	
	// 필름 삭제 시 film_category 삭제
	Integer deleteFilmCategoryByFilm(Integer filmId);
	
	// 카테고리 삭제 시 : 11/12 pm 숙제
	Integer deleteFilmCategoryByCategory(Integer categoryId);
	
}
