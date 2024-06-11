package ar.edu.unlp.info.oo1.Parcial5;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Repuesto {
	private String nombre;
	private LocalDate fechaFabricacion;
	private double costo;
	
	public Repuesto(String nombre, LocalDate fecha, double costo) {
		this.nombre=nombre;
		this.costo = costo;
		this.fechaFabricacion=fecha;
	}
	
	public boolean esAntiguo() {
		int antiguedad = (int) ChronoUnit.YEARS.between(this.fechaFabricacion, LocalDate.now()); 
		return (antiguedad > 5);
    }	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaFabricacion() {
		return fechaFabricacion;
	}
	public void setFechaFabricacion(LocalDate fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}	
}
