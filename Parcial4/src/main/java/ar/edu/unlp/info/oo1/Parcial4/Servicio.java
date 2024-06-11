package ar.edu.unlp.info.oo1.Parcial4;

public abstract class Servicio {
	private double precioHora;
	private int cantHora;
	
	public Servicio(double precio, int horas) {
		this.setPrecioHora(precio);
		this.setCantHora(horas);
	}
	
	public abstract double montoAPagar();
	
	public double montoHoras() {
		return this.getCantHora() + this.getPrecioHora();
	}
		
	public int getCantHora() {
		return cantHora;
	}

	public void setCantHora(int cantHora) {
		this.cantHora = cantHora;
	}

	public double getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}
}
