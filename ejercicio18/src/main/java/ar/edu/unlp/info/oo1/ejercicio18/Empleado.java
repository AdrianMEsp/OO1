package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;
import java.util.*;

public class Empleado {
	private String nombre;
	private String apellido;
	private String CUIL;
	private LocalDate fechaNacimiento;
	private Boolean conyugue;
	private Boolean hijos;
	private LocalDate fechaInicio;
	private Recibo recibo;
	private List<Contrato> contratos;
	
	public Empleado(String nombre, String apellido, String CUIL, LocalDate fechaNacimiento,
			Boolean conyugue, Boolean hijos) {
		this.nombre= nombre;
		this.apellido=apellido;
		this.CUIL=CUIL;
		this.fechaNacimiento=fechaNacimiento;
		this.conyugue=conyugue;
		this.hijos= hijos;
		this.fechaInicio = LocalDate.now();
		this.contratos = new ArrayList<Contrato>();
	}
		
	public void cargarContratoHora(LocalDate fechaInicio, LocalDate fechaFin, double valorHora,
			int horasPorMes) {
		ContratoHora contrato = new ContratoHora(this,fechaInicio,valorHora, horasPorMes, fechaFin);
		this.contratos.add(contrato);
	}
	
	public void cargarContratoPlanta(LocalDate fechaInicio, double sueldoMensual, double montoConyugue,
		double montoHijo) {
		if (this.tieneContratoVencido()) {
			ContratoPlanta contrato = new ContratoPlanta(this,fechaInicio,sueldoMensual,montoConyugue, montoHijo);
			this.contratos.add(contrato);
		}
	}
	
	public boolean tieneContratoVencido() {
		return this.contratoVigente().map(contrato -> contrato.estaVencido()).orElse(null);
	}
	
	private Optional<Contrato> contratoVigente(){
		return this.contratos.stream().max((Contrato c1, Contrato c2) -> c1.getFechaInicio().compareTo(c2.getFechaInicio()));
	}
	
	public Recibo generarRecibo() {
		Recibo recibo = new Recibo(this,this.antiguedad(),LocalDate.now(),this.calcularMontoTotal());
		return recibo;
	}
		
	public int antiguedad() {
		return this.contratos.stream().mapToInt(cont -> cont.calcularAnios()).sum();
	}
	
	public boolean tieneConyugue() {
		return this.conyugue;
	}
	
	public boolean tieneHijos() {
		return this.hijos;
	}
	
	public String getCUIL() {
		return this.CUIL;
	}
	
	public double calcularAumento() {
		double antiguedad = this.antiguedad();
		if (antiguedad >= 5 && antiguedad <10) {
			return 0.3; //30%
		}else if (antiguedad >=10 && antiguedad < 15) {
			return 0.5;
		}else if (antiguedad >=15 && antiguedad < 20) {
			return 0.7;
		}else if (antiguedad >=20) {
			return 1;
		}
		return 0;
	}
	
	public double calcularMontoTotal() {
		if (!this.tieneContratoVencido()) {
			return this.contratoVigente().map(cont -> cont.calcularMonto() +
					cont.calcularMonto() * this.calcularAumento()).orElse(0d);
		}
		return 0;
	}
}
