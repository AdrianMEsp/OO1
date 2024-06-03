package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDateTime;

public abstract class RegistroLlamada {
	private LocalDateTime fechaYHora;
	private int duracion;
	private String emisor;
	private String receptor; 
	
	public RegistroLlamada(LocalDateTime fecha, int duracion, String emisor, String receptor)
	{
		this.fechaYHora=fecha;
		this.duracion=duracion;
		this.emisor=emisor;
		this.receptor= receptor;
	}
	
	public boolean estaEntre(LocalDateTime fechaIni, LocalDateTime fechaFin) {
		return (this.fechaYHora.isAfter(fechaIni) ||
				this.fechaYHora.isEqual(fechaIni))
				&& (this.fechaYHora.isBefore(fechaFin)
				|| this.fechaYHora.isEqual(fechaFin));
	}
	
	public abstract double calcularCosto();
	
	public double calcularCosto(double costo) {
		return costo*this.duracion;
	}
	
	public LocalDateTime getFechaComienzo() {
		return this.fechaYHora;
	}

	public String getEmisor() {
		return emisor;
	}
	
	public String getReceptor() {
		return receptor;
	}
	
}
