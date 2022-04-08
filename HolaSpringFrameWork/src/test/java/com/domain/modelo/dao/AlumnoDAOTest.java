package com.domain.modelo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.domain.modelo.Alumno;
import com.domain.modelo.Modelo;
import com.domain.modelo.dao.AlumnoDAO;
import com.domain.util.ConnectionManager;

class AlumnoDAOTest {
	AlumnoDAO 	aluDao;
	
	Alumno 		alumnoAgregar;
	Alumno 		alumnoEliminar;
	Alumno 		alumnoModificar;
	Alumno 		alumnoLeerCod;
	Alumno 		alumnoLeerNom;

	Connection 	con;
	Statement 	stm;
	ResultSet   rs;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		ConnectionManager.conectar();
		Connection con = ConnectionManager.getConection();
		
	    Statement consulta= con.createStatement();
	
	    String sql = "";
	    BufferedReader bf = new BufferedReader( new InputStreamReader( AlumnoDAOTest.class.getResource( "AlumnosCrear.sql" ).openStream() ) );
	    while ( (sql = bf.readLine()) != null ) {
	       if ( sql.trim().length() != 0 &&
	            !sql.startsWith( "--" ) ) {              
	          consulta.executeUpdate( sql );
	       }
	    }
	    ConnectionManager.desconectar();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

		ConnectionManager.conectar();
		Connection con = ConnectionManager.getConection();
		
	    Statement consulta= con.createStatement();
	
