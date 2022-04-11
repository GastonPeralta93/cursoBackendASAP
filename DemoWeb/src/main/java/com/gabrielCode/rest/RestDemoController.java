package com.gabrielCode.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielCode.model.Persona;
import com.gabrielCode.repo.IPersonaRepo;

@RestController
@RequestMapping("/personas")
public class RestDemoController {
	
    @Autowired
    private IPersonaRepo repo;
	
	@GetMapping()
	public List<Persona> listar() {
		return repo.findAll();
	}
	
	@PostMapping()
	public void insertar(@RequestBody Persona per) {
		Persona persona = new Persona(per.getCodigo(), per.getNombre());
		repo.save(persona);
	}
	
	@PutMapping(path="/{id}")
	public void modificar(@PathVariable("id") Integer id, @RequestBody Persona per) {
		Optional<Persona> persona = repo.findById(id);
		if(!persona.isPresent()) {
			System.out.println("No hay persona");
		}
		else {
			
		Persona newPersona = persona.get();
		newPersona.setNombre(per.getNombre());
		repo.save(newPersona);
		}
	}
	
	@DeleteMapping(value ="/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
}