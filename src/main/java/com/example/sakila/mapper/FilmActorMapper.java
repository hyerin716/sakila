package com.example.sakila.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.FilmActor;

@Mapper
public interface FilmActorMapper {
	
	// 필름 삭제 시 film_actor들 삭제
	Integer deleteFilmActorByFilm(int filmId);
	
	// /on/actrOne에서 actor 삭제 시 -> 출연작들을 삭제(film_actor)
	int deleteFilmByActor(int actorId); // Integer deleteFilmActorByActor(int actorId)
	
	// actorOne에서 필름 삭제
	// filmOne에서 액터 삭제
	int deleteFilmActor(FilmActor filmActor);
	
	// actorOne에서 필름 추가(film_actor 추가) /on/addFilmActorByActor
	// filmOne에서 액터 추가(film_actor 추가)	/on/addFilmActorByFilm
	int insertFilmActor(FilmActor filmActor);
}
