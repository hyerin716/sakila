package com.example.sakila.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.sakila.service.ActorFileService;
import com.example.sakila.vo.ActorForm;

import jakarta.servlet.http.HttpSession;

@Controller
public class ActorFileController {
	@Autowired ActorFileService actorFileService;
	
	@GetMapping("/on/addActorFile")
	public String addActorFile(Model model, @RequestParam int actorId) {
		model.addAttribute("actorId", actorId);
		return "on/addActorFile";
	}
	
	@PostMapping("/on/addActorFile")
	public String addActorFile(HttpSession session, /*Model model,*/ ActorForm actorForm) {
		/*List<MultipartFile> list = actorForm.getActorFile();
		for(MultipartFile f :list) {
			if(f.getContentType().equals("imgage/jpeg") == false) {
				model.
			}
		}*/
		
		String path= session.getServletContext().getRealPath("/upload/");
		actorFileService.addActorFile(actorForm, path);
		return "redirect:/on/actorOne?actorId="+ actorForm.getActorId();
	}
}

