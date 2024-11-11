package com.example.sakila.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sakila.service.LanguageService;
import com.example.sakila.vo.Language;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LanguageController {
	@Autowired LanguageService languageService;
	
	@GetMapping("/on/addLanguage")
	public String addLanguage(Model model) {
		
		return "on/addLanguage";
	}
	
	@PostMapping("/on/addLanguage")
	public String addLanguage(Language language) {
		log.debug(language.toString());
		int row = languageService.addLanguage(language);
		
		if(row == 0) {
			return "on/addLanguage";
		}
		return "redirect:/on/languageList";
	}
	
	
	@GetMapping("/on/languageList")
	public String languageList(Model model) {
		List<Language> languageList = languageService.getLanguageList();
		log.debug("languageList: "+ languageList);
		
		model.addAttribute("languageList", languageList);
		
		return "on/languageList";				
		
	}
}
