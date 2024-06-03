package ar.edu.unlp.info.oo1.ejercicio8;

import java.time.LocalDate;

public class Consumo{
	private LocalDate fecha;
	private double consumoAct;
	private double consumoReac;
	
	public Consumo (LocalDate localDate, double consumoAct, double consumoReac) {
		this.fecha=localDate;
		this.consumoAct=consumoAct;
		this.consumoReac=consumoReac;
	}
	
	//GETTERS Y SETTERS
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public double getConsumoAct() {
		return consumoAct;
	}
	public void setConsumoAct(double consumoAct) {
		this.consumoAct = consumoAct;
	}
	public double getConsumoReac() {
		return consumoReac;
	}
	public void setConsumoReac(double consumoReac) {
		this.consumoReac = consumoReac;
	}
	//METODOS PROPIOS
	
	public double costoEnBaseA(double precioKWh) {
		return this.getConsumoAct() * precioKWh;
	}
	
	public double factorDePotencia() {
		double result=0;
		result= Math.pow(this.getConsumoAct(), 2) + Math.pow(this.getConsumoReac(), 2);
		result= Math.sqrt(result);
		return this.getConsumoAct() / result;
	}
}
