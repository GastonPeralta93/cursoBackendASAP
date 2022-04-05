package ar.edu.asap.practica0.modelo;

import java.util.Date;

public class Auditoria {

	private Date fecha;
	private int cantidadJugadas = 0;
	
	public Auditoria() {

	}

	public Auditoria(Date fecha, int cantidadJugadas) {
		super();
		this.fecha = fecha;
		this.cantidadJugadas = cantidadJugadas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidadJugadas() {
		return cantidadJugadas;
	}

	public void setCantidadJugadas(int cantidadJugadas) {
		this.cantidadJugadas = cantidadJugadas;
	}
	
	public void contarDespuesDeLaJugada() {
		cantidadJugadas = cantidadJugadas + 1;
	}
}
