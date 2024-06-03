package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
	private String nombre;
	private String direccion;
	private String numero;
	private List<RegistroLlamada> registroLlamadas;
	
	public Persona(String nombre, String direccion, String numero)
	{
		this.nombre = nombre;
		this.direccion = direccion;
		this.numero = numero;
		this.registroLlamadas = new ArrayList<RegistroLlamada>();
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public LlamadaLocal registrarLlamadoLocal (LocalDateTime fecha,int duracion,String emisor, String receptor) {
		LlamadaLocal llamada = new LlamadaLocal (fecha, duracion, emisor, receptor);
		this.registroLlamadas.add(llamada);
		return llamada;
	}
	
	public LlamadaInterurbana registrarLlamadoInterurbano (LocalDateTime fecha,int duracion,String emisor, String receptor, double distancia) {
		LlamadaInterurbana llamada = new LlamadaInterurbana (fecha, duracion, emisor, receptor, distancia);
		this.registroLlamadas.add(llamada);
		return llamada;
	}
	
	public LlamadaInternacional registrarLlamadoInternacional (LocalDateTime fecha,int duracion,String emisor, String receptor,String paisOrigen, String paisDestino) {
		LlamadaInternacional llamada = new LlamadaInternacional (fecha, duracion, emisor,receptor, paisOrigen, paisDestino);
		this.registroLlamadas.add(llamada);
		return llamada;
	}
	
	public Factura facturar(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		 Factura factura = new Factura (fechaInicio, fechaFin, this, this.calcularMontoTotal(fechaInicio, fechaFin)); 
		 return factura;
	}
	
	public double calcularMontoTotal(LocalDateTime fechaInicio, LocalDateTime fechaFin)
	{
		return this.registroLlamadas.stream().filter(llamadas -> llamadas.estaEntre(fechaInicio,fechaFin)).mapToDouble(llamadas -> llamadas.calcularCosto()).sum();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	
	public List<RegistroLlamada> getLlamadas(){
		return this.registroLlamadas;
	}
}
