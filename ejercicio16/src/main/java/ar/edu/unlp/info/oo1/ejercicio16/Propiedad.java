package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private double precioPorNoche;
	private String direccion;
	private List<Reserva> reservas;
	private Politica politica;
	
	public Propiedad(String nombre, String descripcion, Double precioPorNoche, String direccion, Politica politica) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.precioPorNoche=precioPorNoche;
		this.descripcion=direccion;
		this.politica=politica;
		this.reservas = new ArrayList<Reserva>();
	}
	
	public boolean disponibleEntre(DateLapse lapso) {
		return this.reservas.stream().noneMatch(reservas -> reservas.overlaps(lapso));
	}
	
	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void cancelarReserva(Reserva reservaAEliminar) {
		this.reservas.remove(reservaAEliminar);
	}
	
	public double getPrecioPorNoche() {
		return this.precioPorNoche;
	}
	
	public double calcularIngresos (DateLapse periodo) {
		return this.reservas.stream().filter(reservas -> reservas.overlaps(periodo)).mapToDouble(reservas -> reservas.obtenerPrecioReserva()).sum();
	}

	public Politica getPolitica() {
		return this.politica;
	}

	public double calcularReembolso(LocalDate fechaTentativa, Reserva reserva) {
	//	this.reservas.stream().filter(reservas -> reservas.equals(reserva)).findAny();
		return this.getPolitica().calcularReembolso(reserva.getPeriodoReserva().getFrom(), fechaTentativa, reserva.obtenerPrecioReserva());
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public double calcularPrecio(int cantDias) {
		return cantDias * this.precioPorNoche;
	}
	
	
	
	
	
}
