package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Film;

@Mapper
public interface FilmMapper {
	
	// leftmenu.jsp -> 영화추가
	int insertFilm(Film film);
	
	// /on/filmOne 출력 -> film X language
	Map<String, Object> selectFilmOne(int filmId);
	
	// /on/actorOne -> 출연작품 출력
	List<Film> selectFilmTitleListByActor(int actorId);
}
