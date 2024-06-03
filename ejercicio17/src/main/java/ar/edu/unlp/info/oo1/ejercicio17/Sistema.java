package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Persona> clientes;
	private List<String> numerosDisponibles;
	
	public Sistema() {
		this.numerosDisponibles = new ArrayList<String>();
		this.clientes = new ArrayList<Persona>();
	}
	
	public void agregarNumero(String numero) {
		this.numerosDisponibles.add(numero);
	}
	
	private String getNumeroFinal() {
		String num = this.numerosDisponibles.get(0);
		this.numerosDisponibles.remove(0);
		return num;
	}
	
	public PersonaFisica altaPersonaFisica(String nombre,String direccion,int dni) {
		PersonaFisica cliente = new PersonaFisica(nombre, direccion, this.getNumeroFinal(),dni);
		this.clientes.add(cliente);
		return cliente;
	}
	
	public PersonaJuridica altaPersonaJuridica(String nombre, String direccion, int CUIT, String tipoPersona) {
		PersonaJuridica cliente = new PersonaJuridica (nombre, direccion, this.getNumeroFinal(), tipoPersona,CUIT);
		this.clientes.add(cliente);
		return cliente;
	}
	
	public Persona buscarCliente(String emisor)
	{
		return this.clientes.stream().filter(persona -> persona.getNumero().equals(emisor)).findFirst().orElse(null);
	}
	
	public LlamadaLocal registrarLlamadoLocal(LocalDateTime fecha, int duracion, String emisor, String receptor)
	{
		Persona persona = this.buscarCliente(emisor);
		return persona.registrarLlamadoLocal(fecha, duracion, emisor, receptor);
		
	}
	
	public LlamadaInterurbana registrarLlamadaInterurbana(LocalDateTime fecha, int duracion, String emisor, String receptor, double distancia)
	{
		Persona persona = this.buscarCliente(emisor);
		return persona.registrarLlamadoInterurbano(fecha, duracion,emisor , receptor, distancia);
	}
	
	public RegistroLlamada registrarLlamadaInternacional (LocalDateTime fecha, int duracion, String emisor, String receptor, String paisOrigen, String paisDestino)
	{
		Persona persona = this.buscarCliente(emisor);
		return persona.registrarLlamadoInternacional(fecha, duracion,emisor, receptor, paisOrigen, paisDestino);
	}
	
	public Factura facturarLlamadas(Persona cliente, LocalDateTime fechaInicio, LocalDateTime fechaFin)
	{
		return cliente.facturar(fechaInicio, fechaFin);
	}
}
