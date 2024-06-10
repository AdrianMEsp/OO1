package ar.edu.unlp.info.oo1.Parcial1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChequeTest {
	private Cheque cheque;
	private Cheque chequeVencido30;
	private Cheque chequeVencidoMayor30;
	
	@BeforeEach
	void setUp() throws Exception{
		this.cheque = new Cheque("Destinatario","Origen",LocalDate.now().minusDays(10),1050.50);
		this.chequeVencido30 = new Cheque("Destinatario","Origen",LocalDate.now().minusDays(30),1050.50);
		this.chequeVencidoMayor30 = new Cheque("Destinatario","Origen",LocalDate.now().minusDays(31),1050.50);
	}
	
	@Test
	void testEstaVencido() {
		assertFalse(this.cheque.estaVencido());
		assertTrue(this.chequeVencido30.estaVencido());
		assertTrue(this.chequeVencidoMayor30.estaVencido());
	}
}
