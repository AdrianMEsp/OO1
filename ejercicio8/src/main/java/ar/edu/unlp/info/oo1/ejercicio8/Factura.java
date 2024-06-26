package ar.edu.unlp.info.oo1.ejercicio8;

import java.time.LocalDate;

public class Factura {
	private double montoEnergiaActiva;
	private Usuario usuario;
	private double descuento;
	private LocalDate fecha;
	
	public Factura(double montoEnergiaActiva, double descuento, Usuario usuario) {
		this.montoEnergiaActiva = montoEnergiaActiva;
		this.usuario = usuario;
		this.descuento = descuento;
		this.fecha = LocalDate.now();
	}
	
	//GETTERS Y SETTERS
	public double getMontoEnergiaActiva() {
		return montoEnergiaActiva;
	}
	public void setMontoEnergiaActiva(double montoEnergiaActiva) {
		this.montoEnergiaActiva = montoEnergiaActiva;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	//METODOS PROPIOS
	
	public double montoTotal() {
		return this.montoEnergiaActiva - this.montoEnergiaActiva * (this.getDescuento() /100);
	}
	
	public Usuario usuario() {
		return this.usuario;
	}

	public LocalDate fecha() {
		return this.fecha;
	}

}
