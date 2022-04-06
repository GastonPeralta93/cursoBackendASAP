package com.domain.modelo.dao;

//import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.domain.modelo.Alumno;
import com.domain.modelo.Modelo;
import com.domain.util.ConnectionManager;

public class AlumnoDAO implements DAO {
	
	private Connection conexion;
	
	public AlumnoDAO() throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		conexion= ConnectionManager.getConection();
	}

	@Override
	public void agregar(Modelo pModelo) throws ClassNotFoundException, SQLException {
		StringBuilder sql = new StringBuilder("insert into alumnos (ALU_NOMBRE		  , ALU_APELLIDO, ALU_EMAIL, "	);
		
					  sql			.append						   ("ALU_CONOCIMIENTOS, ALU_GIT) "				)
					  				.append							("values (?,?,?,?,?)"						);
		
	    //downCast
		Alumno alu = (Alumno)pModelo;
		
		PreparedStatement stm = conexion.prepareStatement(sql.toString()); 
		stm.setString(1, alu.getNombre());
		stm.setString(2, alu.getApellido());
		stm.setString(3, alu.getEmail());
		stm.setString(4, alu.getEstudios());
		stm.setString(5, alu.getLinkArepositorio());
		
		stm.execute();

	}
			
	@Override
	public void modificar(Modelo pModelo) throws ClassNotFoundException, SQLException {
		StringBuilder sql = new StringBuilder("update alumnos set ALU_NOMBRE = ?, ALU_APELLIDO = ?, ALU_EMAIL = ?, ALU_CONOCIMIENTOS = ?, ALU_GIT = ? where ALU_ID = ?");

		Alumno alu = (Alumno)pModelo;
		
		PreparedStatement stm = conexion.prepareStatement(sql.toString()); 
		stm.setString(1, alu.getNombre());
		stm.setString(2, alu.getApellido());
		stm.setString(3, alu.getEmail());
		stm.setString(4, alu.getEstudios());
		stm.setString(5, alu.getLinkArepositorio());
		stm.setString(6, Integer.toString(alu.getCodigo()));
		
		stm.execute();
	}

	//DELETE FROM table_name WHERE condition;	
	@Override
	public void eliminar(Modelo pModelo) {


	}

	@Override
	public List<Modelo> leer(Modelo pModelo) {

		return null;
	}

}
