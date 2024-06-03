package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CancelacionModerada implements Politica{

	public double calcularReembolso(LocalDate fechaInicio , LocalDate fechaCancelacion , double montoTotal) {
		if (fechaCancelacion.isBefore(fechaInicio)) {
			int cantDias = (int) ChronoUnit.DAYS.between(fechaCancelacion,fechaInicio);
			if (cantDias >= 7 ) return montoTotal;
			else if (cantDias >= 2) return montoTotal / 2;
		}
		return 0;
	}
}
