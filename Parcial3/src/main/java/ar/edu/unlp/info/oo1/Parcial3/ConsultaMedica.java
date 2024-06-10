package ar.edu.unlp.info.oo1.Parcial3;

public class ConsultaMedica extends ServicioMedico{
	private double materialesConsulta;
	private double costoDomingo;
	
	public ConsultaMedica(Medico medico) {
		super(medico);
		this.materialesConsulta=300;
		this.costoDomingo=200;
	}
	
	public double costoMateriales() {
		return this.materialesConsulta;
	}
	

	//---------------//
	public double getMaterialesConsulta() {
		return materialesConsulta;
	}

	public void setMaterialesConsulta(double materialesConsulta) {
		this.materialesConsulta = materialesConsulta;
	}

	public double getCostoDomingo() {
		return costoDomingo;
	}

	public void setCostoDomingo(double costoDomingo) {
		this.costoDomingo = costoDomingo;
	}	
	
}
