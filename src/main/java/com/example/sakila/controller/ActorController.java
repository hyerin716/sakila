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
	
	// actorOne 수정
	@GetMapping("/on/modifyActor")
	public String modifyActor(Model model, @RequestParam int actorId) {
		Actor actor = actorService.getModifyActor(actorId);
		log.debug(actor.toString()); // 디버깅
		
		model.addAttribute("actor", actor);
		
		return "on/modifyActor";
	}
	
	// actorOne 상세페이지 출력
	@GetMapping("/on/actorOne")
	public String actorOne(Model model, 
								@RequestParam int actorId) {
		Actor actor = actorService.getActorOne(actorId);
		// actor file 출력
		List<ActorFile> actorFileList = actorFileService.getActorFileListByActor(actorId);
		
		List<Film> filmList = filmService.getFilmTitleListByActor(actorId);
		
		log.debug(actor.toString());
		log.debug(actorFileList.toString());
		log.debug(filmList.toString());
		
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
