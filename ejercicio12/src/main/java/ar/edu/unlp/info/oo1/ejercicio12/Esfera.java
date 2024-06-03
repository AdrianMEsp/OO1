package ar.edu.unlp.info.oo1.ejercicio12;

public class Esfera extends Pieza{
	private int radio;
	
	public Esfera(String material, String color, int radio) {
		super(material,color);
		this.setRadio(radio);
	}
	
	//GETTERS Y SETTERS
	
	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	//METODOS PROPIOS
	@Override
	public double getVolumen() {
		return ((double) 4/3) * Math.PI * Math.pow(this.getRadio(),3);
	}

	@Override
	public double getSuperficie() {
		return 4 * Math.PI * Math.pow(this.getRadio(),2);
	}
}
