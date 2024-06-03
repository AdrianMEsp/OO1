package ar.edu.unlp.info.oo1.ejercicio2;

import java.sql.Date;

public class Ticket {
	private Date fecha;
	private int cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;
	
	public Ticket(int cantiProd, double pesoTot, double precTot ) {
		this.cantidadDeProductos = cantiProd;
		this.pesoTotal = pesoTot;
		this.precioTotal = precTot; 
		}
	
	public double impuesto(){
		return 0.21*precioTotal;
	}

	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public void setCantidadDeProductos(int cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Date getFecha() {
		return fecha;
	}
	
	
	
}
