package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;

public class CancelacionFlexible implements Politica{

	public double calcularReembolso(LocalDate fechaInicio , LocalDate fechaCancelacion , double montoTotal ) {
		if (fechaCancelacion.isBefore(fechaInicio)) {
			return montoTotal;
		}
		return 0;
	}
}
