package com.example.sakila.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sakila.service.FilmActorService;
import com.example.sakila.vo.FilmActor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FilmActorController {
	@Autowired FilmActorService filmActorService;
	
	// actorOne에서 필름 삭제
	@GetMapping("/on/removeFilmActor")
	public String removeFilmActor(FilmActor filmActor) {
		log.debug("filmId: " + filmActor.getFilmId());
		log.debug("actorId: " + filmActor.getActorId());
		
		int row = filmActorService.removeFilmActor(filmActor);
		
		return "redirect:/on/actorOne?actorId=" + filmActor.getActorId();
	}
	
	
	// actorOne에서 필름 추가
	@PostMapping("/on/addFilmByActor")
	public String addFilmByActor(FilmActor filmActor) {
		
		log.debug("filmId: " + filmActor.getFilmId());
		log.debug("actorId: " + filmActor.getActorId());
		
		int row = filmActorService.addFilmActor(filmActor);
		
		return "redirect:/on/actorOne?actorId=" + filmActor.getActorId();
	}
}
