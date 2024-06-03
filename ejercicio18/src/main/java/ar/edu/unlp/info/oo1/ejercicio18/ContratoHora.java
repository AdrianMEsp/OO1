package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoHora extends Contrato {
	private double valorHora;
	private int cantidadHorasMes;
	private LocalDate fechaFin;

	public ContratoHora(Empleado empleado,LocalDate fechaInicio, double valorHora, int cantidadHorasMes, 
			LocalDate fechaFin) {
		super(empleado,fechaInicio);
		this.valorHora=valorHora;
		this.cantidadHorasMes = cantidadHorasMes;
		this.fechaFin = fechaFin;
	}

	public double getValorHora() {
		return valorHora;
	}

	public int getCantidadHorasMes() {
		return cantidadHorasMes;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}
	
	public boolean estaVencido() {
		return this.fechaFin.isBefore(LocalDate.now()) || this.fechaFin.isEqual(LocalDate.now());
	}
	
	public double calcularMonto() {
		return this.cantidadHorasMes * this.valorHora;
	}
	
	public int calcularAnios() {
		if (this.fechaFin.isBefore(LocalDate.now())) {
			return (int) this.getFechaInicio().until(this.fechaFin, ChronoUnit.YEARS);
		}
		return (int) this.getFechaInicio().until(LocalDate.now(), ChronoUnit.YEARS);
	}

	
}
