package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private List<Email> emails;
	
	public Carpeta(String nombre) {
		this.nombre=nombre;
		this.emails = new ArrayList<Email>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getCantidadMails() {
		return this.emails.size();
	}
	
	public void recibirMail(Email email) {
		this.emails.add(email);
	}

	public void eliminarMail(Email email) {
		this.emails.remove(email);		
	}
	
	public Email buscar(String texto) {
		return this.emails.stream().filter(emails -> emails.buscar(texto))
				.findFirst().orElse(null);
	}
	
	public double espacioOcupado() {
		return this.emails.stream().mapToDouble(emails -> emails.espacioOcupado()).sum();
	}
}
