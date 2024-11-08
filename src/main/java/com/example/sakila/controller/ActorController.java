package com.example.sakila.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.sakila.service.ActorFileService;
import com.example.sakila.service.ActorService;
import com.example.sakila.service.FilmService;
import com.example.sakila.vo.Actor;
import com.example.sakila.vo.ActorFile;
import com.example.sakila.vo.ActorForm;
import com.example.sakila.vo.Film;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ActorController {
	@Autowired ActorService actorService;
	@Autowired ActorFileService actorFileService;
	@Autowired FilmService filmService;
	
	// actorOne : actor 삭제
	@GetMapping("/on/removeActor")
	public String removeActor(HttpSession session, @RequestParam int actorId) {
		String path = session .getServletContext().getRealPath("/upload/");
		actorService.removeActor(actorId, path);
		return "redirect:/on/actorList";
	}
	
	// actorOne 수정 : modifyActor.jsp에서 받아오기
	@PostMapping("/on/modifyActor")
	public String modifyActor(Actor actor) {
		log.debug(actor.toString());
		
		int row = actorService.modifyActor(actor);
		return "redirect:/on/actorOne?actorId=" + actor.getActorId();
	}
	
	// actorOne 수정 -> modifyActor.jsp로 보내기
	@GetMapping("/on/modifyActor")
	public String modifyActor(Model model, @RequestParam int actorId) {
		// 원래 정보(actorOne) 보여줘야함
		Actor actor = actorService.getActorOne(actorId);
		model.addAttribute("actor", actor);
		
		log.debug(actor.toString()); // 디버깅
		
		return "on/modifyActor";
	}
	
	// actorOne 상세페이지 출력
	@GetMapping("/on/actorOne")
	public String actorOne(Model model
								, @RequestParam int actorId
								, @RequestParam(defaultValue = "") String searchTitle) {	
		//searchWord = "" 이면 actorOne 상세보기 요청이고, ""이 아니면 film 검색 요청
		Actor actor = actorService.getActorOne(actorId);
		// actor file 출력
		List<ActorFile> actorFileList = actorFileService.getActorFileListByActor(actorId);
		// /on/actorOne -> 출연작품 출력
		List<Film> filmList = filmService.getFilmTitleListByActor(actorId);
		//filmList -> 이미 내출연작
		
		log.debug(actor.toString());
		log.debug(actorFileList.toString());
		log.debug(filmList.toString());
		
		// searchTitle이 있다면 -> film 검색시 불러오는 filmList 출력
		if(!searchTitle.equals("")) {	//searchTitle가 공백이 아니라면 (film 제목 검색어가 있다면)
			// film 검색결과를 리스트에 추가
			List<Film> searchFilmList = filmService.getFilmListByTitle(searchTitle);
			model.addAttribute("searchFilmList", searchFilmList);
			// searchFilmList -> film 을 추가하기위해서 출력하는 리스트
		}
		
		model.addAttribute("actor", actor);
		model.addAttribute("actorFileList", actorFileList);
		model.addAttribute("filmList", filmList);
		
		return "on/actorOne";
	}
	
	
	// actor list 출력
	@GetMapping("/on/actorList")
	public String actorList(Model model
							,@RequestParam(defaultValue = "1") int currentPage
							, @RequestParam(defaultValue = "10") int rowPerPage
							, @RequestParam(required = false) String searchWord) {	
		log.debug("searchWord: "+ searchWord);
		
		// 라스트페이지까지 구해서 가져오기
		int lastPage = actorService.getLastPage(rowPerPage, searchWord);
		log.debug("lastPage: " + lastPage);	// 디버깅	
		model.addAttribute("lastPage", lastPage);
		
		List<Actor> actorList = actorService.getActorList(currentPage, rowPerPage, searchWord);
		model.addAttribute("actorList", actorList);

		model.addAttribute("searchWord", searchWord);
		
		return "on/actorList";
	}
	
	
	@PostMapping("/on/addActor")
	public String addActor(HttpSession session, Model model, ActorForm actorForm) {	// input type="file"
		// 디버깅
		log.debug(actorForm.getFirstName());
		log.debug(actorForm.getLastName());
		log.debug("actorFile : " + actorForm.getActorFile());
		if(actorForm.getActorFile() != null) {
			log.debug("actorFile size" + actorForm.getActorFile().size());
		}

		// 이미지 파일만 등록 가능하도록
		List<MultipartFile> list = actorForm.getActorFile();
		if(list != null && list.size() != 0) {	// 첨부된 파일이 있다면
			for(MultipartFile f : list) {	// 이미지파일은 *.jpg or *.png 가능
				if(f.getContentType().equals("image/jpeg") == false
						&& f.getContentType().equals("image/png") == false) {
					model.addAttribute("msg", "이미지 파일만 입력이 가능합니다.");
					return "on/addActor";
				}
			}
		}	
		
		String path = session.getServletContext().getRealPath("/upload/");
		log.debug(path);
		actorService.addActor(actorForm, path);	// -> ActorService
		
		return "redirect:/on/actorList";
	}
	
	
	@GetMapping("/on/addActor")
	public String addActor() {
		return "on/addActor";
	}
	
}
