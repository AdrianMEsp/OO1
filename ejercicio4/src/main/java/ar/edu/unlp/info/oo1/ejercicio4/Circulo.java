package ar.edu.unlp.info.oo1.ejercicio4;

public class Circulo implements Figura {
	private double radio;
	

//getters and setters
	
	public double getRadio() {
		return radio;
	}

	public void setRadio(double medida) {
		this.radio= medida;
	}
	
	public double getDiametro() {
		return this.getRadio()*2;
	}

	public void setDiametro(double valor) {
		this.setRadio(valor/2);
	}
	
// perimetro y area
	
	@Override
	public double getPerimetro() {
		return (Math.PI * this.getDiametro());
	}
	@Override
	public double getArea() {
		return (Math.PI * (Math.pow(this.getRadio(), 2)));
	}
	
}
