package ar.edu.unlp.info.oo1.ejercicio16;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String direccion;
	private int dni;
	private List<Propiedad> enPropiedad;
	private List<Reserva> alquileres;
	
	public Usuario(String nombre, String direccion, int dni) {
		this.nombre = nombre;
		this.direccion=direccion;
		this.dni= dni;
		this.enPropiedad = new ArrayList<Propiedad>();
		this.alquileres = new ArrayList<Reserva>();
	}

	public void agregarPropiedad(Propiedad propiedad) {
		this.enPropiedad.add(propiedad);
	}
	
	public void eliminarReserva(Reserva reservaACancelar) {
		this.alquileres.remove(reservaACancelar);
	}

	public void agregarReserva(Reserva reserva) {
		this.alquileres.add(reserva);
	}
	
	public List<Reserva> obternerReservas() {
		return this.alquileres;
	}

	public double calcularIngresosEntre(DateLapse periodo) {
		return this.enPropiedad.stream().mapToDouble(enPropiedad -> enPropiedad.calcularIngresos(periodo)).sum();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getDni() {
		return dni;
	}
	
	
}
