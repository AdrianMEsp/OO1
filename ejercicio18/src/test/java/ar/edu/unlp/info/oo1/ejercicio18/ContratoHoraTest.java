package ar.edu.unlp.info.oo1.ejercicio18;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContratoHoraTest {
	private ContratoHora vencido;
	private ContratoHora noVencido;
	
	
	@BeforeEach
	void setUp() throws Exception{
		this.vencido = new ContratoHora(new Empleado("Jose","Diaz","123",LocalDate.of(2002, 10, 24),false, true),
				LocalDate.of(2015, 9, 20),100,100, LocalDate.of(2022, 10, 23));
		this.noVencido = new ContratoHora(new Empleado("Jose","Diaz","123",LocalDate.of(2002, 10, 24),false, true),
				LocalDate.of(2015, 9, 20),100,100, LocalDate.of(2023, 11, 23));
	}
	
	@Test
	void testEstaVencido() {
		assertTrue(this.vencido.estaVencido());
		assertFalse(this.vencido.estaVencido());
	}
	
	@Test
	void testCalcularMonto() {
		assertEquals(1000,this.vencido.calcularMonto());
		assertEquals(1000,this.noVencido.calcularMonto());
	}
	
	@Test
	void testCalcularAnios() {
		assertEquals(7,this.noVencido.calcularAnios());
	}
}
