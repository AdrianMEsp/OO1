package ar.edu.unlp.info.oo1.ejercicio11;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
	private String nombre;
	private List<Inversiones> inversiones;
	
	public Inversor(String nombre) {
		this.nombre=nombre;
		this.inversiones = new ArrayList<Inversiones>();
	}
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Inversiones> getInversiones() {
		return inversiones;
	}

	//METODOS PROPIOS
	public double valorActual() {
		return this.inversiones.stream().mapToDouble(inversion -> inversion.valorActual()).sum();
	}
	
	public void agregarInversion(Inversiones inversion) {
		this.inversiones.add(inversion);
	}
}
