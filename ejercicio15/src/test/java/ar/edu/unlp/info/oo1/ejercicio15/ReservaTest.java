package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReservaTest {
	private Reserva reserva;
	private Reserva reserva2;
	private DateLapse lapso1;
	private DateLapse lapso2;
	private DateLapse lapso3;
	private DateLapse lapso4;
	private Propiedad propiedad1;
	private Usuario propietario1;

	
	@BeforeEach
		void setUp() throws Exception {
		this.propietario1 = new Usuario ("propietario1","direccion del 1",25369456);
		this.propiedad1 = new Propiedad ("propiedad 1","soy el depto 1",100,"direccion del 1",this.propietario1);
		this.lapso1 = new DateLapse(LocalDate.of(2023, 10, 5),LocalDate.of(2023, 10, 10));
		this.lapso2 = new DateLapse(LocalDate.of(2023, 10, 10),LocalDate.of(2023, 10, 20));
		this.lapso3 = new DateLapse(LocalDate.of(2023, 10, 6),LocalDate.of(2023, 10, 17));
		this.lapso4 = new DateLapse(LocalDate.of(2025, 11, 6),LocalDate.of(2025, 11, 17));
		this.reserva = new Reserva(lapso1,propiedad1);
		this.reserva2 = new Reserva(lapso4,propiedad1);
		
	}
	
	@Test
	void testPrecioReserva() { //solamente puede existir. si no existe no aplica el test
		assertEquals(500,this.reserva.precioReserva());
	}
	
	@Test
	void testOverlaps() {
		assertTrue(this.reserva.overlaps(lapso1));
		assertFalse(this.reserva.overlaps(lapso2));
		assertTrue(this.reserva.overlaps(lapso3));
	}
	
	@Test 
	void testInicioPosteriorActual() {
		assertFalse(this.reserva.inicioPosteriorActual());
		assertTrue(this.reserva2.inicioPosteriorActual());
	}	
	
}
