package ar.edu.unlp.info.oo1.ejercicio15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaDeAlquiler {
	private List<Propiedad> propiedades = new ArrayList<Propiedad>();;
	private List<Usuario> usuarios = new ArrayList<Usuario>();;
		
	public Usuario registrarUsuario(String nombre, String direccion, int dni) {
		Usuario usuario = new Usuario (nombre, direccion, dni);
		this.usuarios.add(usuario);
		return usuario;
	}
	
	public Propiedad registrarPropiedad(String nombre, String descripcion, double precioNoche, String direccion, Usuario propietario) {
		Propiedad propiedad = new Propiedad(nombre, descripcion, precioNoche, direccion,propietario);
		this.propiedades.add(propiedad);
		return propiedad;
	}
	
	public List<Propiedad> listarPropiedadesDisponibles(DateLapse periodo) {
		return this.propiedades.stream().filter(propiedad -> propiedad.disponibilidad(periodo)).collect(Collectors.toList());
	}
	
	public Reserva hacerReserva( Propiedad propiedad, DateLapse periodo, Usuario inquilino) {
		if (propiedad.disponibilidad(periodo)) {
			Reserva reserva = new Reserva(periodo, propiedad);
			inquilino.agregarReserva(reserva);
			propiedad.agregarReserva(reserva);
			return reserva;
		}
		return null;
	}
	
	public void cancelarReserva( Reserva reserva) {
		if (reserva.inicioPosteriorActual()) {
			this.usuarios.stream().forEach(usuario -> usuario.eliminarReserva(reserva));
			this.propiedades.stream().forEach(propiedades -> propiedades.eliminarReserva(reserva));
		}
	}
	
	public List<Reserva> obtenerReserva(Usuario usuario){
		return usuario.obtenerReservas();
	}
	
	public double obtenerIngresosPropietarios(Usuario propietario,DateLapse periodo ) {
		return propietario.obtenerIngresosEntre(periodo);
	}
}
