package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;

public class Reserva {
	private DateLapse periodoReserva;
	private Propiedad propiedad;
	
	public Reserva(DateLapse periodo, Propiedad propiedad) {
		this.periodoReserva=periodo;
		this.propiedad=propiedad;
	}
	
	public boolean overlaps (DateLapse lapso) {
		return lapso.overlaps(this.getPeriodoReserva());
	}
	
	public DateLapse getPeriodoReserva() {
		return this.periodoReserva;
	}
	
	public double obtenerPrecioReserva( ) {
		return this.propiedad.calcularPrecio(this.periodoReserva.cantDias());
	}

	public boolean inicioPosteriorActual() {
		return this.periodoReserva.inicioPosteriorActual();
	}
	
	public double calcularReembolso(LocalDate fechaTentativa) {
		return this.propiedad.calcularReembolso(fechaTentativa,this);
	}
	
	
	
}
