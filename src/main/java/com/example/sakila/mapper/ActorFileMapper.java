package com.example.sakila.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.ActorFile;

@Mapper
public interface ActorFileMapper {
	
	// [Service]에서 필요, on/removeActorFile -> 물리적 파일 삭제하기 위해서 filename, 확장자 구하는 메서드
	ActorFile selectActorFileOne(int actorFileId);
	
	// /on/removeActorFile : actorOne.jsp에서 actor_file 삭제
	int deleteActorFile(int actorFileId);
	
	// /on/actorOne -> actor file 출력
	List<ActorFile> selectActorFileListByActor(int actorId);
	
	// actor 파일 추가
	int insertActorFile(ActorFile actorFile);
}
