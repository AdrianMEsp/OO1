package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDateTime;

public class Factura {
	private LocalDateTime fechaFacturacion;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private double montoTotal;
	private Persona cliente;
	
	public Factura (LocalDateTime fechaInicio, LocalDateTime fechaFin, Persona cliente, double montoTotal) {
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.montoTotal = montoTotal;
		this.cliente = cliente;
		this.fechaFacturacion = LocalDateTime.now();
	}

	public LocalDateTime getFechaFacturacion() {
		return fechaFacturacion;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public Persona getCliente() {
		return cliente;
	}
	
	
}
