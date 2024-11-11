package com.example.sakila.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sakila.service.ActorService;
import com.example.sakila.service.CategoryService;
import com.example.sakila.service.FilmService;
import com.example.sakila.service.LanguageService;
import com.example.sakila.vo.Actor;
import com.example.sakila.vo.Category;
import com.example.sakila.vo.FilmForm;
import com.example.sakila.vo.Language;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FilmController {
	@Autowired FilmService filmService;
	@Autowired ActorService actorService;
	@Autowired LanguageService languageService;
	@Autowired CategoryService categoryService;
	
	@GetMapping("/on/filmList")
	public String filmList(Model model
							, @RequestParam(required = false) Integer categoryId	//required = false: 요청에 이 파라미터가 없더라도 오류가 발생하지 않고 null 들어감
							, @RequestParam(defaultValue = "1") int currentPage
							, @RequestParam(defaultValue = "10") int rowPerPage) {
		log.debug("categoryId: " + categoryId);
		log.debug("currentPage: " + currentPage);
		log.debug("rowPerPage: " + rowPerPage);
		
		List<Map<String, Object>> filmList = filmService.getFilmList(categoryId, currentPage, rowPerPage);
		log.debug("filmList: "+filmList);
		model.addAttribute("filmList", filmList);
		
		// Model에 category List 추가
		List<Category> categoryList = categoryService.getCategoryList();
		log.debug("categoryList: "+categoryList);
		model.addAttribute("categoryList", categoryList);
		
		// 같이 넘겨야 모델값 현재페이지, 현재카테고리ID
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("currentCategoryId", categoryId);
		
		return "on/filmList";
	}
	
	// leftMenu -> 영화추가(addFilm.jsp)
	@PostMapping("/on/addFilm")
	public String addFilm(FilmForm filmForm) {
		log.debug(filmForm.toString());
		
		// filmService : FilmForm -> Film
		filmService.addFilm(filmForm);
		
		return "redirect:/on/filmList";
	}
	
	
	// leftMenu -> 영화추가(addFilm.jsp) 
	//				-> language 선택필요 languageList 같이 넘김
	@GetMapping("/on/addFilm")
	public String addFilm(Model model) {
		// languageList 필요
		List<Language> languageList = languageService.getLanguageList();
		log.debug(languageList.toString());	//디버깅
		model.addAttribute("languageList", languageList);
		return "on/addFilm";
	}
	
	// filmOne 페이지 출력
	@GetMapping("/on/filmOne")
	public String filmOne(Model model
						, @RequestParam int filmId) {
		// filmOne 정보 출력
		Map<String, Object> film = filmService.getFilmOne(filmId);
		log.debug(film.toString());	//디버깅
		
		// filmOne-> 해당 작품에 출연한 배우들 출력
		List<Actor> actorList = actorService.getActorListByFilm(filmId);
		
		model.addAttribute("film", film);
		model.addAttribute("actorList", actorList);
		
		return "on/filmOne";
	}
	
	
	
}
