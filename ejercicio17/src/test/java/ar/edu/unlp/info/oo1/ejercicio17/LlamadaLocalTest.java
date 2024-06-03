package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LlamadaLocalTest {
	private LlamadaLocal llamada1;
	
	@BeforeEach
	void setUp() throws Exception {
		this.llamada1 = new LlamadaLocal(LocalDateTime.of(2023, 10, 10, 8, 15),20,"2215662746","2215662748");
	}
	
	@Test
	void testCalcularCosto() {
		assertEquals(20,this.llamada1.calcularCosto());
	}
}