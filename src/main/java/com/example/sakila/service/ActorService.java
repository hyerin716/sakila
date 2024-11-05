package com.example.sakila.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.sakila.mapper.ActorFileMapper;
import com.example.sakila.mapper.ActorMapper;
import com.example.sakila.vo.Actor;
import com.example.sakila.vo.ActorFile;
import com.example.sakila.vo.ActorForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ActorService {
	@Autowired ActorMapper actorMapper;
	@Autowired ActorFileMapper actorFileMapper;
	
	// 배우 추가
	public void addActor(ActorForm actorForm, String path) {
		Actor actor = new Actor();
		actor.setFirstName(actorForm.getFirstName());
		actor.setLastName(actorForm.getLastName());
		
		int row1 = actorMapper.insertActor(actor);
		// mybatis selectKey의 값
		int actorId = actor.getActorId();
		
		// insertActor가 성공하고 file이 있다면
		if(row1 == 1 && actorForm.getActorFile() != null) {
			// 파일 입력, ActorFile 입력
			List<MultipartFile> list = actorForm.getActorFile();
			for(MultipartFile mf: list) {
				ActorFile actorFile = new ActorFile();
				
				actorFile.setActorId(actorId);
				actorFile.setType(mf.getContentType());	//파일의 MIME 타입을 제공하는 메소드, MultipartFile 객체에서 제공하는 메소드
				actorFile.setSize(mf.getSize());	//MultipartFile 객체에서 파일의 크기(바이트 단위)를 제공하는 메소드

				// UUID.randomUUID() : 랜덤으로 생성된 고유한 UUID 객체
				// toString() : UUID 객체를 문자열로 반환
				// replace("-", "") : 문자열에서 모든 하이픈(-)을 ""로 바꾸는 메소드
				String filename = UUID.randomUUID().toString().replace("-", "");
				actorFile.setFilename(filename);
				// 마지막 점의 위치
				// getOriginalFilename() : 확장자 포함 원본 파일 이름 반환하는 메소드
				// lastIndexOf(".") : 문자열에서 주어진 문자열 "."을 가장 마지막으로 나타나는 인덱스 반환해주는 메소드
				int dotIdx = mf.getOriginalFilename().lastIndexOf(".");
				//substring(0, dotIdx) :  **beginIndex**부터 **endIndex**까지의 부분 문자열을 추출하는 메소드
				// ㄴ beginIndex는 포함되고, endIndex는 포함 x
				String originname = mf.getOriginalFilename().substring(0, dotIdx);
				actorFile.setOriginname(originname);
				// 확장자 추출
				String ext = mf.getOriginalFilename().substring(dotIdx+1);
				actorFile.setExt(ext);
				
				int row2 = actorFileMapper.insertActorFile(actorFile);
				if(row2 == 1) {
					 // 물리적 파일 저장
					 try {
						mf.transferTo(new File(path + filename +"."+ ext));
					 } catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						// 예외 발생하고 예외처리 하지 않아야지 @Transactional 작동한다
						// so... RuntimeException을 인위적으로 발생
						throw new RuntimeException();
					 }	 
				 }
						
			}
		}
		
	}
}
