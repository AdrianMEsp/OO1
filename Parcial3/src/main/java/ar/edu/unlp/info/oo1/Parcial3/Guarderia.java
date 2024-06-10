package ar.edu.unlp.info.oo1.Parcial3;

import java.time.LocalDate;

public class Guarderia extends Servicio{
	private int cantidadDias;

	
	public Guarderia(int cantidad) {
		super();
		this.cantidadDias= cantidad;
	}
	
	public double recaudacionEn(LocalDate fecha) {
		if (this.getFechaServicio().equals(fecha)) {
			return 500*this.cantidadDias;
		}
		return 0;
	}
	
}
