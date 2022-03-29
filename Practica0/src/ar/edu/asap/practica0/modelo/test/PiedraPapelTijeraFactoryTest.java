package ar.edu.asap.practica0.modelo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.asap.practica0.modelo.Lizard;
import ar.edu.asap.practica0.modelo.Papel;
import ar.edu.asap.practica0.modelo.Piedra;
import ar.edu.asap.practica0.modelo.PiedraPapelTijeraFactory;
import ar.edu.asap.practica0.modelo.Spock;
import ar.edu.asap.practica0.modelo.Tijera;

class PiedraPapelTijeraFactoryTest {
	Piedra piedra;
	Papel papel;
	Tijera tijera;
	Spock spock;
	Lizard lizard;	

	@BeforeEach
	void setUp() throws Exception {
		piedra = new Piedra();
		papel = new Papel();
		tijera = new Tijera();
		spock = new Spock();
		lizard = new Lizard();
	}

	@AfterEach
	void tearDown() throws Exception {
		piedra = null;
		papel = null;
		tijera = null;
		spock = null;
		lizard = null;
	}

	@Test
	void testPapelEmpataAPapel() {
		assertEquals(0, papel.comparar(papel));
	}
	
	@Test
	void testPapelEmpataAPapel_comparar_DescripcionResultado() {
		int result=papel.comparar(papel);
		assertEquals("papel empata con papel", papel.getDescripcionResultado());
	}	
	
	@Test
	void testPapelGanaAPiedra() {
		assertEquals(1, papel.comparar(piedra));
	}
	
	@Test
	void testPapelGanaAPiedra_comparar_DescripcionResultado() {
		int result=papel.comparar(piedra);
		assertEquals("papel le gana a piedra", papel.getDescripcionResultado());
	}
	
	@Test
	void testPapelGanaASpock() {
		assertEquals(1, papel.comparar(spock));
	}
	
	@Test
	void testPapelGanaASpock_comparar_DescripcionResultado() {
		int result=papel.comparar(spock);
		assertEquals("papel le gana a spock", papel.getDescripcionResultado());
	}
	
	@Test
	void testPapelPierdeATijera() {
		assertEquals(-1, papel.comparar(tijera));
	}
	
	@Test
	void testPapelPierdeATijera_comparar_DescripcionResultado() {
		int result=papel.comparar(tijera);
		assertEquals("papel pierde con tijera", papel.getDescripcionResultado());
	}
	
	@Test
	void testPapelPierdeALizard() {
		assertEquals(-1, papel.comparar(lizard));
	}
	
	@Test
	void testPapelPierdeALizard_comparar_DescripcionResultado() {
		int result=papel.comparar(lizard);
		assertEquals("papel pierde con lizard", papel.getDescripcionResultado());
	}
	
	@Test
	void testPiedraEmpataAPiedra() {
		assertEquals(0, piedra.comparar(piedra));
	}
	
	@Test
	void testPiedraEmpataAPiedra_comparar_DescripcionResultado() {
		int result=piedra.comparar(piedra);
		assertEquals("piedra empata con piedra", piedra.getDescripcionResultado());
	}
	
	@Test
	void testPiedraGanaATijera() {
		assertEquals(1, piedra.comparar(tijera));
	}
	
	@Test
	void testPiedraGanaATijera_comparar_DescripcionResultado() {
		int result=piedra.comparar(tijera);
		assertEquals("piedra le gana a tijera", piedra.getDescripcionResultado());
	}
	
	@Test
	void testPiedraGanaALizard() {
		assertEquals(1, piedra.comparar(lizard));
	}
	
	@Test
	void testPiedraGanaALizard_comparar_DescripcionResultado() {
		int result=piedra.comparar(lizard);
		assertEquals("piedra le gana a lizard", piedra.getDescripcionResultado());
	}
	
	@Test
	void testPiedraPierdeAPapel() {
		assertEquals(-1, piedra.comparar(papel));
	}
	
	@Test
	void testPiedraPierdeAPapel_comparar_DescripcionResultado() {
		int result=piedra.comparar(papel);
		assertEquals("piedra pierde con papel", piedra.getDescripcionResultado());
	}
	
	@Test
	void testPiedraPierdeASpock() {
		assertEquals(-1, piedra.comparar(spock));
	}
	
	@Test
	void testPiedraPierdeASpock_comparar_DescripcionResultado() {
		int result=piedra.comparar(spock);
		assertEquals("piedra pierde con spock", piedra.getDescripcionResultado());
	}
	
	@Test
	void testTijeraEmpataATijera() {
		assertEquals(0, tijera.comparar(tijera));
	}
	
	@Test
	void testTijeraEmpataATijera_comparar_DescripcionResultado() {
		int result=tijera.comparar(tijera);
		assertEquals("tijera empata con tijera", tijera.getDescripcionResultado());
	}		
	
	@Test
	void testTijeraGanaAPapel() {
		assertEquals(1, tijera.comparar(papel));
	}
	
	@Test
	void testTijeraGanaAPapel_comparar_DescripcionResultado() {
		int result=tijera.comparar(papel);
		assertEquals("tijera le gana a papel", tijera.getDescripcionResultado());
	}
	
