package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDateTime;

public class LlamadaInternacional extends RegistroLlamada{
	private double tarifaDiurna;
	private double tarifaNocturna;
	private String paisOrigen;
	private String paisDestino;

	public LlamadaInternacional(LocalDateTime fecha, int duracion, String emisor, String receptor, String paisOrigen, String paisDestino) {
		super(fecha,duracion,emisor,receptor);
		this.tarifaDiurna = 4;
		this.tarifaNocturna = 3;
	}
	
	public double calcularCosto() {
		double costo=0;
		if (this.getFechaComienzo().getHour() >= 8 && this.getFechaComienzo().getHour() < 20) {
			costo=super.calcularCosto(4);
		}else costo=super.calcularCosto(3);
		return costo;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public String getPaisDestino() {
		return paisDestino;
	}

	public double getTarifaDiurna() {
		return tarifaDiurna;
	}

	public double getTarifaNocturna() {
		return tarifaNocturna;
	}
	
	
}
