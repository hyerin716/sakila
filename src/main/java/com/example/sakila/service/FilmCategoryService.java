package com.example.sakila.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sakila.mapper.FilmCategoryMapper;
import com.example.sakila.vo.FilmCategory;

@Service
public class FilmCategoryService {
	@Autowired FilmCategoryMapper filmCategoryMapper;
	
	// /on//on/removeFilmCategory : filmOne에서 카테고리 삭제
	public Integer removeFilmCategory(FilmCategory filmCategory) {
		return filmCategoryMapper.deleteFilmCategory(filmCategory);
	}
	
	// /on/addFilmCategory : filmOne에서 카테고리 추가
	public Integer addFilmCategory(FilmCategory filmCategory) {
		return filmCategoryMapper.insertFilmCategory(filmCategory);
	}
	
	// 특정필름의 카테고리 리스트 출력
	public List<Map<String, Object>> getFilmCategoryListByFilm(Integer filmId){
		return filmCategoryMapper.selectFilmCategoryListByFilm(filmId);
	}
	
}