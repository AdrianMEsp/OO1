package ar.edu.unlp.info.oo1.Parcial4;

import java.time.*;

public class Contratacion {
	private LocalDate fechaInicial;
	private Servicio servicio;

	public Contratacion (Servicio s ,LocalDate fechaIni) {
		this.servicio = s;
		this.fechaInicial = fechaIni;
	}
	
	public double montoAPagar() {
		double total = this.servicio.montoAPagar();
		if (isWeekend()) {
			total *=1.15;
		}
		return total;
	}
	
	public boolean isWeekend() {
		DayOfWeek day = this.fechaInicial.getDayOfWeek();
		return day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY);
	}
	
	
	public LocalDate getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(LocalDate fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Servicio getServicio() {
		return servicio;
	}



	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
}
