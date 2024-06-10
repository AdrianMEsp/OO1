package ar.edu.unlp.info.oo1.Parcial3;

import java.time.LocalDate;

public abstract class Servicio {
	private LocalDate fechaServicio;
	
	public Servicio() {
		this.fechaServicio = LocalDate.now();
	}
	
	public LocalDate getFechaServicio() {
		return this.fechaServicio;
	}

	public abstract double recaudacionEn(LocalDate fecha);
}
