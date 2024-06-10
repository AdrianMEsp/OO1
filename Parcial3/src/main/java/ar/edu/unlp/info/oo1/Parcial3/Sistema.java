package ar.edu.unlp.info.oo1.Parcial3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Medico> medicos;
	private List<Mascota> mascotas;
	
	public Sistema() {
		this.mascotas = new ArrayList<Mascota>();
		this.medicos = new ArrayList<Medico>();
	}
	
	public Medico registrarMedico(String nombre, LocalDate fechaIngre, double honorarios) {
		Medico m = new Medico(nombre,fechaIngre,honorarios);
		this.medicos.add(m);
		return m;
	}
	
	public Mascota registrarMascota(String nombre, LocalDate fechaNacimiento, String especie) {
		Mascota m = new Mascota(nombre, fechaNacimiento,especie);
		this.mascotas.add(m);
		return m;
	}
	
	public double recaudacionEnCachorros(LocalDate fecha) {
		return this.mascotas.stream().filter(m -> m.esCachorro()).mapToDouble(m -> m.recaudacion(fecha)).sum();
	}
}
