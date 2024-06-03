package ar.edu.unlp.info.oo1.ejercicio3;

public class Item {
	@SuppressWarnings("unused")
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	
	public Item(String detalle, int cantidad, double costoUnitario) {
		this.detalle=detalle;
		this.cantidad=cantidad;
		this.costoUnitario=costoUnitario;
	}
	
	public double getCostoUnitario() {
		return costoUnitario;
	}
	
	public String getDetalle() {
		return detalle;
	}

	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public double costo() {
		return this.cantidad*this.costoUnitario;
	}
}
