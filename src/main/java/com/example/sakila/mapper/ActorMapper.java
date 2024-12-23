package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Actor;

@Mapper
public interface ActorMapper {
	
	// /on/filmOne : 작품에 출연한 배우들 검색 -> searchName검색결과 
	List<Actor> selectActorListByActor(String searchName);
	
	// /on/actorOne -> actor 삭제
	int deleteActor(int actorId);

	// /on/actorOne -> actor 수정
	int updateActor(Actor actor);
	
	// /on/filmOne -> 해당 작품에 출연한 배우들 출력
	List<Actor> selectActorListByFilm(int filmId); 
	
	// /on/actorOne : actorOne 정보 출력
	Actor selectActorOne(int actorId);	
	
	// 페이징을 위해 전체 Actor 수 구하기 
	int selectActorCount(String searchWord);
	
	// /on/actorList : ActorList 출력
	List<Actor> selectActorList(Map<String, Object> map);
	
	// Actor 추가
	int insertActor(Actor actor);
}
