package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarpetaTest {
	private Carpeta carpetaConMails;
	private Carpeta carpetaVacia;
	private Email email1;
	private Email email2;
	private Email email3;
	
	@BeforeEach
	void setup() throws Exception {
		this.carpetaConMails= new Carpeta("Carpeta Con Mails");
		this.carpetaVacia= new Carpeta("Carpeta Vacia");
		this.email1= new Email("Titulo1","cuerpo del primero");//7+18=25
		this.email2= new Email("Yo soy el 2do", "mira mi cuerpito");//13+16 =29
		this.email3= new Email("3ero no ultimo","kuchaw");//14+6=20
		
		this.carpetaConMails.recibirMail(email1);
		this.carpetaConMails.recibirMail(email2);
	}
	
	@Test
	void TestCantidadMails() {
		assertEquals(0,this.carpetaVacia.getCantidadMails());
		assertEquals(2,this.carpetaConMails.getCantidadMails());
	}
	
	@Test
	void TestMoverYEliminar() {
		this.carpetaConMails.recibirMail(email3);
		assertEquals(3,this.carpetaConMails.getCantidadMails());
		this.carpetaConMails.eliminarMail(email1);
		assertEquals(2,this.carpetaConMails.getCantidadMails());

	}
	
	@Test
	void TestBuscar() {
		assertEquals(this.email2,this.carpetaConMails.buscar("cuerpito"));
		assertEquals(null,this.carpetaVacia.buscar("Holis"));
		assertNull(this.carpetaVacia.buscar("Holis"));
	}
	
	@Test
	void TestEspacioOcupado() {
		assertEquals(54,this.carpetaConMails.espacioOcupado());
		assertEquals(0,this.carpetaVacia.espacioOcupado());
		this.carpetaConMails.recibirMail(email3);
		assertEquals(74,this.carpetaConMails.espacioOcupado());

	}
}
