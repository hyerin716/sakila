package com.example.sakila.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sakila.mapper.FilmMapper;
import com.example.sakila.vo.Film;

@Service
@Transactional
public class FilmService {
	@Autowired FilmMapper filmMapper;
	
	// filmOne 출력
	public Map<String, Object> getFilmOne(int filmId) {
		return filmMapper.selectFilmOne(filmId);
	}
	
	
	// /on/actorOne -> 출연작품 출력
	public List<Film>  getFilmTitleListByActor(int actorId){
		return filmMapper.selectFilmTitleListByActor(actorId);
	}
}
