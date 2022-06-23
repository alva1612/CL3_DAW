package com.tutorclass.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tutorclass.demo.model.Reserva;
import com.tutorclass.demo.repository.ICarreraRepository;
import com.tutorclass.demo.repository.IReservaRepository;

@Controller
public class ReservaController {
	@Autowired
	private ICarreraRepository repoCarrera;
	@Autowired
	private IReservaRepository repoReserva;
	
	@GetMapping("/")
	public String cargar(Model model) {
		model.addAttribute("lCarreras", repoCarrera.findAll());
		model.addAttribute("reserva",new Reserva());
		return "reservaGuillen";
		
	}
	@PostMapping("/")
	public String agregar(@ModelAttribute Reserva reserva, Model model) {
		
		try {
			repoReserva.save(reserva);
			model.addAttribute("msjSuccess", "Se ha realizado la reserva");
			model.addAttribute("reserva",reserva);
		} catch (Exception e) {
			model.addAttribute("msjError", "Error al reservar");
		}

		return "reservaGuillen";
	}
}
