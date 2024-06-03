package ar.edu.unlp.info.oo1.ejercicio17;

public class PersonaFisica extends Persona{
	private int dni;

	public PersonaFisica(String nombre, String direccion, String numero, int dni) {
		super(nombre, direccion, numero);
		this.dni = dni;
	}

	public int getDni() {
		return dni;
	}
}
