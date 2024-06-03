package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;

public abstract class Contrato {
	private Empleado empleado;
	private LocalDate fechaInicio;
	
	
	public Contrato(Empleado empleado, LocalDate fechaInicio) {
		this.empleado=empleado;
		this.fechaInicio = fechaInicio;
	}
	
	public abstract boolean estaVencido();
	
	public abstract double calcularMonto();
	
	public abstract int calcularAnios();
	
	public Empleado getEmpleado() {
		return empleado;
	}
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
}
