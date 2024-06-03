package ar.edu.unlp.info.oo1.ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	public Presupuesto (String Cliente) {
		this.fecha= LocalDate.now();
		this.items = new ArrayList<Item>();
		this.cliente = Cliente;
	}
	
	public void agregarItem(Item item) {
		items.add(item);
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public String getCliente() {
		return cliente;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double calcularTotal() {
		double total = items.stream().mapToDouble(elemento->elemento.costo()).sum();
		return total;
	}
	
}
