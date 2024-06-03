package ar.edu.unlp.info.oo1.ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String name;
	private String address;
	private List<Consumo> consumos;
	private List<Factura> facturas;
	
	public Usuario(String name, String address) {
		this.name=name;
		this.address=address;
		this.consumos = new ArrayList<Consumo>();
		this.facturas = new ArrayList<Factura>();
	}
	
	// GETTERS Y SETTERS
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//METODOS PROPIOS
	
	public void agregarMedicion(Consumo medicion) {
		consumos.add(medicion);
	}
	
	public void agregarFactura(Factura factura) {
		facturas.add(factura);
	}
	
	public double ultimoConsumoActiva() {
		if (this.ultimoConsumo() != null) {
			return ultimoConsumo().getConsumoAct();
		}
		else return 0; //en caso que el usuario no tenga comsumos
	}
	
	public Consumo ultimoConsumo() {
		return this.consumos.stream()
				.max((Consumo c1, Consumo c2) -> c1.getFecha().compareTo(c2.getFecha())).orElse(null);
	}
	
	public Factura facturarEnBaseA(double precioKWh) {
		Consumo ultimoConsumo = this.ultimoConsumo();
		Factura factura;
		if (ultimoConsumo == null) {
			factura = new Factura(0,0,this); // costo consumo, usuario, descuento
		}
		else {
			if (ultimoConsumo.factorDePotencia() > 0.8) {
				factura = new Factura(ultimoConsumo.costoEnBaseA(precioKWh),10,this);
			}
			else factura = new Factura(ultimoConsumo.costoEnBaseA(precioKWh),0,this);
		}
		return factura;
	}
	
	public List<Factura> facturas() {
		return this.facturas;
	}
	
}
