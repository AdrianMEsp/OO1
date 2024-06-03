package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDateTime;

public class LlamadaInterurbana extends RegistroLlamada{
	private double distanciaDeLlamado;
	
	public LlamadaInterurbana(LocalDateTime fecha, int duracion, String emisor, String receptor, double distancia) {
		super(fecha,duracion,emisor,receptor);
		this.distanciaDeLlamado = distancia;
	}
	
	public double calcularCosto() {
		double costo;
		if (this.distanciaDeLlamado < 100) {
			costo=super.calcularCosto(2);
		} else { 
			if (this.distanciaDeLlamado >= 100 && this.distanciaDeLlamado < 500) {
				costo=super.calcularCosto(2.5);
			}
			else {
				costo=super.calcularCosto(3);
			}
		}
		return (costo+5); //costo fijo de conexion
	}
}
