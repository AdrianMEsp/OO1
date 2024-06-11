package ar.edu.unlp.info.oo1.Parcial5;

import java.time.*;
import java.util.*;

public abstract class Orden {
	private String patente;
	private LocalDate fechaOrden;
	private List<Repuesto> repuestos;
	
	public Orden(String patente, List<Repuesto> repuestosUsados) {
		this.patente=patente;
		this.fechaOrden = LocalDate.now();
		this.repuestos = repuestosUsados;
	}
		
	public abstract double calcularCosto();
	 
	public abstract double calcularMontoFinal();
		
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public LocalDate getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(LocalDate fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
	public List<Repuesto> getRepuestos() {
		return repuestos;
	}
	
	
}
