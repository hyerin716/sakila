package com.example.sakila.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Language;

@Mapper
public interface LanguageMapper {
	
	// /on/addLanguage : 언어추가
	Integer insertLanguage(Language language);
	
	// /on/addFilm -> language 선택에 필요, /on/languageList 출력 필요
	List<Language> selectLanguageList();
}
