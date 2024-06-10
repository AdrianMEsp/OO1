package ar.edu.unlp.info.oo1.Parcial3;

import java.time.LocalDate;
import java.time.Period;

public class Medico {
	private String nombre;
	private LocalDate fechaIngreso;
	private double honorario;
	
	public Medico(String nombre,LocalDate fechaIngre, double honorario) {
		this.nombre = nombre;
		this.fechaIngreso = fechaIngre;
		this.honorario = honorario;
	}
	
	public double getHonorarios() {
		return this.honorario;
	}
	
	public int getAntiguedad() {
		return (Period.between(fechaIngreso, LocalDate.now()).getYears());
	}

	
	//---------------//
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getHonorario() {
		return honorario;
	}

	public void setHonorario(double honorario) {
		this.honorario = honorario;
	}
	
}
