package ar.edu.unlp.info.oo1.Parcial6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Debate {
	private List<Usuario> usuarios;
	
	public Debate() {
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public void crearUsuario(String nombre, String contraseña) {
		this.usuarios.add(new Usuario(nombre,contraseña,this));
	}
	
	public List<Publicacion> obtenerTodasLasPublicaciones(){
		return this.usuarios.stream().flatMap(usuario -> usuario.getPublicaciones().stream())
		.collect(Collectors.toList());
	}
}
