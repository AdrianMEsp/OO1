package ar.edu.unlp.info.oo1.ejercicio15;

public class Reserva {
	private DateLapse fechaReserva;
	private Propiedad propiedad;
	
	public Reserva(DateLapse fechaReserva , Propiedad propiedad) {
		this.fechaReserva = fechaReserva;
		this.propiedad = propiedad;
	}
	
	public boolean overlaps(DateLapse periodo) {
		return this.fechaReserva.overlaps(periodo);
	}
	
	public double precioReserva() {
		return this.propiedad.getPrecioNoche() * this.fechaReserva.sizeInDays();
	}
	
	public DateLapse getFechaReserva() {
		return this.fechaReserva;
	}
	
	public boolean inicioPosteriorActual() {
		return fechaReserva.despuesDe();
	}
	
}
