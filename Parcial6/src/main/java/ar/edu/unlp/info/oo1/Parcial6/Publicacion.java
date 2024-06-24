package ar.edu.unlp.info.oo1.Parcial6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
	private String titulo;
	private String contenido;
	private List<Respuesta> respuestas;
	private LocalDate fecha;
	private int likes;
	private int dislikes;

	
	public Publicacion (String titulo, String contenido) {
		this.titulo=titulo;
		this.setContenido(contenido);
		this.fecha = LocalDate.now();
		this.respuestas = new ArrayList<Respuesta>();
	}
	
	public void agregarRespuesta(Usuario user, String contenido) {
		Respuesta r = new Respuesta(user,this,contenido);
		this.respuestas.add(r);
	}
	
	public void darLike() {
		this.likes++;
	}
	
	public void darDislike() {
		this.dislikes++;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public int getDislike() {
		return this.dislikes;
	}
	
	public int getLike() {
		return this.likes;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
}
