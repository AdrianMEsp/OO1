package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Email {
	private List<Archivo> adjunto;
	private String titulo;
	private String cuerpo;
	
	public Email(String titulo, String cuerpo) {
		this.titulo=titulo;
		this.cuerpo=cuerpo;
		this.adjunto= new ArrayList<Archivo>();
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getCuerpo() {
		return this.cuerpo;
	}
	
	public List<Archivo> adjuntos() {
		return this.adjunto;
	}
	
	public void agregarArchivo(Archivo adjunto) {
		this.adjunto.add(adjunto);
	}
	
	public boolean buscar(String texto) {
		if (this.getTitulo().contains(texto) || this.getCuerpo().contains(texto)) {
			return true;
		}
		return false;
	}
	
	public double espacioOcupado() {
		return (this.cuerpo.length() + this.titulo.length() +
				this.adjunto.stream().mapToDouble(adjunto -> adjunto.tamaño()).sum());
	}
	
}
