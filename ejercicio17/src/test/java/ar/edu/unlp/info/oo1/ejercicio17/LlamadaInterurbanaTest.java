package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LlamadaInterurbanaTest {
	private LlamadaInterurbana llamada1;
	private LlamadaInterurbana llamada2;
	private LlamadaInterurbana llamada3;
	
	@BeforeEach
	void setUp() throws Exception {
		this.llamada1 = new LlamadaInterurbana(LocalDateTime.of(2023, 10, 10, 8, 15),20,"2215662746","2215662748",99);
		this.llamada2 = new LlamadaInterurbana(LocalDateTime.of(2023, 10, 10, 8, 15),20,"2215662749","2215662748",500);
		this.llamada3 = new LlamadaInterurbana(LocalDateTime.of(2023, 10, 10, 8, 15),20,"2215662745","2215662748",150);
	}
	
	@Test
	void testCalcularCosto() {
		assertEquals(45,this.llamada1.calcularCosto());
		assertEquals(65,this.llamada2.calcularCosto());
		assertEquals(55,this.llamada3.calcularCosto());
	}
	
}
