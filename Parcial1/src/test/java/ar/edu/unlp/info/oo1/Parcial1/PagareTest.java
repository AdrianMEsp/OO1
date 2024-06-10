package ar.edu.unlp.info.oo1.Parcial1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PagareTest {
	private Pagare pagareVencidoMismoDia;
	private Pagare pagareVencido;
	private Pagare pagareNoVencido;
	
	@BeforeEach
	void setUp() throws Exception{
		this.pagareVencidoMismoDia = new Pagare("Origen","Destino",LocalDate.now().minusDays(5),2050.5, LocalDate.now());
		this.pagareVencido = new Pagare("Origen","Destino",LocalDate.now().minusDays(5),2050.5, LocalDate.now().minusDays(2));
		this.pagareNoVencido = new Pagare("Origen","Destino",LocalDate.now(),2050.5, LocalDate.now().plusDays(25));
	}
	
	@Test
	void testEstaVencido() {
		assertTrue(this.pagareVencidoMismoDia.estaVencido());
		assertTrue(this.pagareVencido.estaVencido());
		
		assertFalse(this.pagareNoVencido.estaVencido());
	}
	
	 
}
