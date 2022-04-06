package com.domain.modelo.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.domain.modelo.Alumno;

class AlumnoDAOTest {
	AlumnoDAO 	aluDao;
	Alumno 		alumno_agregar;
	Alumno		alumno_modificar;

	@BeforeEach
	void setUp() throws Exception {
		aluDao = new AlumnoDAO();
		alumno_agregar = new Alumno(0, "Gabriel_test", "Casas_test", "gcasas@gmail.test", "universitarios_test", "http://gitlab/gcasas1972/repo.git");
		//cambiar el codigo de alumno_modificar para comprobar que ese registro es quien se actualiza
		alumno_modificar = new Alumno(4, "Gabriel_update", "Casas_update", "gcasas@gmail.update", "universitarios_update", "http://gitlab/gcasas1972/repo.update");
	}

	@AfterEach
	void tearDown() throws Exception {
		aluDao=null;
		alumno_agregar=null;
		alumno_modificar=null;
	}

	@Test
	void testAgregar() {
		try {
			aluDao.agregar(alumno_agregar);
			assertTrue(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	void testModificar() {
		try {
			aluDao.modificar(alumno_modificar);
			assertTrue(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

}

