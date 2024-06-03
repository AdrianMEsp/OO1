package ar.edu.unlp.info.oo1.ejercicio5;

import java.sql.Date;

public class Mamifero {
	private String identificador;
	private String especie;
	private Date fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;

public Mamifero() {
	
}
	
public Mamifero(String nombre){
	this.identificador=nombre;
}
	
// getters y setters
		
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Mamifero getPadre() {
		return this.padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	public Mamifero getMadre() {
		return this.madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
// gets abuelos
	public Mamifero getAbueloPaterno() {
		if (this.getPadre() != null)
				return this.getPadre().getPadre();
		else
			return null;
	}
	
	public Mamifero getAbuelaPaterna() {
		if (this.getPadre() != null)
			return this.getPadre().getMadre();
		else
			return null;
	}
	
	public Mamifero getAbueloMaterno() {
		if (this.getMadre() != null)
			return this.getMadre().getPadre();
		return null;
	}
	
	public Mamifero getAbuelaMaterna() {
		if (this.getMadre() !=null)
			return this.getMadre().getMadre();
		else
			return null;
	}

	
//------------ pasa el test, pero falta encapsulamiento

///*
	public boolean papas (Mamifero unMamifero) {
		if (this.getPadre() != null && this.getPadre() == unMamifero) return true;
		else 
			if (this.getPadre() != null && this.getPadre().papas(unMamifero)) return true;
			if (this.getMadre() != null && this.getMadre() == unMamifero) return true;
				else if(this.getMadre() != null && this.getMadre().papas(unMamifero)) return true;
		return false;
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return (this.papas(unMamifero) );
	}
	
//*/
/*
	public boolean papas (Mamifero unMamifero) {
		if (this.getPadre() != null) {
			if (this.getPadre() == unMamifero) return true;
			if (this.getPadre().papas(unMamifero)) return true;
		}
		if (this.getMadre() != null) {
			if (this.getMadre() == unMamifero) return true;
			if (this.getMadre().papas(unMamifero)) return true;
		}
		return false;
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return (this.papas(unMamifero) );
	}
	*/
}
