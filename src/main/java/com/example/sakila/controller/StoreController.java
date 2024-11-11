package com.example.sakila.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.sakila.service.StoreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StoreController {
	@Autowired StoreService storeService;
	
	@GetMapping("/on/storeList")
	public String storeList(Model model) {
		List<Map<String, Object>> storeList = storeService.getStoreList();
		log.debug(storeList.toString());
		
		model.addAttribute("storeList", storeList);
		return "on/storeList";
	}
}
