package com.domain.modelo.dao;

import java.sql.SQLException;
import java.util.List;

import com.domain.modelo.Modelo;

public interface DAO {
	
	public void agregar (Modelo pModelo) throws ClassNotFoundException, SQLException;
	public void modificar (Modelo pModelo) throws ClassNotFoundException, SQLException;
	public void eliminar (Modelo pModelo) throws ClassNotFoundException, SQLException;
	public List<Modelo> leer (Modelo pModelo) throws ClassNotFoundException, SQLException;
}
