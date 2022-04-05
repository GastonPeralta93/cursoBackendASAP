package ar.edu.asap.practica0.modelo;

import java.util.Objects;

public class Jugador {
	
	private int codigo;
	private String nombre;
	private String nickname;
	private PiedraPapelTijeraFactory jugadaElegida;


	public Jugador() {
		super();
	}
	
	public Jugador(int codigo, String nombre, String nickname, PiedraPapelTijeraFactory jugadaElegida) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.nickname = nickname;
		this.jugadaElegida = jugadaElegida;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public PiedraPapelTijeraFactory getJugadaElegida() {
		return jugadaElegida;
	}

	public void setJugadaElegida(PiedraPapelTijeraFactory jugadaElegida) {
		this.jugadaElegida = jugadaElegida;
	}
	
	//+ hashCode int
	
	//+ equals(Object): boolean
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo, jugadaElegida, nickname, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return codigo == other.codigo && Objects.equals(jugadaElegida, other.jugadaElegida)
				&& Objects.equals(nickname, other.nickname) && Objects.equals(nombre, other.nombre);
	}

	
	
	public String toString() {
		return getCodigo() + "-" + getNombre() + "-" + getNickname() + "-" + getJugadaElegida();
	}
	
	


}
