package com.example.sakila.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sakila.mapper.LanguageMapper;
import com.example.sakila.vo.Language;

@Service
@Transactional
public class LanguageService {
	@Autowired LanguageMapper languageMapper;
	
	// /on/addLanguage : 언어추가
	public int addLanguage(Language language) {
		return languageMapper.insertLanguage(language);
	}
	
	// /on/addFilm -> language 선택에 필요, /on/languageList 출력 필요
	public List<Language> getLanguageList() {
		return languageMapper.selectLanguageList();
	}
}
