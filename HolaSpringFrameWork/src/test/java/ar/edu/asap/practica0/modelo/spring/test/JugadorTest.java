package ar.edu.asap.practica0.modelo.spring.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.edu.asap.practica0.modelo.Auditoria;
import ar.edu.asap.practica0.modelo.Jugada;
import ar.edu.asap.practica0.modelo.Jugador;

public class JugadorTest {
	
	ClassPathXmlApplicationContext context = null;
	ClassPathXmlApplicationContext context2 = null;
	ClassPathXmlApplicationContext context3 = null;
	
	Jugador jug1 = null, jug2 = null;
	Jugada jugada = null;
	Auditoria auditoria = null;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("META-INF/juego/jugador.xml");
		context2 = new ClassPathXmlApplicationContext("META-INF/juego/jugador2.xml");
		context3 = new ClassPathXmlApplicationContext("META-INF/juego/jugada.xml");
		
		jug1 = context.getBean(Jugador.class);
		jug2 = context2.getBean(Jugador.class);
		jugada = context3.getBean(Jugada.class);
		auditoria = context3.getBean(Auditoria.class);
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		context2 = null;
		jug1 = null;
		jug2 = null;
		auditoria = null;
	}

	@Test
	public void testGetBeanAttributes() {
		assertEquals(1, jug1.getCodigo());
		assertEquals("Gabriel", jug1.getNombre());
		assertEquals("papacho", jug1.getNickname());
		assertEquals("piedra", jug1.getJugadaElegida().getNombre()); //
	}
	
	@Test
	public void testGetBeanAttributes2() {
		assertEquals(2, jug2.getCodigo());
		assertEquals("Maria", jug2.getNombre());
		assertEquals("mamasa", jug2.getNickname());
		assertEquals("spock", jug2.getJugadaElegida().getNombre());
	}
	
	@Test
	public void testAuditoriaGetCantidad() {
		jugada.getDescripcionDelresultado();
		jugada.getDescripcionDelresultado();
		jugada.getDescripcionDelresultado();
		assertEquals(3, auditoria.getCantidadJugadas());
	} 

}
