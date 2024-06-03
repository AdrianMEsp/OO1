package ar.edu.unlp.info.oo1.ejercicio7;

public class TestEmpleado {
	
	public static void main(String [] args) {
		
		Gerente alan = new Gerente ("Alan Turing");
		double aportesDeAlan = alan.aportes();
		
		Gerente keanu = new Gerente ("Keanu Reeves");
		double sueldoBasicoDeKeanu = keanu.sueldoBasico();
		
		System.out.println("1) "+aportesDeAlan);
		System.out.print("2) "+sueldoBasicoDeKeanu);
		
	}
}
