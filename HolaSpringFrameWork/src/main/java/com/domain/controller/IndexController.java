package com.domain.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.asap.practica0.modelo.Lizard;
import ar.edu.asap.practica0.modelo.Papel;
import ar.edu.asap.practica0.modelo.Piedra;
import ar.edu.asap.practica0.modelo.PiedraPapelTijeraFactory;
import ar.edu.asap.practica0.modelo.Spock;
import ar.edu.asap.practica0.modelo.Tijera;

@Controller
public class IndexController {

	@RequestMapping("/home")
	public String goIndex() {
		return "Index";
	}
	
	@RequestMapping("/")
	public String goPresentacion() {
		return "Presentacion";
	}
	
	@RequestMapping("/Listado")
	public String goListado(Model model) {
		List<String> alumnos = new ArrayList<String>();
		alumnos.add("Juan");
		alumnos.add("Pedro");
		alumnos.add("José");
		
		model.addAttribute("titulo", "Listado de alumnos");
		model.addAttribute("profesor", "Gabriel Casas");
		model.addAttribute("alumnos", alumnos);
		
		return "Listado";
	}
	
	@RequestMapping("/Juego")
	public String goJuego(Model model) {
		List<PiedraPapelTijeraFactory> opciones = new ArrayList<PiedraPapelTijeraFactory>();
		opciones.add(new Piedra());
		opciones.add(new Papel());
		opciones.add(new Tijera());
		opciones.add(new Spock());
		opciones.add(new Lizard());
		
		model.addAttribute("opciones", opciones);		
		
		return "PiedraPapelTijera"; 
	}
	
	@RequestMapping("/Resultado")
	public String goResultado(@RequestParam(required = false) String selOpciones, Model model) {
		
		PiedraPapelTijeraFactory jugador = null;
		
		switch (selOpciones) {
		case "1-piedra":
			jugador = new Piedra();	
			break;
		case "2-papel":
			jugador = new Papel();	
			break;
		case "3-tijera":
			jugador = new Tijera();	
			break;
		case "4-spock":
			jugador = new Lizard();	
			break;
		case "5-lizard":
			jugador = new Spock();	
			break;
		default:
			break;		
		}					
		
		PiedraPapelTijeraFactory computadora = PiedraPapelTijeraFactory.getInstance((int)(Math.random()*100%5)+1);		
		int elganadores = jugador.comparar(computadora);
		
		String mensaje = null;
		
		switch (elganadores) {
		case 1:
			mensaje = "El jugador humano gana, la maquina eligió " + computadora;
			break;
			
		case -1:
			mensaje = "El jugador humano pierde, la maquina eligió " + computadora;
			break;
			
		case 0:
			mensaje = "El jugador humano empata, la maquina eligió " + computadora;
			break;
		} 
		
		model.addAttribute("mensaje", mensaje);	
		
		return "Resultado"; 
	}
}
