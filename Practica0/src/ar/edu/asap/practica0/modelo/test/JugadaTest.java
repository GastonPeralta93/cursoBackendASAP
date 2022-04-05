package ar.edu.asap.practica0.modelo.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.asap.practica0.modelo.Jugada;
import ar.edu.asap.practica0.modelo.Jugador;
import ar.edu.asap.practica0.modelo.Piedra;
import ar.edu.asap.practica0.modelo.Spock;

class JugadaTest {
	
	Jugada jugada = null;
	
	@BeforeEach
	void setUp() throws Exception {
		Jugador jug1 = new Jugador(1, "Gabriel", "papacho", new Piedra());
		Jugador jug2 = new Jugador(2, "Compu", "pc", new Spock());
		jugada = new Jugada(1, new Date(), jug1, jug2);
	}

	@AfterEach
	void tearDown() throws Exception {
		jugada = null;
	}
	
	@Test
	void testGetDescripcionDelresultado() {
		assertEquals("piedra pierde con spock", jugada.getDescripcionDelresultado());
	}
}
