package ar.edu.unlp.info.oo1.ejercicio15;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unused")
public class Usuario {

	private String nombre;
	private String direccion;
	private int dni;
	private List<Propiedad> propEnAlquiler;
	private List<Reserva> reservas; 
	
	public Usuario (String nombre, String direccion, int dni) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.dni=dni;
		this.propEnAlquiler = new ArrayList<Propiedad>();
		this.reservas = new ArrayList<Reserva>();
	}
	
	public void agregarInmueble(Propiedad inmueble) {
		this.propEnAlquiler.add(inmueble);
	}
	
	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void eliminarReserva(Reserva reserva) {
		this.reservas.remove(reserva);
	}
	
	public List<Propiedad> obtenerPropiedades(){
		return this.propEnAlquiler;
	}
	
	public List<Reserva> obtenerReservas(){
		return this.reservas;
	}
	
	public double obtenerIngresosEntre(DateLapse periodo) {
		return this.propEnAlquiler.stream().mapToDouble(propEnAlquiler -> propEnAlquiler.obtenerIngresosEntreP(periodo)).sum();
	}
	
}
