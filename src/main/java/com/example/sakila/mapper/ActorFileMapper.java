package com.example.sakila.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.ActorFile;

@Mapper
public interface ActorFileMapper {

	// /on/actorOne 
	List<ActorFile> selectActorFileListByActor(int actorId);
	
	// actor 파일 추가
	int insertActorFile(ActorFile actorFile);
}
