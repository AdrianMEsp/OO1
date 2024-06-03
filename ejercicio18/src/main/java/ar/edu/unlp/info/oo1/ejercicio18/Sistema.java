package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Sistema {
	private List<Empleado> empleados;
	
	public Sistema() {
		this.empleados = new ArrayList<Empleado>();
	}
	
	public Empleado altaEmpleado(String nombre, String apellido, String CUIL, 
			LocalDate fechaNacimiento, Boolean conyugue, Boolean hijos) {
		Empleado empleado = new Empleado(nombre, apellido, CUIL, fechaNacimiento, conyugue, hijos);
		this.empleados.add(empleado);
		return empleado;
	}
	
	public Empleado buscarEmpleado(int CUIL) {
		return this.empleados.stream().filter(emp -> emp.getCUIL().equals(CUIL)).findFirst().orElse(null);
	}
	
	public void bajaEmpleado(Empleado empleado) {
		this.empleados.remove(empleado);
	}
	
	public void cargarContratoHoras(Empleado empleado,LocalDate fechaInicio,LocalDate fechaFin ,
			double valorHora, int horasPorMes ) {
		empleado.cargarContratoHora(fechaInicio, fechaFin, valorHora, horasPorMes);
	}
	
	public void cargarContratoPlanta(Empleado empleado, LocalDate fechaInicio, double sueldoMensual,
			double montoConyugue,double montoHijo ) {
		empleado.cargarContratoPlanta(fechaInicio, sueldoMensual, montoConyugue, montoHijo);
	}
	
	public List<Empleado> obtenerEmpleadosContratosVencidos(){
		return this.empleados.stream().filter(emp -> emp.tieneContratoVencido()).collect(Collectors.toList());
	}
	
	public List<Recibo> generarRecibosSueldo(){
		return this.empleados.stream().map(emp -> emp.generarRecibo()).collect(Collectors.toList());
	}
}
