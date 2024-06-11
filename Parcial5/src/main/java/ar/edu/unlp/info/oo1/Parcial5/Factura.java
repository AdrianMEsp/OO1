package ar.edu.unlp.info.oo1.Parcial5;

import java.time.*;

public class Factura {
	private String patente;
	private LocalDate fechaFactura;
	private double montoFactura;
	private double descuento;
	
	public Factura (String patent,double monto, double descuen) {
		this.patente = patent;
		this.montoFactura = monto;
		this.descuento = descuen;
		this.fechaFactura = LocalDate.now();
	}
	
	public String getPatente() {
		return patente;
	}
	public LocalDate getFechaFactura() {
		return fechaFactura;
	}
	public double getMontoFactura() {
		return montoFactura;
	}
	public double getDescuento() {
		return descuento;
	}
}
