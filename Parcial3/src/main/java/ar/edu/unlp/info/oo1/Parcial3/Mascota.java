package ar.edu.unlp.info.oo1.Parcial3;

import java.time.LocalDate;
import java.util.List;

public class Mascota {
	private String nombre;
	private LocalDate fechaNacimiento;
	private String especie;
	private List<Servicio> servicios;
	
	public Mascota(String nombre, LocalDate fecha, String especie) {
		this.nombre=nombre;
		this.fechaNacimiento=fecha;
		this.especie=especie;
	}
	
	public ConsultaMedica registrarConsultaMedica(Medico medico) {
		ConsultaMedica c = new ConsultaMedica(medico);
		this.servicios.add(c);
		return c;
	}
	
	public Vacunacion registrarVacunacion(String nombre, double costo,Medico medico) {
		Vacunacion v = new Vacunacion(nombre,costo,medico);
		this.servicios.add(v);
		return v;
	}
	
	public Guarderia registrarGuarderia(int dias) {
		Guarderia g = new Guarderia(dias);
		this.servicios.add(g);
		return g;
	}
	
	public boolean esCachorro() {
		return (this.fechaNacimiento.isBefore(LocalDate.now().minusDays(730)));
		//730 es 2 años
	}
	
	public double recaudacion(LocalDate fecha) {
		return this.servicios.stream().mapToDouble(ser -> ser.recaudacionEn(fecha)).sum();
	}
	
	
	//---------------//
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

		
}
