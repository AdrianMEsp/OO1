package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteDeCorreoTest {
	private ClienteDeCorreo cliente;
	private Carpeta inbox;
	private Carpeta carpeta;
	private Email email1;
	private Email email2;
	
	@BeforeEach
	void setUp() throws Exception{
		this.inbox = new Carpeta("Soy el inbox");
		this.cliente = new ClienteDeCorreo(this.inbox);
		this.carpeta= new Carpeta("Tengo Mails");
		this.email1= new Email("Mail 1" , "123456789");
		this.email2= new Email("Mail 2" , "asdfghjklñ");
		this.inbox.recibirMail(email1);
	}
	
	@Test
	void testRecibirMoverMails() {
		this.inbox.recibirMail(email2);
		assertEquals(2,this.inbox.getCantidadMails());
		this.cliente.mover(email1, inbox, carpeta);
		assertEquals(1,this.inbox.getCantidadMails());
		assertEquals(1,this.carpeta.getCantidadMails());
	}
	
	@Test
	void testBuscar() {
		this.inbox.recibirMail(email2);
		assertEquals(this.email1,this.inbox.buscar("1234"));
		this.cliente.mover(email1, inbox, carpeta);
		assertEquals(null,this.inbox.buscar("1234"));
		assertEquals(this.email1,this.carpeta.buscar("1234"));
	}

	@Test
	void testEspacio() {
		assertEquals(15,this.email1.espacioOcupado()); //contar caracteres
		this.inbox.recibirMail(email2);
		assertEquals(31,this.inbox.espacioOcupado()); //15+16=30 (titulo + texto)
	}
	
	
}
