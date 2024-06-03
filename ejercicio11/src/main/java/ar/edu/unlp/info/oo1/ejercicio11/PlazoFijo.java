package ar.edu.unlp.info.oo1.ejercicio11;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversiones{
	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	public PlazoFijo(LocalDate fecha,double monto, double porcentaje) {
		this.fechaDeConstitucion = fecha;
		this.montoDepositado = monto;
		this.porcentajeDeInteresDiario = porcentaje;
	}
		
	public LocalDate getFechaDeConstitucion() {
		return fechaDeConstitucion;
	}

	public void setFechaDeConstitucion(LocalDate fechaDeConstitucion) {
		this.fechaDeConstitucion = fechaDeConstitucion;
	}

	public double getMontoDepositado() {
		return montoDepositado;
	}

	public void setMontoDepositado(double montoDepositado) {
		this.montoDepositado = montoDepositado;
	}

	public double getPorcentajeDeInteresDiario() {
		return porcentajeDeInteresDiario;
	}

	public void setPorcentajeDeInteresDiario(double porcentajeDeInteresDiario) {
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}

	public double valorActual() {
		long diasActuales = ChronoUnit.DAYS.between(this.getFechaDeConstitucion(), LocalDate.now());
		return (this.getMontoDepositado() + (this.getMontoDepositado() * this.getPorcentajeDeInteresDiario() * diasActuales));
	}
}
