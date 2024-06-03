package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDateTime;

public class LlamadaLocal extends RegistroLlamada{

	
	public LlamadaLocal(LocalDateTime fecha, int duracion, String emisor, String receptor) {
		super(fecha,duracion,emisor,receptor);
	}
	
	
	public double calcularCosto() {
		return super.calcularCosto(1); 
	}

}
