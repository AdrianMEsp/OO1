package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropiedadTest {
	private Propiedad propiedad1;
	private Reserva reserva1;
	private Usuario propietario1;
	private DateLapse lapso1;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.propietario1= new Usuario("Propietario 1","direccion del 1",25365478);
		this.propiedad1 = new Propiedad("propiedad 1","depto",50,"direccion propiedad 1",propietario1);
		this.lapso1=new DateLapse(LocalDate.of(2023, 10, 5),LocalDate.of(2023, 10, 15));
		this.reserva1 = new Reserva(this.lapso1,this.propiedad1);
	}
	
	@Test
	void testDisponibilidad() {
		assertEquals(true,this.propiedad1.disponibilidad(lapso1));
		this.propiedad1.agregarReserva(reserva1);
		assertEquals(false,this.propiedad1.disponibilidad(lapso1));
		this.propiedad1.eliminarReserva(reserva1);
		assertEquals(true,this.propiedad1.disponibilidad(lapso1));
	}
	
	@Test
	void testObtenerIngresosEntre() {
		assertEquals(0,this.propiedad1.obtenerIngresosEntreP(lapso1));
		this.propiedad1.agregarReserva(reserva1);
		assertEquals(500,this.propiedad1.obtenerIngresosEntreP(lapso1));
		assertEquals(0,this.propiedad1.obtenerIngresosEntreP(new DateLapse(LocalDate.of(2023, 11, 1),LocalDate.of(2023, 11, 5))));
	}
}
