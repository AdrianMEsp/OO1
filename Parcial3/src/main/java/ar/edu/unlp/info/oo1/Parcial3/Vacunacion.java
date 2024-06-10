package ar.edu.unlp.info.oo1.Parcial3;

public class Vacunacion extends ServicioMedico{
	private String nombreVacuna;
	private double costoVacuna;
	private double materialesVacuna;
	private double costoDomingo;

	public Vacunacion(String nombre, double costo, Medico medico) {
		super(medico);
		this.nombreVacuna = nombre;
		this.costoVacuna = costo;
		this.materialesVacuna=500;
		this.costoDomingo=200;
	}

	public double costoMateriales() {
		return this.materialesVacuna + this.costoVacuna;
	}	
	
	//---------------//
	public String getNombreVacuna() {
		return nombreVacuna;
	}

	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}

	public double getCostoVacuna() {
		return costoVacuna;
	}

	public void setCostoVacuna(double costoVacuna) {
		this.costoVacuna = costoVacuna;
	}

	public double getMaterialesVacuna() {
		return materialesVacuna;
	}

	public void setMaterialesVacuna(double materialesVacuna) {
		this.materialesVacuna = materialesVacuna;
	}

	public double getCostoDomingo() {
		return costoDomingo;
	}

	public void setCostoDomingo(double costoDomingo) {
		this.costoDomingo = costoDomingo;
	}
	

}
