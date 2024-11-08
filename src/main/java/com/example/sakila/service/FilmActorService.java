package com.example.sakila.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sakila.mapper.FilmActorMapper;
import com.example.sakila.vo.FilmActor;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class FilmActorService {
	@Autowired FilmActorMapper filmActorMapper;
	
	
	// actorOne에서 필름 삭제
	public int removeFilmActor(FilmActor filmActor) {
		return filmActorMapper.deleteFilmActor(filmActor);
	}
	
	
	// actorOne에서 필름 추가(film_actor 추가)
	public int addFilmActor(FilmActor filmActor) {
		return filmActorMapper.insertFilmActor(filmActor);
	}
}
