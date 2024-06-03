package ar.edu.unlp.info.oo1.ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	private boolean on;
	private List<Farola> vecinas;

	public Farola() {
		this.vecinas = new ArrayList<Farola>();
		this.on=false;
	}
	
	public boolean isOn() {
		return on;
	}

	public void setOn(boolean encendido) {
		this.on = encendido;
	}
	
	public List<Farola> getNeighbors(){
		return this.vecinas;
	}
	
	public void pairWithNeighbor(Farola otraFarola) {
		if (! this.getNeighbors().contains(otraFarola)) {
			this.vecinas.add(otraFarola);
			otraFarola.pairWithNeighbor(this);
		}
	}
	
	public void turnOn() {
		if (! this.isOn()) {
			this.on=true;
			this.getNeighbors().forEach(l -> l.turnOn());			
		}
	}
	
	public void turnOff() {
		if (this.isOn()) {
			this.on=false;
			this.getNeighbors().forEach(l -> l.turnOff());			
		}
	}
	
}
