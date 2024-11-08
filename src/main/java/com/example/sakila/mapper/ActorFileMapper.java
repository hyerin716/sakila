package com.example.sakila.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.ActorFile;

@Mapper
public interface ActorFileMapper {
	
	// [Service]에서 필요, on/removeActorFile
	ActorFile selectActorFileOne(int actorFileId);
	
	// /on/removeActorFile
	int deleteActorFile(int actorFileId);
	
	// /on/actorOne -> actor file 출력
	List<ActorFile> selectActorFileListByActor(int actorId);
	
	// actor 파일 추가
	int insertActorFile(ActorFile actorFile);
}
