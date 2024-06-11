package ar.edu.unlp.info.oo1.Parcial4;

public class Limpieza extends Servicio{
	private double tarifa;
	
	public Limpieza (double tarifa, double precio, int horas) {
		super(precio,horas);
		this.setTarifa(tarifa);
	}

	public double montoAPagar( ) {
		double total = this.montoHoras();
		if (total < this.tarifa) {
			return this.tarifa;
		}
		return total;
	}
	
	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	
	
}
