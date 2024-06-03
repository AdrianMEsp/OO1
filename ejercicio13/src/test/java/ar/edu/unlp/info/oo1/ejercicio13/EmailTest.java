package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailTest {
	private Email emailConAdjuntos;
	private Email emailSinAdjuntos;
	private Archivo archivo1;
	private Archivo archivo2;
	
	@BeforeEach
	void setup() throws Exception{
		this.emailSinAdjuntos = new Email("Mail1","Cuerpo del 1");//5+12
		this.emailConAdjuntos = new Email("Soy el mail 2","Y este es mi cuerpo");//13+19
		this.archivo1 = new Archivo ("Archivito 1");//11
		this.archivo2 = new Archivo ("El archivo dos es mejor");//23
	}
	
	@Test
	void TestConstructor() {
		assertEquals("Mail1",this.emailSinAdjuntos.getTitulo());
		assertEquals("Y este es mi cuerpo",this.emailConAdjuntos.getCuerpo());
		assertNotNull(this.emailConAdjuntos.adjuntos()); //esta iniciado, por ende existe y no es null
	}
	
	@Test
	void TestBuscar() {
		assertEquals(true,this.emailConAdjuntos.buscar("cuerpo"));
		assertEquals(false,this.emailConAdjuntos.buscar("Locura"));
	}
	
	@Test
	void TestEspacioOcupado(){
		assertEquals(32,this.emailConAdjuntos.espacioOcupado());
		this.emailConAdjuntos.agregarArchivo(archivo1);
		assertEquals(43,this.emailConAdjuntos.espacioOcupado());
		assertEquals(17,this.emailSinAdjuntos.espacioOcupado());
		this.emailConAdjuntos.agregarArchivo(archivo2);
		assertEquals(66,this.emailConAdjuntos.espacioOcupado());

	}
}
