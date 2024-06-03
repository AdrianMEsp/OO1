package ar.edu.unlp.info.oo1.ejercicio12;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;
	
	public ReporteDeConstruccion() {
		piezas = new ArrayList<Pieza>();
	}
	
	
	public List<Pieza> getPiezas(){
		return this.piezas;
	}
	
	//METODOS PROPIOS
	

	public void agregarPieza(Pieza pieza) {
		this.piezas.add(pieza);
	}
	
	public double getVolumenDeMaterial(String material) {
		return piezas.stream().mapToDouble(piezas -> piezas.getVolumen()).sum();
	}
	
	public double getSuperficieDeColor(String color) {
		return piezas.stream().mapToDouble(piezas -> piezas.getSuperficie()).sum();
	}
	
}
