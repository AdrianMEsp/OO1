package ar.edu.unlp.info.oo1.ejercicio8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Distribuidora {
	private double precioKWh;
	private List<Usuario> usuarios;

	public Distribuidora (double precioKWh) {
		this.precioKWh=precioKWh;
		this.usuarios = new ArrayList<Usuario>();
	}
	//GETTERS Y SETTERS

	public double getPrecioKW() {
		return precioKWh;
	}

	public void setPrecioKW(double precioKWh) {
		this.precioKWh = precioKWh;
	}
	
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	//METODOS PROPIOS
	
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public List<Factura> facturar() {
		return this.usuarios.stream().map(usuario -> usuario.
				facturarEnBaseA(this.precioKWh)).collect(Collectors.toList());
	}
	
	public double consumoTotalActiva() {
		return this.usuarios.stream().mapToDouble(usuario -> usuario
				.ultimoConsumoActiva()).sum();
	}
	
	public double precioKWh() {
		return this.precioKWh;
	}
}
