package ar.edu.unlp.info.oo1.ejercicio16;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaDeAlquiler {
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Propiedad> propiedades = new ArrayList<Propiedad>();
	
	public Usuario registrarUsuario(String nombre, String direcc, int dni) {
		Usuario usuario = new Usuario(nombre,direcc,dni);
		this.usuarios.add(usuario);
		return usuario;
	}
	public Propiedad registrarPropiedad(String nombre, String descripcion, double precioPorNoche,String direccion, Politica politica) {
		Propiedad propiedad = new Propiedad(nombre, descripcion, precioPorNoche, direccion,politica);
		this.propiedades.add(propiedad);
		return propiedad;
	}
	
	public List<Propiedad> buscarDisponiblesEntre(DateLapse lapso){
		return this.propiedades.stream().filter(propiedades -> propiedades.disponibleEntre(lapso)).collect(Collectors.toList());		
	}
	
	public void cancelarReserva(Reserva reservaACancelar) {
		if (reservaACancelar.inicioPosteriorActual()) {
			this.usuarios.stream().forEach(usuario -> usuario.eliminarReserva(reservaACancelar));
			this.propiedades.stream().forEach(propiedades -> propiedades.cancelarReserva(reservaACancelar));
		}
	}
	
	public List<Reserva> obtenerReservas(Usuario usuario){
		return usuario.obternerReservas();
	}
	
	public double ingresosPropietarioEntre(Usuario usuario, DateLapse periodo) {
		return usuario.calcularIngresosEntre(periodo);
	}
		
	
}
