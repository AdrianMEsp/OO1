package ar.edu.unlp.info.oo1.ejercicio4;

public class Cuadrado implements Figura{
	private double lado;
	

//getters and setters
	
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	
// perimetro y area
	
	@Override
	public double getPerimetro() {
		return 4*this.lado;
	}
	@Override
	public double getArea() {
		return (Math.pow(this.getLado(), 2));
	}
}
