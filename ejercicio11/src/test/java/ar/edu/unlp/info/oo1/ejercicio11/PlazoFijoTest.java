package ar.edu.unlp.info.oo1.ejercicio11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlazoFijoTest {
	private PlazoFijo plazoFijo;
	
	@BeforeEach
	void setUp() throws Exception {
		LocalDate fecha= LocalDate.now().minus(10, ChronoUnit.DAYS);
		plazoFijo = new PlazoFijo(fecha,100,0.05);
	}
	
	@Test
	void testConstructor() {
		assertEquals(LocalDate.now().minus(10, ChronoUnit.DAYS), plazoFijo.getFechaDeConstitucion());
		assertEquals(100, plazoFijo.getMontoDepositado());
		assertEquals(0.05,plazoFijo.getPorcentajeDeInteresDiario());
	}
	
	void testValorActual() {
		//100 + 0.05 * 10 (5% * dias)
		assertEquals(150,plazoFijo.valorActual());
	}
}
