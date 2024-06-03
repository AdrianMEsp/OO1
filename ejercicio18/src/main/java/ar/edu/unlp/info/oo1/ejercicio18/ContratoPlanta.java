package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoPlanta extends Contrato {
	private double sueldoMensual;
	private double montoConyuge;
	private double montoHijo;
	
	public ContratoPlanta(Empleado empleado,LocalDate fechaInicio, double sueldoMensual
			, double montoConyuge, double montoHijo) {
		super(empleado,fechaInicio);
		this.montoConyuge = montoConyuge;
		this.montoHijo = montoHijo;
	}
	
	public double getSueldoMensual() {
		return this.sueldoMensual;
	}
	
	public double getMontoConyuge() {
		return this.montoConyuge;
	}
	
	public double getMontoHijo() {
		return this.montoHijo;
	}

	@Override
	public boolean estaVencido() {
		return false;
	}

	@Override
	public double calcularMonto() {
		double monto = this.sueldoMensual;
		if (this.getEmpleado().tieneConyugue()) {
			monto+=this.montoConyuge;
		}
		if (this.getEmpleado().tieneHijos()) {
			monto+=this.montoHijo;
		}
		return monto;
	}

	@Override
	public int calcularAnios() {
		return (int) this.getFechaInicio().until(LocalDate.now(), ChronoUnit.YEARS);
	}
}