	    String sql = "";
	    BufferedReader bf = new BufferedReader( new InputStreamReader( AlumnoDAOTest.class.getResource( "AlumnosEliminar.sql" ).openStream() ) );
	    while ( (sql = bf.readLine()) != null ) {
	       if ( sql.trim().length() != 0 &&
	            !sql.startsWith( "--" ) ) {              
	          consulta.executeUpdate( sql );
	       }
	    }
	    ConnectionManager.desconectar();
	}

	
	
	@BeforeEach
	void setUp() throws Exception {
		aluDao = new AlumnoDAO();
		
		//el alumno a agregar
		alumnoAgregar = new Alumno(0, "Gabriel_test", "Casas_test", "gcasas@gmail.test", "universitarios_test", "http://gitlab/gcasas1972/repo.git");
		
		ConnectionManager.conectar();
	    con = ConnectionManager.getConection();
	    stm = con.createStatement();
	    
	   //el alumno a modificar
	    StringBuilder sql = new StringBuilder("select ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL,  ALU_CONOCIMIENTOS , ALU_GIT ");
					    			sql.append(" From alumnos ");
					    			sql.append(" Where alu_nombre='Marina_test'");
	    			
	    rs  = stm.executeQuery(sql.toString());
	    if(rs.next())
		    alumnoModificar= new Alumno(rs.getInt("ALU_ID"), 
		    							rs.getString("ALU_NOMBRE"), 
										rs.getString("ALU_APELLIDO"), 
										rs.getString("ALU_EMAIL"), 
										rs.getString("ALU_CONOCIMIENTOS"),
										rs.getString("ALU_GIT") );
	    
		//el alumno a eliminar
	    sql = new StringBuilder("Select ALU_ID FROM ALUMNOS WHERE ALU_NOMBRE ='Monsef_test' ");	    
	    rs  = stm.executeQuery(sql.toString());
	    if(rs.next())
	    	alumnoEliminar = new Alumno(rs.getInt("ALU_ID"));
	    
		//leer por codigo
	    sql = new StringBuilder("select ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL,  ALU_CONOCIMIENTOS , ALU_GIT ");
		sql.append(" From alumnos ");
		sql.append(" Where alu_nombre='Aarn_test'");
		
	    
	    rs  = stm.executeQuery(sql.toString());
	    rs.next();

	    alumnoLeerCod= new Alumno(	rs.getInt("ALU_ID"), 
									rs.getString("ALU_NOMBRE"), 
									rs.getString("ALU_APELLIDO"), 
									rs.getString("ALU_EMAIL"), 
									rs.getString("ALU_CONOCIMIENTOS"),
									rs.getString("ALU_GIT") );
	    
		//leer por nombre
	    sql = new StringBuilder("select ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL,  ALU_CONOCIMIENTOS , ALU_GIT ");
		sql.append(" From alumnos ");
		sql.append(" Where alu_nombre='Ivn_test'");
		
	    rs  = stm.executeQuery(sql.toString());
	    rs.next();

	    alumnoLeerNom= new Alumno(	0, 
									rs.getString("ALU_NOMBRE"), 
									rs.getString("ALU_APELLIDO"), 
									rs.getString("ALU_EMAIL"), 
									rs.getString("ALU_CONOCIMIENTOS"),
									rs.getString("ALU_GIT") );    
	}

	@AfterEach
	void tearDown() throws Exception {
		aluDao=null;
		alumnoAgregar=null;
		alumnoEliminar=null;
		alumnoModificar=null;
		alumnoLeerCod=null;
		alumnoLeerNom=null;
		
		con = null;
		stm = null;
		rs = null;
	}

	@Test
	void testLeerTodosLosAlumnos() {
		System.out.println("alumnoAgregar=" + alumnoAgregar);
		System.out.println("alumnoEliminar=" + alumnoEliminar);
		System.out.println("alumnoModificar=" + alumnoModificar);
		System.out.println("alumnoLeerCod=" + alumnoLeerCod);
		System.out.println("alumnoLeerNom=" + alumnoLeerNom);
	
		assertNotNull(alumnoAgregar);
		assertNotNull(alumnoEliminar);
		assertNotNull(alumnoModificar);
		assertNotNull(alumnoLeerCod);
		assertNotNull(alumnoLeerNom);
	}
	
	@Test
	void testAgregar() {
		try {
			aluDao.agregar(alumnoAgregar);
			Alumno aluLeido = null;
			
			StringBuilder sql = new StringBuilder("select ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL,  ALU_CONOCIMIENTOS , ALU_GIT ");
			sql.append(" From alumnos ");
			sql.append(" Where alu_nombre='Gabriel_test'");

			rs  = stm.executeQuery(sql.toString());
			if(rs.next())
			    aluLeido = new Alumno(rs.getInt("ALU_ID"), 
				rs.getString("ALU_NOMBRE"), 
				rs.getString("ALU_APELLIDO"), 
				rs.getString("ALU_EMAIL"), 
				rs.getString("ALU_CONOCIMIENTOS"),
				rs.getString("ALU_GIT") );
			
			assertEquals(alumnoAgregar.getNombre(), aluLeido.getNombre());
			assertEquals(alumnoAgregar.getApellido(), aluLeido.getApellido());
			assertEquals(alumnoAgregar.getEmail(), aluLeido.getEmail());
			assertEquals(alumnoAgregar.getConocimientos(), aluLeido.getConocimientos());
			assertEquals(alumnoAgregar.getNombre(), aluLeido.getNombre());			
			
			assertTrue(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}		
	}
	
	@Test
	void testModificar() {
		try {		
			alumnoModificar.setNombre("MarinaModif_test");
			alumnoModificar.setApellido("Calvo PeraModif_test");
			alumnoModificar.setEmail("email@gmailModif_test");
			alumnoModificar.setConocimientos("gardo en fisica_test");
			alumnoModificar.setLinkArepositorio("https:fakerepo_test");
			
			aluDao.modificar(alumnoModificar); //<borrar?
					
			Alumno aluLeido = null;

			StringBuilder sql = new StringBuilder("select ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL,  ALU_CONOCIMIENTOS , ALU_GIT ");
			sql.append(" From alumnos ");
			sql.append(" Where alu_nombre='MarinaModif_test'");

			rs  = stm.executeQuery(sql.toString());
			if(rs.next())
			    aluLeido = new Alumno(rs.getInt("ALU_ID"), 
				rs.getString("ALU_NOMBRE"), 
				rs.getString("ALU_APELLIDO"), 
				rs.getString("ALU_EMAIL"), 
				rs.getString("ALU_CONOCIMIENTOS"),
				rs.getString("ALU_GIT") );
			
			assertEquals(alumnoModificar.getNombre(), aluLeido.getNombre());
			assertEquals(alumnoModificar.getApellido(), aluLeido.getApellido());
			assertEquals(alumnoModificar.getEmail(), aluLeido.getEmail());
			assertEquals(alumnoModificar.getConocimientos(), aluLeido.getConocimientos());
			assertEquals(alumnoModificar.getNombre(), aluLeido.getNombre());			
			
			assertTrue(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}		
	}
	
	@Test
	void testEliminar() {
		try {		
			
			aluDao.eliminar(alumnoEliminar); 
					
			Alumno aluLeido = null;
			
			StringBuilder sql = new StringBuilder("select ALU_ID, ALU_NOMBRE , ALU_APELLIDO , ALU_EMAIL,  ALU_CONOCIMIENTOS , ALU_GIT ");
			sql.append(" From alumnos ");
			sql.append(" Where alu_nombre='Monsef_test'");

			rs  = stm.executeQuery(sql.toString());
			
			assertFalse(rs.next());
			
			assertTrue(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}		
	}
	
	@Test
	void testLeerCod() {
		try {
			List<Modelo> alumnos = aluDao.leer(alumnoLeerCod);

			Alumno aluLeido = (Alumno)alumnos.get(0);
			
			assertEquals(1, alumnos.size());
			
			assertEquals(alumnoLeerCod.getNombre()			, aluLeido.getNombre());
			assertEquals(alumnoLeerCod.getApellido()		, aluLeido.getApellido());
			assertEquals(alumnoLeerCod.getEmail()			, aluLeido.getEmail());
			assertEquals(alumnoLeerCod.getConocimientos()	, aluLeido.getConocimientos());
			assertEquals(alumnoLeerCod.getLinkArepositorio(), aluLeido.getLinkArepositorio());	
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	void testLeerNombre() {
		try {
			List<Modelo> alumnos = aluDao.leer(alumnoLeerNom);
		
			Alumno aluLeido = (Alumno)alumnos.get(0);
			
			assertEquals(1, alumnos.size());
			
			assertEquals(alumnoLeerNom.getNombre()			, aluLeido.getNombre());
			assertEquals(alumnoLeerNom.getApellido()		, aluLeido.getApellido());
			assertEquals(alumnoLeerNom.getEmail()			, aluLeido.getEmail());
			assertEquals(alumnoLeerNom.getConocimientos()	, aluLeido.getConocimientos());
			assertEquals(alumnoLeerNom.getLinkArepositorio(), aluLeido.getLinkArepositorio());
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}	
	}
	
	@Test
	void testLeerTodosNULL() {
		try {		
			List<Modelo> alumnos = aluDao.leer(null);

			System.out.println("alumnos=" + alumnos);
			
			assertTrue(alumnos.size()>1);
				
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	void testLeerTodos_VACIO() {
		try {		
			List<Modelo> alumnos = aluDao.leer(new Alumno());

			System.out.println("alumnos=" + alumnos);
			
			assertTrue(alumnos.size()>1);		
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}	
}
