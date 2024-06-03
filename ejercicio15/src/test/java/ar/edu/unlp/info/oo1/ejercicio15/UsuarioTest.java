package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	private Usuario propietario1;
	private Usuario propietarioSinProp;
	private Usuario inquilino1;
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	private Reserva reserva1;
	private Reserva reserva2;
	private DateLapse lapso1;
	private DateLapse lapso2; //sin alqui
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.propietario1= new Usuario ("propietario1","direccion del 1",25369456);
		this.propietarioSinProp= new Usuario ("propietario sin nada","direccion del pobre",27369456);
		this.propiedad1= new Propiedad ("propiedad 1","soy el depto 1",100,"direccion del 1",this.propietario1);
		this.propiedad2 = new Propiedad("propiedad 2","soy el depto 1",200,"direccion del 1",this.propietario1);
		this.inquilino1 = new Usuario ("futuro inquilino","direccion del inquilino",25369456);
		this.lapso1 = new DateLapse(LocalDate.of(2023, 10, 12),LocalDate.of(2023, 10, 27));
		this.lapso2 = new DateLapse(LocalDate.of(2023, 11, 12),LocalDate.of(2023, 11, 27));
		this.reserva1 = new Reserva(this.lapso1,this.propiedad1);
		this.reserva2 = new Reserva(this.lapso2,this.propiedad2);
		this.propietario1.agregarInmueble(propiedad1);
		this.propietario1.agregarInmueble(propiedad2);
	}
	
	@Test
	void testAgregarInmueble() {
		assertEquals(2,this.propietario1.obtenerPropiedades().size());
		assertEquals(0,this.propietarioSinProp.obtenerPropiedades().size());
	}
	
	@Test
	void testAgregarReserva() {
		assertEquals(0,this.inquilino1.obtenerReservas().size());
		this.inquilino1.agregarReserva(this.reserva1);
		assertEquals(1,this.inquilino1.obtenerReservas().size());
		this.inquilino1.agregarReserva(this.reserva2);
		assertEquals(2,this.inquilino1.obtenerReservas().size());
	}
	
	@Test
	void testEliminarReserva() {
		this.inquilino1.agregarReserva(this.reserva1);
		assertEquals(1,this.inquilino1.obtenerReservas().size());
		this.inquilino1.eliminarReserva(this.reserva1);
		assertEquals(0,this.inquilino1.obtenerReservas().size());
	}
	
	@Test
	void testObtenerIngresosEntre() {
		assertEquals(2,this.propietario1.obtenerPropiedades().size());//chequeo cant prop
		assertEquals(0,this.propietario1.obtenerIngresosEntre(lapso1));
		assertEquals(0,this.propietarioSinProp.obtenerIngresosEntre(lapso2));
		this.inquilino1.agregarReserva(reserva1);
		this.propiedad1.agregarReserva(reserva1);
		
		this.inquilino1.agregarReserva(reserva2);
		this.propiedad2.agregarReserva(reserva2);

		assertEquals(1500,this.propietario1.obtenerIngresosEntre(lapso1));
		assertEquals(3000,this.propietario1.obtenerIngresosEntre(lapso2));
	}
}
