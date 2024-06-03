package ar.edu.unlp.info.oo1.ejercicio16;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropiedadTest {
	private Propiedad prop1;
	private Propiedad prop2;
	private Propiedad prop3;
	
	private Reserva reserva1;
	private Reserva reserva2;
	private Reserva reserva3;
	
	private DateLapse lapso1;
	private DateLapse lapso2;
	private DateLapse lapso3;
	private DateLapse lapso4;
	private Politica estricta;
	private Politica flexible;
	private Politica moderada;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.prop1 = new Propiedad("nombre prop1","departamento1",100.00,"direccion del 1",estricta);
		this.prop2 = new Propiedad("nombre prop2","casa2",300.00,"direccion del 2",flexible);
		this.prop3 = new Propiedad("nombre prop3","departamento1",150.00,"direccion del 3",moderada);
		this.lapso1 = new DateLapse(LocalDate.of(2023, 10, 5),LocalDate.of(2023, 10, 15)); //5-10 al 15-10
		this.lapso2 = new DateLapse(LocalDate.of(2023, 10, 16),LocalDate.of(2023, 10, 23)); //16-10 al 23-10
		this.lapso3 = new DateLapse(LocalDate.of(2023, 11, 1),LocalDate.of(2023, 11, 15)); //1-11 al 15-11
		this.lapso4 = new DateLapse(LocalDate.of(2023, 10, 7),LocalDate.of(2023, 10, 22)); //07-10 al 22-10
		this.reserva1 =  new Reserva(this.lapso1,this.prop1); //1000
		this.reserva2 =  new Reserva(this.lapso2,this.prop2); //2100
		this.reserva3 =  new Reserva(this.lapso3,this.prop3); //2250
		this.prop1.agregarReserva(reserva1);
		this.prop2.agregarReserva(reserva2);
		this.prop3.agregarReserva(reserva3);
	
	}
	
	@Test
	void testDisponibleEntre() {
		assertTrue(this.prop1.disponibleEntre(lapso2));
		assertFalse(this.prop1.disponibleEntre(lapso1));
		assertFalse(this.prop1.disponibleEntre(lapso4));
	}
	
	@Test
	void testCalcularIngresos() {
		assertEquals(1000,this.prop1.calcularIngresos(lapso1));
		assertEquals(2100,this.prop2.calcularIngresos(lapso2));
		assertEquals(0,this.prop3.calcularIngresos(new DateLapse
				(LocalDate.of(2023, 10, 1),LocalDate.of(2023, 11, 30))));
	}
	
	
}
