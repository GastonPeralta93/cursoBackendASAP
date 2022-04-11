package com.gabrielCode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gabrielCode.repository.IPersona;

@Service

public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	@Qualifier("persona2")
	IPersona repo;
	
	@Override
	public void registrarHandler(String pNombre) {
		repo.registrar(pNombre);
	}
}
