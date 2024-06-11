package ar.edu.unlp.info.oo1.Parcial4;

import java.util.*;

public class Cliente {
	private String nombre;
	private String direccion;
	private List<Contratacion> contrataciones;
	
	public Cliente(String nomb, String direcc) {
		this.nombre = nomb;
		this.direccion = direcc;
		this.contrataciones = new ArrayList<Contratacion>();
	}

	public void contratar(Contratacion c) {
		this.contrataciones.add(c);
	}
	
	public double montoAPagar() {
		return this.contrataciones.stream().mapToDouble(contrataciones
				-> contrataciones.montoAPagar()).sum();
	}
	
	
	
	
	
	
	
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Contratacion> getContrataciones() {
		return contrataciones;
	}
	
	
}
