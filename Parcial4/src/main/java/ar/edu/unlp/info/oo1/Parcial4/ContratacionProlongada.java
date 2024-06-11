package ar.edu.unlp.info.oo1.Parcial4;

import java.time.LocalDate;

public class ContratacionProlongada extends Contratacion{
	private int cantidadDias;
	
	public ContratacionProlongada(Servicio s,LocalDate fechaIni, int cantDias) {
		super(s,fechaIni);
		this.setCantidadDias(cantDias);
	}
	
	public double montoAPagar() {
		double total = this.montoBasicoContratacionProlo();
		if (masDe5Dias()) total *=0.9;
		return total;
	}
	
	public boolean masDe5Dias() {
		return this.cantidadDias > 5;
	}
	
	public double montoBasicoContratacionProlo() {
		return this.cantidadDias * super.montoAPagar();
	}
	
	public int getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}
}
