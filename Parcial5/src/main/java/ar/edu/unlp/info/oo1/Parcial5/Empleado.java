package ar.edu.unlp.info.oo1.Parcial5;

public class Empleado {
	private String nombre;
	private double valorHora;
	
	public Empleado(String n, double v) {
		this.nombre=n;
		this.valorHora=v;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
}
