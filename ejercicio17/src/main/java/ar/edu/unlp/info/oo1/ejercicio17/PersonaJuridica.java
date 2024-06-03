package ar.edu.unlp.info.oo1.ejercicio17;

public class PersonaJuridica extends Persona {
	private int cuit;
	private String tipo;
	
	public PersonaJuridica (String nombre, String direccion, String numero, String tipo, int cuit)
	{
		super(nombre, direccion,numero);
		this.cuit=cuit;
		this.tipo = tipo;
	}

	public int getCuit() {
		return cuit;
	}

	public String getTipo() {
		return tipo;
	}
	
}
