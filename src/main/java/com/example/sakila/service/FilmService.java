package com.example.sakila.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sakila.mapper.FilmActorMapper;
import com.example.sakila.mapper.FilmCategoryMapper;
import com.example.sakila.mapper.FilmMapper;
import com.example.sakila.vo.Film;
import com.example.sakila.vo.FilmForm;

@Service
@Transactional
public class FilmService {
	@Autowired FilmMapper filmMapper;
	@Autowired FilmCategoryMapper filmCategoryMapper;
	@Autowired FilmActorMapper filmActorMapper;
	
	// film 수정 : /on/modifyFilm : on/filmOne
	public void modifyFilm(Film film) {
		filmMapper.updateFilm(film);
	}
	
	// film 삭제
	public void removeFilmByKey(Integer filmId) {
		
		// 1) film_category 삭제
		filmCategoryMapper.deleteFilmCategoryByFilm(filmId);
		// 2) film_actor 삭제
		filmActorMapper.deleteFilmActorByFilm(filmId);
		// 3) film 삭제
		filmMapper.deleteFilmByKey(filmId);
		
	}
	
	// filmList 출력
	public List<Map<String, Object>> getFilmList(Integer categoryId, int currentPage, int rowPerPage) {
		
		Map<String, Object> paramMap = new HashMap<>();
		if(categoryId == null || categoryId == 0) {
			paramMap.put("categoryId", null);
		} else {
			paramMap.put("categoryId", categoryId);
		}
		int beginRow = (1-currentPage) * rowPerPage;
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		
		if(paramMap.get("categoryId") == null) {
			return filmMapper.selectFilmList(paramMap);
		} else {
			return filmMapper.selectFilmListByCategory(paramMap);
		}
	}
	
	// /on/actorOne에서 film 검색시 불러오는 filmList
	public List<Film> getFilmListByTitle(String searchTitle) {
		return filmMapper.selectFilmListByTitle(searchTitle);
	}
	
	// addFilm 영화추가
	public int addFilm(FilmForm filmForm) {
		Film film = new Film();
		// FilmForm ---> Film
		film.setTitle(filmForm.getTitle());
		if(filmForm.getDescription().equals("")) {
			film.setDescription(null);
		} else {
			film.setDescription(filmForm.getDescription());
		}
		// 삼항연산자 사용하면
		// film.setDescription(filmForm.getDescription().equals("") ? null : filmForm.getDescription());
		
		film.setReleaseYear(filmForm.getReleaseYear());
		film.setLanguageId(filmForm.getLanguageId());
		film.setOriginalLanguageId(filmForm.getOriginalLanguageId());
		film.setRentalDuration(filmForm.getRentalDuration());
		film.setRentalRate(filmForm.getRentalRate());
		film.setLength(filmForm.getLength());
		film.setReplacementCost(filmForm.getReplacementCost());
		film.setRating(filmForm.getRating());
		
		if(filmForm.getSpecialFeatures() == null) {
			film.setSpecialFeatures(null);
		} else {
			// specialFeatures 배열 -> ,문자열 
			String specialFeatures = filmForm.getSpecialFeatures().get(0);
			
			for(int i=1; i < filmForm.getSpecialFeatures().size(); i++) {
				specialFeatures += "," + filmForm.getSpecialFeatures().get(i);
			}
			film.setSpecialFeatures(specialFeatures);
		}
		
		
		return filmMapper.insertFilm(film);
	}
	
	// filmOne 출력
	public Map<String, Object> getFilmOne(int filmId) {
		return filmMapper.selectFilmOne(filmId);
	}
	
	
	// /on/actorOne -> 출연작품 출력
	public List<Film> getFilmTitleListByActor(int actorId){
		return filmMapper.selectFilmTitleListByActor(actorId);
	}
}
