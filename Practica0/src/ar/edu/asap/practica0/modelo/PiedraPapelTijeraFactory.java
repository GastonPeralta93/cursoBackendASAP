package ar.edu.asap.practica0.modelo;

import java.util.List;

public abstract class PiedraPapelTijeraFactory {
	public static final int PIEDRA = 1;
	public static final int PAPEL  = 2;
	public static final int TIJERA = 3;
	
	protected String descripcionResultado;
	private static List<PiedraPapelTijeraFactory> elementos;
	
	protected String nombre;
	protected int numero;
}
