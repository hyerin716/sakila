package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Film;

@Mapper
public interface FilmMapper {
	
	// categoryId가 null이나 0이 아닐때 filmList 출력
	List<Map<String, Object>> selectFilmListByCategory(Map<String, Object> paramMap);
	
	// categorId가 null이나 0일때 filmList 출력
	List<Map<String, Object>> selectFilmList(Map<String, Object> paramMap);
	
	// /on/actorOne에서 film 검색시 사용
	List<Film> selectFilmListByTitle(String searchTitle);
	
	// leftmenu.jsp -> 영화추가
	int insertFilm(Film film);
	
	// /on/filmOne 출력 -> film X language
	Map<String, Object> selectFilmOne(int filmId);
	
	// /on/actorOne -> 출연작품 출력
	List<Film> selectFilmTitleListByActor(int actorId);
}
