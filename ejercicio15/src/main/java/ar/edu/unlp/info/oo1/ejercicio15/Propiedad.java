package ar.edu.unlp.info.oo1.ejercicio15;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unused")
public class Propiedad {
	private String nombre;
	private String descripcion;
	private double precioNoche;
	private String direccion;
	private Usuario propietario;
	private List<Reserva> reservas;
	
	public Propiedad(String nombre, String descripcion, double precioXNoche , String direccion, Usuario propietario) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.precioNoche= precioXNoche;
		this.direccion=direccion;
		this.propietario=propietario;
		this.reservas = new ArrayList<Reserva>();
	}
	
	public double getPrecioNoche() {
		return this.precioNoche;
	}
	
	public boolean disponibilidad(DateLapse periodo) {
		return this.reservas.stream().noneMatch(reservas -> reservas.overlaps(periodo));
	}
	
	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void eliminarReserva(Reserva reserva) {
		this.reservas.remove(reserva);
	}
	
	public double obtenerIngresosEntreP(DateLapse periodo) {
		return this.reservas.stream().filter(reserva -> reserva.overlaps(periodo)).mapToDouble(reserva -> reserva.precioReserva()).sum();
	}
}
