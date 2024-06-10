package ar.edu.unlp.info.oo1.Parcial3;

import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class ServicioMedico extends Servicio{
	private Medico medico;
	
	public ServicioMedico(Medico medico) {
		super();
		this.medico=medico;
	}
		
	public double getHonorarios() {
		return this.medico.getHonorarios();
	}
	
	public int getAntiguedad() {
		return this.medico.getAntiguedad();
	}
	
	public double recaudacionEn(LocalDate fecha) {
		if (this.getFechaServicio().equals(fecha)) {
			double rec = this.getHonorarios() + costoMateriales();
			if (LocalDate.now().getDayOfWeek().equals(DayOfWeek.SUNDAY))
				return rec + this.getCostoDomingo();
			
			return rec;
		}
		return 0;
	}

	protected abstract double costoMateriales();

	protected abstract double getCostoDomingo();

}
