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
import com.example.sakila.service.FilmCategoryService;
import com.example.sakila.service.FilmService;
import com.example.sakila.service.InventoryService;
import com.example.sakila.service.LanguageService;
import com.example.sakila.vo.Actor;
import com.example.sakila.vo.Category;
import com.example.sakila.vo.Film;
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
	@Autowired InventoryService invenService;
	@Autowired FilmCategoryService filmCategoryService;
	
	// 필름 수정
	@PostMapping("/on/modifyFilm")
	public String modifyFilm(Film film) {
		log.debug(film.toString());
		
		filmService.modifyFilm(film);
		return "redirect:/on/filmOne?filmId=" + film.getFilmId();
	}
	
	// 필름 수정 -> modifyFilm.jsp로 보내기
	@GetMapping("/on/modifyFilm")
	public String modifyFilm(Model model, @RequestParam Integer filmId) {
		// 원래 정보(filmOne) 보여줘야함
		Map<String, Object> film = filmService.getFilmOne(filmId);
		model.addAttribute("film", film);
		
		log.debug(film.toString());
		
		return "on/modifyFilm";
	}
	
	// 필름 삭제
	@GetMapping("/on/removeFilm")
	public String removeFilm(Model model
								, @RequestParam Integer filmId) {
		// 필름 삭제 시 : inventory-rental 정보 확인하기 위해서
		// 필름이 인벤토리에 등록되어 있다면 삭제 불가
		Integer count = invenService.getCountInventoryByFilm(filmId);
		
		if(count != 0) {
			/* 메세지 추가 할려면 ...  but 중복코드 리팩토링 이슈발생 */
			
			// filmOne 정보 출력
			Map<String, Object> film = filmService.getFilmOne(filmId);
			log.debug(film.toString());
			
			// 해당 필름에 출연한 배우들 출력
			List<Actor> actorList = actorService.getActorListByFilm(filmId);
			
			model.addAttribute("film", film);
			model.addAttribute("actorList", actorList);
			model.addAttribute("removeFilmMsg", "film이 inventory에 존재합니다");
			
			return "on/filmOne";
			
			// return "redirect:/on/filmOne"; // 메세지 추가가 힘든 구현
		}
		
		filmService.removeFilmByKey(filmId);
		
		return "redirect:/on/filmList";
	}
	
	// 필름 리스트 출력
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
						, @RequestParam int filmId
						, @RequestParam(required = false) String searchName) {
		
		/*
		 * + 1) 현재 필름 정보
		 * + 2) 전체 카테고리 리스트
		 * +  3) 현재필름의 카테고리 리스트
		 * 4) 검색 배우 리스트(searchName이 null 이 아닐때)
		 * + 5) 현재필름의 배우 리스트 
		*/
		
		// 1) 현재 filmOne 정보 출력
		Map<String, Object> film = filmService.getFilmOne(filmId);
		log.debug(film.toString());	//디버깅
		
		// 2) 전체 카테고리 리스트
		List<Category> allCategoryList = categoryService.getCategoryList();
		
		// 3) 현재필름의 카테고리 리스트
		List<Map<String, Object>> filmCategoryList = filmCategoryService.getFilmCategoryListByFilm(filmId);
		
		// 5) filmOne-> 해당 작품에 출연한 배우들 출력
		List<Actor> actorList = actorService.getActorListByFilm(filmId);
		
		model.addAttribute("film", film); // 1)
		model.addAttribute("allCategoryList", allCategoryList); // 2)
		model.addAttribute("filmCategoryList", filmCategoryList); // 3)
		
		
		
		model.addAttribute("actorList", actorList); // 5)
		
		return "on/filmOne";
	}
	
	
	
}
