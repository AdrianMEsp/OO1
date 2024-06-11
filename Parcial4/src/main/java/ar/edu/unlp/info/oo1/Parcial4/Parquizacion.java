package ar.edu.unlp.info.oo1.Parcial4;

public class Parquizacion extends Servicio{
	private int cantidadMaquinas;
	private double costoMantenimiento;
	
	public Parquizacion (double precioHora, int cantHoras
			, int cantMaquinas, double costoMante) {
		super(precioHora,cantHoras);
		this.cantidadMaquinas = cantMaquinas;
		this.costoMantenimiento = costoMante;
	}
	
	public double montoAPagar() {
		return ( this.montoHoras() + this.cantidadMaquinas * this.costoMantenimiento );
	}
	
	public double getCostoMantenimiento() {
		return costoMantenimiento;
	}
	public void setCostoMantenimiento(double costoMantenimiento) {
		this.costoMantenimiento = costoMantenimiento;
	}
	public int getCantidadMaquinas() {
		return cantidadMaquinas;
	}
	public void setCantidadMaquinas(int cantidadMaquinas) {
		this.cantidadMaquinas = cantidadMaquinas;
	}

}
