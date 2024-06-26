package ar.edu.unlp.info.oo1.ejercicio2;

public class Balanza {
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;

	public void ponerEnCero() {
		cantidadDeProductos=0;
		precioTotal=0;
		pesoTotal=0;
	}

	public void agregarProducto (Producto producto) {
		cantidadDeProductos=+1;
		pesoTotal+=producto.getPeso();
		precioTotal+=producto.getPrecio();
	}

	public Ticket emitirTicket() {
		return new Ticket(cantidadDeProductos,precioTotal,pesoTotal);
	}

	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public void setCantidadDeProductos(int cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	
	
}