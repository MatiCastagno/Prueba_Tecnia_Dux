package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Partido;
import com.example.demo.services.PartidoService;

@Controller
@RequestMapping("")
public class MainController {

	
	@Autowired
	private PartidoService Pservi;
	
	@GetMapping("")
	public String index() {
		
		return "index";
	}
	
	@PostMapping("/createPartido")
	public String create(ModelMap model, String torneo, String nombre1,  String nombre2, Integer cant_sets, Integer p_J1, Integer p_J2) {
		
				
			Partido partido = Pservi.create(torneo, nombre1, nombre2, cant_sets, p_J1, p_J2);
			
			model.put("exito", "PARTIDO CREADO CON EXITO!!");
			model.put("id_partido", partido.getId());


		return "index";
	}
	
	
	@GetMapping("/arrancarPartido/{id}")
	public String arrancarPartido(@PathVariable("id") String id, ModelMap model) {
		
		Partido partido = Pservi.arrancarPartido(id);
		
		ArrayList<Integer> listJ1 = partido.getLista_Sets_J1();
		ArrayList<Integer> listJ2 = partido.getLista_Sets_J2();
		
		model.put("partido", partido);
		model.put("j1", partido.getSets_J1());
		model.put("j2", partido.getSets_J2());
		model.put("listaJ1", listJ1);
		model.put("listaJ2", listJ2);
		
		return "partido";
	}
	
}
