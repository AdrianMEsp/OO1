package ar.edu.unlp.info.oo1.ejercicio11;

public class InversionEnAcciones implements Inversiones{
	private String nombre;
	private int cantidad;
	private double valorUnitario;
	
	public InversionEnAcciones(String nombre, int cantidad ,double valor) {
		this.nombre=nombre;
		this.cantidad=cantidad;
		this.valorUnitario=valor;
	}
	//GETTERS Y SETTERS	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	//METODOS PROPIOS
	public double valorActual() {
		return this.getCantidad() * this.getValorUnitario();
	}
}
