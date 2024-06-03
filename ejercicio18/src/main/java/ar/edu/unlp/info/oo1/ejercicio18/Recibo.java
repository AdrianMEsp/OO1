package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;

public class Recibo {
	private Empleado empleado;
	private int antiguedadMeses;
	private LocalDate fechaGeneracion;
	private double montoACobrar;
	
	public Recibo(Empleado empleado, int antiguedadMeses, LocalDate fechaGeneracion, double montoACobrar) {
		this.empleado = empleado;
		this.antiguedadMeses = antiguedadMeses;
		this.fechaGeneracion = fechaGeneracion;
		this.montoACobrar = montoACobrar;
	}

	public int getAntiguedadMeses() {
		return antiguedadMeses;
	}

	public LocalDate getFechaGeneracion() {
		return fechaGeneracion;
	}

	public double getMontoACobrar() {
		return montoACobrar;
	}
	
	
}
