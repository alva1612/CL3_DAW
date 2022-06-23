package com.tutorclass.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tutorclass.demo.repository.ICarreraRepository;

@Controller
public class CarreraController {
	private ICarreraRepository repo;
	
	@GetMapping("/carreras")
	public String cargarCarreras(Model model) {
		model.addAttribute("lCarreras", repo.findAll());
		return "reservaGuillen";
		
	}
}
