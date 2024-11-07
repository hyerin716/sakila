package com.example.sakila.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ActorForm { 
	private int actorId;
	private String firstName;
	private String lastName;
	private List<MultipartFile> actorFile;
	
}

/* addActorFile에서 필요, 이렇게 하나더 클래스를 생성하던지 위에처럼 재사용하던지
public class ActorFileForm { 
	private int actorId;
	private List<MultipartFile> actorFile;
	
}
*/