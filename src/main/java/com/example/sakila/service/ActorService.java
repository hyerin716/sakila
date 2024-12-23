package com.example.sakila.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.sakila.mapper.ActorFileMapper;
import com.example.sakila.mapper.ActorMapper;
import com.example.sakila.mapper.FilmActorMapper;
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
	@Autowired FilmActorMapper filmActorMapper;
	
	// /on/filmOne : 작품에 출연한 배우들 검색 -> searchName검색결과 
	public List<Actor> getActorListByActor(String searchName) {
		return actorMapper.selectActorListByActor(searchName);
	}
	
	// /on/removeActor : /on/actrOne에서 actor 삭제
	public void removeActor(int actorId, String path) {
		// 1) film_actor 삭제(없다면 삭제x (없을 수도 있다))
		filmActorMapper.deleteFilmByActor(actorId);
		// 2) actor_file 삭제
		List<ActorFile> list = actorFileMapper.selectActorFileListByActor(actorId);	// 물리적 삭제하기 위해서 file 이름들 삭제전에 list에 담아두기
		actorFileMapper.deleteActorFileByActor(actorId);
		// 3) actor 삭제
		int row = actorMapper.deleteActor(actorId);
		// 4) 물리적 파일 삭제
		if(row == 1 && list != null && list.size() > 0) { //actor 삭제했고 물리적 파일 존재한다면
			for(ActorFile af : list) {
				String fullname = path + af.getFilename() + "." + af.getExt();
				File f = new File(fullname);
				f.delete();
			}
		}
		
	}
	
	// /on/modifyActor : on/actorOne -> actor 수정
	public int modifyActor(Actor actor) {
		return actorMapper.updateActor(actor);
	}
	
	// /on/filmOne -> 해당 작품에 출연한 배우들 출력
	public List<Actor> getActorListByFilm(int filmId) {
		return actorMapper.selectActorListByFilm(filmId);
	}
	
	// /on/actorOne -> actorOne 정보 출력
	public Actor getActorOne(int actorId) {
		return actorMapper.selectActorOne(actorId);
	}
	
	// 라스트페이지 구하기
	public int getLastPage(int rowPerPage, String searchWord) {
		int count = actorMapper.selectActorCount(searchWord);
		int lastPage = count / rowPerPage;
		if(count % rowPerPage !=0 ) {
			lastPage++;
		}
		System.out.println("카운트" + count);
		System.out.println("로퍼페이지" + rowPerPage);
		System.out.println("라스트페이지계산 count / rowPerPage " + count / rowPerPage);
		System.out.println("라스트페이지" + lastPage);
		return lastPage;
	}
	
	// /on/actorList : ActorList 출력
	public List<Actor> getActorList(int currentPage, int rowPerPage, String searchWord) {
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = (currentPage-1) * rowPerPage;
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		paramMap.put("searchWord", searchWord);
		
		
		return actorMapper.selectActorList(paramMap);
	}
	
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
