package ar.edu.unlp.info.oo1.ejercicio18;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {
	private Empleado empContratoVencido;
	private Empleado empContratoVigente;
	private Empleado empleado4anios;
	private Empleado empleado5anios;
	private Empleado empleado10anios;
	private Empleado empleado15anios;
	private Empleado empleado20anios;
	
	@BeforeEach
	void setUp() throws Exception{
		this.empContratoVencido = new Empleado("Jose","Diaz","20358898",LocalDate.of(1985, 10, 5),false, true);
		this.empContratoVigente = new Empleado("Juan","Martinez","203558548",LocalDate.of(1974, 5, 3),false, true);
		
		this.empleado4anios = new Empleado("Jose","Diaz","20358898",LocalDate.of(1985, 10, 5),false, true);
		this.empleado5anios = new Empleado("Maria","Diaz","20358898",LocalDate.of(1985, 10, 5),false, true);
		this.empleado10anios = new Empleado("Marcos","Diaz","20358898",LocalDate.of(1985, 10, 5),false, true);
		this.empleado15anios = new Empleado("Ana","Diaz","20358898",LocalDate.of(1985, 10, 5),false, true);
		this.empleado20anios = new Empleado("Agus","Diaz","20358898",LocalDate.of(1985, 10, 5),false, true);
		
		this.empContratoVencido.cargarContratoHora(LocalDate.of(2021, 10, 7),LocalDate.of(2022, 10, 7), 10, 100);
		this.empContratoVigente.cargarContratoHora(LocalDate.of(2023, 10, 7),LocalDate.of(2023, 12, 7), 10, 100);
	
		this.empleado4anios.cargarContratoHora(LocalDate.of(2015, 9, 20), LocalDate.of(2017, 10, 23), 100, 100);
		this.empleado5anios.cargarContratoHora(LocalDate.of(2018, 11, 02), LocalDate.of(2020, 11, 02), 100, 100);
		this.empleado5anios.cargarContratoPlanta(LocalDate.of(2017, 10, 24), 100, 100, 100);
		this.empleado10anios.cargarContratoHora(LocalDate.of(2012, 9, 20), LocalDate.of(2022, 10, 23), 100, 100);
		this.empleado10anios.cargarContratoPlanta(LocalDate.of(2022, 10, 24), 100, 100, 100);
		this.empleado15anios.cargarContratoHora(LocalDate.of(2007, 9, 20), LocalDate.of(2012, 10, 23), 100, 100); 
		this.empleado15anios.cargarContratoPlanta(LocalDate.of(2012, 10, 24), 100, 100, 100);
		this.empleado20anios.cargarContratoHora(LocalDate.of(2002, 9, 20), LocalDate.of(2022, 10, 23), 100, 100);
		this.empleado20anios.cargarContratoHora(LocalDate.of(2022, 10, 23), LocalDate.of(2024, 11, 23), 100, 100);
	
	}
	
	@Test
	void testTieneContratoVencido() {
		assertTrue(this.empContratoVencido.tieneContratoVencido());
		assertFalse(this.empContratoVigente.tieneContratoVencido());
	}
	
	@Test
	void testAntiguedad() {
		assertEquals(4,this.empleado4anios.antiguedad());
		assertEquals(5,this.empleado5anios.antiguedad());
		assertEquals(10,this.empleado10anios.antiguedad());
		assertEquals(15,this.empleado15anios.antiguedad());
		assertEquals(20,this.empleado20anios.antiguedad());
	}
	
	@Test
	void testCalcularAumento() {
		assertEquals(0,this.empleado4anios.antiguedad());
		assertEquals(0.3,this.empleado5anios.antiguedad());
		assertEquals(0.5,this.empleado10anios.antiguedad());
		assertEquals(0.7,this.empleado15anios.antiguedad());
		assertEquals(1,this.empleado20anios.antiguedad());
	}
	
	@Test
	void testCalcularMontoTotal() {
		assertEquals(0,this.empleado4anios.antiguedad());
		assertEquals(260,this.empleado5anios.antiguedad());
		assertEquals(300,this.empleado10anios.antiguedad());
		assertEquals(340,this.empleado15anios.antiguedad());
		assertEquals(20000,this.empleado20anios.antiguedad());
	}
}
