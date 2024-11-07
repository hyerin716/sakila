package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Actor;

@Mapper
public interface ActorMapper {

	// //on/actorOne -> actor 수정
	Actor modifyActor(int actorId);
	
	// /on/filmOne -> 해당 작품에 출연한 배우들 출력
	List<Actor> selectActorListByFilm(int filmId); 
	
	// /on/actorOne
	Actor selectActorOne(int actorId);	
	
	// 페이징을 위해 전체 Actor 수 구하기 
	int selectActorCount(String searchWord);
	
	// ActorList 출력
	List<Actor> selectActorList(Map<String, Object> map);
	
	// Actor 추가
	int insertActor(Actor actor);
}
