package ar.edu.unlp.info.oo1.ejercicio4;

public class Cuerpo3D {
	private double altura;
	private Figura cara;
	
	
	
//Getters and setters
	
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public void setCaraBasal(Figura cara) {
		this.cara=cara;
	}
	
	public Figura getCaraBasal() {
		return this.cara;
	}
	
// Area y volumen
	
	public double getVolumen() {
		return cara.getArea()*altura;
	}
	
	public double getSuperficieExterior() {
		return this.getCaraBasal().getArea()*2 + this.getCaraBasal().getPerimetro()*this.getAltura();
	}
	
}