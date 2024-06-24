package ar.edu.unlp.info.oo1.Parcial6;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String contraseña;
	private List<Publicacion> publicaciones;
	private List<Usuario> seguidos;
	private Debate debate;
	private Recomendador recomendador;
	private List<Publicacion> feed;
	
	public Usuario (String nombre, String contraseña, Debate debate) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.debate = debate;
		this.publicaciones = new ArrayList<Publicacion>();
		this.recomendador = new RecomendadorSocial(); 			//valor por defecto
		this.seguidos = new ArrayList<Usuario>();
		this.feed = new ArrayList<Publicacion>();
	}

	public void agregarSeguido(Usuario user) {
		this.seguidos.add(user);
	}
	
	public void crearPublicacion(String titulo, String contenido) {
		Publicacion p =new Publicacion(titulo,contenido);
		this.publicaciones.add(p);
	}
	
	public void responderPublicacion (Publicacion publi, String contenido) {
		publi.agregarRespuesta(this, contenido);
	}
	
	public void darLike(Publicacion publi) {
		publi.darLike();
	}
	
	public void darDislike(Publicacion publi) {
		publi.darDislike();
	}
	
	public List<Publicacion> obtenerFeed() {
		return recomendador.obtenerPublicaciones(this);
	}
	
	
	
	// Getters and Setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public List<Usuario> getSeguidos() {
		return seguidos;
	}
	
	public List<Publicacion> getFeed() {
		return feed;
	}

	public void setRecomendador(Recomendador recomendador) {
		this.recomendador = recomendador;
	}

	public Debate getDebate() {
		return debate;
	}

	public String getContraseña() {
		return contraseña;
	}
}
