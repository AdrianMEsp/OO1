package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArchivoTest {
	private Archivo archivo;
	
	@BeforeEach
	void setup() throws Exception {
		this.archivo = new Archivo("Nombre del Archivo");//18
	}
	
	@Test
	void TestTamaño() {
		assertEquals(18,this.archivo.tamaño());
	}
}
