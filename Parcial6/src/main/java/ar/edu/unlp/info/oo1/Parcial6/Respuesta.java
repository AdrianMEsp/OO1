package ar.edu.unlp.info.oo1.Parcial6;

import java.time.LocalDate;

public class Respuesta {
	private Usuario usuario;
	private Publicacion publicacion;
	private String contenido;
	private LocalDate fecha;
	
	public Respuesta(Usuario user, Publicacion publi, String contenido) {
		this.usuario=user;
		this.publicacion=publi;
		this.contenido=contenido;
		this.fecha = LocalDate.now();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	

}