	@Test
	void testTijeraGanaALizard() {
		assertEquals(1, tijera.comparar(lizard));
	}
	
	@Test
	void testTijeraGanaALizard_comparar_DescripcionResultado() {
		int result=tijera.comparar(lizard);
		assertEquals("tijera le gana a lizard", tijera.getDescripcionResultado());
	}
	
	@Test
	void testTijeraPierdeAPiedra() {
		assertEquals(-1, tijera.comparar(piedra));
	}
	
	@Test
	void testTijeraPierdeAPiedra_comparar_DescripcionResultado() {
		int result=tijera.comparar(piedra);
		assertEquals("tijera pierde con piedra", tijera.getDescripcionResultado());
	}
	
	@Test
	void testTijeraPierdeASpock() {
		assertEquals(-1, tijera.comparar(spock));
	}
	
	@Test
	void testTijeraPierdeASpock_comparar_DescripcionResultado() {
		int result=tijera.comparar(spock);
		assertEquals("tijera pierde con spock", tijera.getDescripcionResultado());
	}
	
	@Test
	void testLizardEmpataALizard() {
		assertEquals(0, lizard.comparar(lizard));
	}
	
	@Test
	void testLizardEmpataALizard_comparar_DescripcionResultado() {
		int result=lizard.comparar(lizard);
		assertEquals("lizard empata con lizard", lizard.getDescripcionResultado());
	}		
	
	@Test
	void testLizardGanaASpock() {
		assertEquals(1, lizard.comparar(spock));
	}
	
	@Test
	void testLizardGanaASpock_comparar_DescripcionResultado() {
		int result=lizard.comparar(spock);
		assertEquals("lizard le gana a spock", lizard.getDescripcionResultado());
	}
	
	@Test
	void testLizardGanaAPapel() {
		assertEquals(1, lizard.comparar(papel));
	}
	
	@Test
	void testLizardGanaAPapel_comparar_DescripcionResultado() {
		int result=lizard.comparar(papel);
		assertEquals("lizard le gana a papel", lizard.getDescripcionResultado());
	}
	
	@Test
	void testLizardPierdeAPiedra() {
		assertEquals(-1, lizard.comparar(piedra));
	}
	
	@Test
	void testLizardPierdeAPiedra_comparar_DescripcionResultado() {
		int result=lizard.comparar(piedra);
		assertEquals("lizard pierde con piedra", lizard.getDescripcionResultado());
	}
	
	@Test
	void testLizardPierdeATijera() {
		assertEquals(-1, lizard.comparar(tijera));
	}
	
	@Test
	void testLizardPierdeATijera_comparar_DescripcionResultado() {
		int result=lizard.comparar(tijera);
		assertEquals("lizard pierde con tijera", lizard.getDescripcionResultado());
	}
	
	@Test
	void testSpockEmpataASpock() {
		assertEquals(0, spock.comparar(spock));
	}
	
	@Test
	void testSpockEmpataASpock_comparar_DescripcionResultado() {
		int result=spock.comparar(spock);
		assertEquals("spock empata con spock", spock.getDescripcionResultado());
	}		
	
	@Test
	void testSpockGanaATijera() {
		assertEquals(1, spock.comparar(tijera));
	}
	
	@Test
	void testSpockGanaATijera_comparar_DescripcionResultado() {
		int result=spock.comparar(tijera);
		assertEquals("spock le gana a tijera", spock.getDescripcionResultado());
	}
	
	@Test
	void testSpockGanaAPiedra() {
		assertEquals(1, spock.comparar(piedra));
	}
	
	@Test
	void testSpockGanaAPiedra_comparar_DescripcionResultado() {
		int result=spock.comparar(piedra);
		assertEquals("spock le gana a piedra", spock.getDescripcionResultado());
	}
	
	@Test
	void testSpockPierdeAPapel() {
		assertEquals(-1, spock.comparar(papel));
	}
	
	@Test
	void testSpockPierdeAPapel_comparar_DescripcionResultado() {
		int result=spock.comparar(papel);
		assertEquals("spock pierde con papel", spock.getDescripcionResultado());
	}
	
	@Test
	void testSpockPierdeALizard() {
		assertEquals(-1, spock.comparar(lizard));
	}
	
	@Test
	void testSpockPierdeALizard_comparar_DescripcionResultado() {
		int result=spock.comparar(lizard);
		assertEquals("spock pierde con lizard", spock.getDescripcionResultado());
	}
	
	@Test
	void testGetInstance_piedra() {
		assertEquals("piedra", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.PIEDRA).getNombre());				
	}

	@Test
	void testGetInstance_papel() {
		assertEquals("papel", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.PAPEL).getNombre());				
	}

	@Test
	void testGetInstance_tijera() {
		assertEquals("tijera", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.TIJERA).getNombre());				
	}	
	
	@Test
	void testGetInstance_spock() {
		assertEquals("spock", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.SPOCK).getNombre());				
	}	
	
	@Test
	void testGetInstance_lizard() {
		assertEquals("lizard", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.LIZARD).getNombre());				
	}	
}
