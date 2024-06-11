package ar.edu.unlp.info.oo1.Parcial4;

import java.time.LocalDate;
import java.util.*;

public class Sistema {
	private List<Cliente> clientes;
	private List<Servicio> servicios;
	
	public Sistema () {
		this.clientes = new ArrayList<Cliente>();
		this.servicios = new ArrayList<Servicio>();
	}
	
	public Cliente registarCliente(String nombre, String direcc) {
		Cliente c = new Cliente (nombre,direcc);
		this.clientes.add(c);
		return c;
	}
	
	public Limpieza registarLimpieza(double precioHora,int cantHoras
			,double tarifa) {
		Limpieza l = new Limpieza(tarifa,precioHora,cantHoras);
		this.servicios.add(l);
		return l;
	}
	
	public Parquizacion registrarParquizacion(double precioHora, int cantHoras
			, int cantMaquinas, double costoMantenimiento) {
		Parquizacion p = new Parquizacion (precioHora, cantHoras, cantMaquinas, costoMantenimiento);
		this.servicios.add(p);
		return p;
	}
	
	public void contratarUnica(Cliente c, Servicio s, LocalDate fechaInicio) {
		Contratacion contrato = new Contratacion (s,fechaInicio);
		c.contratar(contrato);
	}
	
	public void contratarProlongada(Cliente c, Servicio s, LocalDate fechaInicio, int dias) {
		ContratacionProlongada contratoProlong = new ContratacionProlongada(s,fechaInicio,dias);
		c.contratar(contratoProlong);
	}
	
	public int serviciosMayorA(double monto) {
		return (int) this.servicios.stream().filter(servi -> servi.montoAPagar() > monto).count();
	}
	
}
