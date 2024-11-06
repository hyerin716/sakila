package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Actor;

@Mapper
public interface ActorMapper {
	// 페이징을 위해 전체 Actor 수 구하기 
	int selectActorCount(String searchWord);
	
	// ActorList 출력
	List<Actor> selectActorList(Map<String, Object> map);
	
	int insertActor(Actor actor);
}
