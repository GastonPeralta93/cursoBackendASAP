package com.gabrielCode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gabrielCode.model.Persona;
import com.gabrielCode.repo.IPersonaRepo;

	@Controller
	public class DemoController {

		@Autowired
		private IPersonaRepo repo;
		
		@GetMapping("/greeting")
		public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
			
			Persona per = new Persona(1, "Gabriel Casas");
			repo.save(per);
			
			model.addAttribute("name", name);
			
			return "greeting";
		}
	}
	
