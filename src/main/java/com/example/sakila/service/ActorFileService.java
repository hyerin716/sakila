package com.example.sakila.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.sakila.mapper.ActorFileMapper;
import com.example.sakila.vo.ActorFile;
import com.example.sakila.vo.ActorForm;

@Service
@Transactional
public class ActorFileService {
	@Autowired ActorFileMapper actorFileMapper;
	
	// /on/removeActorFile -> actorOne.jsp에서 actor_file 삭제
	// 1) actor_file 삭제, 2) 물리 파일 삭제(이름이 필요, 경로PATH 필요)
	public void removeActorFile(int actorFileId, String path) {
		// 1) 파일이름 select
		ActorFile actorFile = actorFileMapper.selectActorFileOne(actorFileId); // 물리적 파일 삭제하기 위해서 filename, 확장자 구하는 메서드
		int row = actorFileMapper.deleteActorFile(actorFileId);
		if(row == 1) {	// actor_file 정보 삭제가 되었다면 물리적 파일삭제
			String fullname = path + actorFile.getFilename() + "." + actorFile.getExt();	// 삭제하고자 하는 파일 풀네임
			File f = new File(fullname);	// 없으면 새로 만들어지고 있으면 기존 파일과 연결한다
			f.delete();
		}
		
	}
	
	// /on/addActorFile
	public void addActorFile(ActorForm actorForm, String path) {
		 if(actorForm.getActorFile() != null) {
			 // 파일 입력, ActorFile 입력
			 List<MultipartFile> list = actorForm.getActorFile();
			 for(MultipartFile mf : list) {
				 ActorFile actorFile = new ActorFile();
				 
				 actorFile.setActorId(actorForm.getActorId());
				 actorFile.setType(mf.getContentType());
				 actorFile.setSize(mf.getSize());
				 String filename = UUID.randomUUID().toString().replace("-", "");
				 actorFile.setFilename(filename);
				 int dotIdx = mf.getOriginalFilename().lastIndexOf(".");
				 String originname = mf.getOriginalFilename().substring(0, dotIdx);
				 String ext = mf.getOriginalFilename().substring(dotIdx+1);
				 actorFile.setOriginname(originname);
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
	
	// /on/actorOne -> actor file 출력
	public List<ActorFile> getActorFileListByActor(int actorId) {
		return actorFileMapper.selectActorFileListByActor(actorId);
	}
}
