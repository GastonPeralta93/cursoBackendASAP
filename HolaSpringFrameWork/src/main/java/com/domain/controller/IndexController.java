package com.domain.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.domain.modelo.Modelo;
import com.domain.modelo.dao.AlumnoDAO;
//import com.domain.modelo.dao.DAO;

import ar.edu.asap.practica0.modelo.PiedraPapelTijeraFactory;

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
	public String goListado(Model model) throws ClassNotFoundException, SQLException {
		
		AlumnoDAO aluDao;
		
		try {
			aluDao = new AlumnoDAO();
			List<com.domain.modelo.Modelo> alumnos = aluDao.leer(null); 	

			model.addAttribute("alumnos", alumnos);

		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		model.addAttribute("titulo", "Listado de alumnos");
		model.addAttribute("profesor", "Gabriel Casas");
		
		return "Listado";
		
	}
	
	@RequestMapping("/Juego")
	
	public String goJuego(Model model) {
		
		List<PiedraPapelTijeraFactory> opciones = new ArrayList<PiedraPapelTijeraFactory>();
		
		for (int i = 1; i < 6 ; i++) {
			
			opciones.add(PiedraPapelTijeraFactory.getInstance(i));
		}
		
		model.addAttribute("opciones", opciones);
		
		return "PiedraPapelTijera";
		
	}
	
	@RequestMapping("/Resultado")
	public String goResultado(@RequestParam(required = false) Integer selOpcion, Model model) {
		
		PiedraPapelTijeraFactory jugador = PiedraPapelTijeraFactory.getInstance(selOpcion);
		PiedraPapelTijeraFactory computadora = PiedraPapelTijeraFactory.getInstance((int)(Math.random()*5+1));
		jugador.comparar(computadora);
		
		//model.addAttribute("numero", selOpcion);
		model.addAttribute("jugador", jugador);
		model.addAttribute("computadora", computadora);
		model.addAttribute("resultado", jugador.getDescripcionResultado());
		
		return "Resultado";
	}
}
