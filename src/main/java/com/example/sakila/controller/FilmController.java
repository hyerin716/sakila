package com.example.sakila.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.sakila.service.FilmService;

@Controller
public class FilmController {
	@Autowired FilmService filmService;
	
	
	
}
