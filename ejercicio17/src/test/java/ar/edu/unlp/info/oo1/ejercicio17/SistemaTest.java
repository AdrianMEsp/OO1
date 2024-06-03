package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
	private Sistema sistema = new Sistema();
	private PersonaJuridica persoJuri1;
	private PersonaFisica persoFisi1;
	
	@BeforeEach
	void setUp() throws Exception {
		this.sistema.agregarNumero("2215662746");
		this.sistema.agregarNumero("2215662747");
		this.sistema.agregarNumero("2215662748");
		
		this.persoFisi1= this.sistema.altaPersonaFisica("Juan","la calle de juan", 38669307);
		this.persoJuri1= this.sistema.altaPersonaJuridica("Corpo", "direccion corpo", 2038669307,"Sociedad anonima");
		
	}
	
	@Test
	void testRegistrarLlamada() {
		this.sistema.registrarLlamadoLocal(LocalDateTime.of(2023, 10, 6, 16, 31), 10, "2215662746", "2215662747");
		//Factura factura1 = this.sistema.facturarLlamadas(persoFisi1, LocalDateTime.of(2022, 10, 6, 16, 29), LocalDateTime.of(2022, 10, 6, 16, 37));
		this.sistema.registrarLlamadoLocal(LocalDateTime.of(2023, 10, 6, 16, 35), 10, "2215662746", "2215662747");
		assertEquals(2,this.persoFisi1.getLlamadas().size());
	}
	
	@Test
	void testFacturarLlamadas() {
		this.sistema.registrarLlamadoLocal(LocalDateTime.of(2023, 10, 6, 16, 31), 10, "2215662746", "2215662747");
		Factura factura1 = this.sistema.facturarLlamadas(persoFisi1, LocalDateTime.of(2023, 9, 6, 16, 31), LocalDateTime.of(2023, 10, 9, 16, 31));
		assertEquals(10,factura1.getMontoTotal());
		
		this.sistema.registrarLlamadaInterurbana(LocalDateTime.of(2023, 10, 6, 16, 31), 20, "2215662746", "2215662747", 99);
		Factura factura2 = this.sistema.facturarLlamadas(persoFisi1, LocalDateTime.of(2023, 9, 6, 16, 31), LocalDateTime.of(2023, 10, 9, 16, 31));
		assertEquals(55,factura2.getMontoTotal()); 
		
		this.sistema.registrarLlamadaInterurbana(LocalDateTime.of(2023, 10, 6, 16, 31), 20, "2215662746", "2215662747", 100);
		Factura factura3 = this.sistema.facturarLlamadas(persoFisi1, LocalDateTime.of(2023, 9, 6, 16, 31), LocalDateTime.of(2023, 10, 9, 16, 31));
		assertEquals(110,factura3.getMontoTotal()); //estos van sumando la factura anterior por ser de la misma persona emisora
		
		this.sistema.registrarLlamadaInterurbana(LocalDateTime.of(2023, 10, 6, 16, 31), 20, "2215662746", "2215662747", 500);
		Factura factura4 = this.sistema.facturarLlamadas(persoFisi1, LocalDateTime.of(2023, 9, 6, 16, 31), LocalDateTime.of(2023, 10, 9, 16, 31));
		assertEquals(175,factura4.getMontoTotal()); //estos van sumando la factura anterior por ser de la misma persona emisora
		
		this.sistema.registrarLlamadaInternacional(LocalDateTime.of(2023, 10, 6, 16, 31), 20, "2215662747", "2215662746", "Argentina","Alemania");
		Factura factura5 = this.sistema.facturarLlamadas(persoJuri1, LocalDateTime.of(2023, 10, 6, 16, 31), LocalDateTime.of(2023, 11, 6, 16, 31));
		assertEquals(80,factura5.getMontoTotal());
	}
}
