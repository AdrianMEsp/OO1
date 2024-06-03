package ar.edu.unlp.info.oo1.ejercicio2;

import java.util.ArrayList;
import java.util.List;


public class BalanzaMejorada {
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	private List<Producto> items;
	
	public void ponerEnCero() {
		this.cantidadDeProductos=0;
		this.precioTotal=0;
		this.pesoTotal=0;
		this.items = new ArrayList<Producto>(); 
	}
	
	public void agregarProducto(Producto item) {
		this.items.add(item);
		this.precioTotal+=item.getPrecio();
		this.pesoTotal+=item.getPeso();
		items.add(item);
	}
	
	public int getCantidadDeProductos() {
		return this.cantidadDeProductos;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public double getPesoTotal() {
		return pesoTotal;
	}
	
	public String getDescripcionCompra() {
		String descrip = items.stream().toString();
		return descrip;
	}
	
	
}
