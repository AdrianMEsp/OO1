package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;

public interface Politica {
	
	
	public double calcularReembolso(LocalDate fechaInicio , LocalDate fechaCancelacion , double montoTotal);
}
