package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaDeAlquilerTest {
	private SistemaDeAlquiler sistema;
	private Usuario usuarioConReservas;
	private Usuario usuarioSinReservas;
	private Usuario propietarioConProp;
	private Usuario propietarioSinProp;
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	private Reserva reserva1;
	private Reserva reserva2;
	private Reserva reserva3;
	private DateLapse lapso1;
	private DateLapse lapso2;
	private DateLapse lapso3;
	
	@BeforeEach
	void setUp() throws Exception{
		this.sistema = new SistemaDeAlquiler();
		this.usuarioConReservas = this.sistema.registrarUsuario("Usuario Con reservas", " direccion usuario reservas", 40357789);
		this.usuarioSinReservas = this.sistema.registrarUsuario("Pedro Sin alquiler", "no tiene xD", 41587856);
		this.propietarioConProp = this.sistema.registrarUsuario("Tengo un monoambiente", "43 n789", 23547778);
		this.propietarioSinProp = this.sistema.registrarUsuario("No tengo prop", "no tiene", 16456987);
		this.propiedad1 = this.sistema.registrarPropiedad("Propiedad1", "departamento", 50, "47 e/ 5 y 8", propietarioConProp);
		this.propiedad2 = this.sistema.registrarPropiedad("Propiedad 2", "Casa grande", 100, "50 661", propietarioConProp);
		this.propietarioConProp.agregarInmueble(propiedad1);
		this.propietarioConProp.agregarInmueble(propiedad2);
		
		this.lapso1 = new DateLapse(LocalDate.of(2023, 10, 5), LocalDate.of(2023, 10, 15)); 
		this.lapso2 = new DateLapse(LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 6)); 
		this.lapso3 = new DateLapse(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 15));
		
		this.reserva1 = new Reserva(this.lapso1,propiedad1);
		this.reserva2 = new Reserva(this.lapso2,propiedad2);
		this.reserva3 = new Reserva(this.lapso3,propiedad2);
	}
	
	@Test
	void testListarPropiedadesDisponibles() {
		assertEquals(2,this.sistema.listarPropiedadesDisponibles(lapso1).size());
		this.propiedad1.agregarReserva(reserva1);
		assertEquals(1,this.sistema.listarPropiedadesDisponibles(lapso1).size());
	}
	
	@Test
	void testHacerReserva() {
		assertNotNull(this.sistema.hacerReserva(propiedad1, lapso1, usuarioConReservas));
		assertNull(this.sistema.hacerReserva(propiedad1, lapso1, usuarioConReservas));
		assertNotNull(this.sistema.hacerReserva(propiedad1, lapso3, usuarioConReservas));
	}
	
	@Test
	void testCancelarReserva() {
		this.reserva1 = this.sistema.hacerReserva(propiedad1, lapso1, usuarioConReservas);
		this.reserva2 = this.sistema.hacerReserva(propiedad2, lapso2, usuarioConReservas);
		this.reserva3 = this.sistema.hacerReserva(propiedad2, lapso3, usuarioConReservas);
		assertEquals(0,this.sistema.listarPropiedadesDisponibles(lapso1).size());
		assertEquals(0,this.sistema.listarPropiedadesDisponibles(lapso2).size());
		assertEquals(1,this.sistema.listarPropiedadesDisponibles(lapso3).size());
		//fechas que ya pasaron, no se pueden cancelar
		this.sistema.cancelarReserva(this.reserva1);
		this.sistema.cancelarReserva(this.reserva2);
		//fecha que no paso  
		this.sistema.cancelarReserva(this.reserva3);
		assertEquals(0,this.sistema.listarPropiedadesDisponibles(lapso1).size());
		assertEquals(0,this.sistema.listarPropiedadesDisponibles(lapso2).size());
		assertEquals(2,this.sistema.listarPropiedadesDisponibles(lapso3).size());
	}
	
	@Test
	void testObtenerReserva() {
		this.reserva1 = this.sistema.hacerReserva(propiedad1, lapso1, usuarioConReservas);
		assertEquals(1,this.sistema.obtenerReserva(usuarioConReservas).size());
		assertEquals(0,this.sistema.obtenerReserva(usuarioSinReservas).size());
	}
	
	@Test
	void testObtenerIngresosPropietarios() {
		this.reserva1 = this.sistema.hacerReserva(propiedad1, lapso1, usuarioConReservas);//500
		this.reserva2 = this.sistema.hacerReserva(propiedad2, lapso2, usuarioConReservas);//500
		this.reserva3 = this.sistema.hacerReserva(propiedad2, lapso3, usuarioConReservas);//1400
		
		// me toma si o si toda la reserva y no el exacto
		// es decir que si pongo el 3 y la reserva arranca el 1, este me hace la suma desde el 1
		// lo mismo para el final de la reserva
		assertEquals(1000,this.sistema.obtenerIngresosPropietarios(propietarioConProp, new DateLapse(LocalDate.of(2023, 10, 1),LocalDate.of(2023, 10, 16))));
		assertEquals(1000, this.sistema.obtenerIngresosPropietarios(propietarioConProp, new DateLapse(LocalDate.of(2023, 10, 4),LocalDate.of(2023, 10, 16))));
		assertEquals(2400, this.sistema.obtenerIngresosPropietarios(propietarioConProp, new DateLapse(LocalDate.of(2023, 10, 4),LocalDate.of(2023, 11, 16))));
		
		assertEquals(0,this.sistema.obtenerIngresosPropietarios(propietarioSinProp, lapso1));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
