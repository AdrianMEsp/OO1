package ar.edu.unlp.info.oo1.ejercicio16;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaDeAlquilerTest {
	private SistemaDeAlquiler sistema;
	private Propiedad prop1;
	private Propiedad prop2;
	private Propiedad prop3;
	
	private Usuario inquilinoConAlquileres;
	private Usuario inquilinoSinAlquileres;
	private Usuario propietarioConProp;
	private Usuario propietarioSinProp;
	
	private DateLapse lapso1;
	private DateLapse lapso2;
	private DateLapse lapso3;
	private DateLapse lapso4;
	private DateLapse lapso5;
	
	private Reserva reserva1;
	private Reserva reserva2;
	private Reserva reserva3;
	
	private Politica estricta;
	private Politica flexible;
	private Politica moderada;
	
	
	@BeforeEach
	void setUp() throws Exception{
		this.sistema = new SistemaDeAlquiler();
		this.prop1 = this.sistema.registrarPropiedad("nombreProp1","departamento1",100.00,"direccion depto 1",estricta);
		this.prop2 = this.sistema.registrarPropiedad("nombreProp2","casa2",300.00,"direccion casas 2",flexible);
		this.prop3 = this.sistema.registrarPropiedad("nombreProp3","departamento3",125.00,"direccion depto 3",moderada);

		
		this.inquilinoConAlquileres = this.sistema.registrarUsuario("Alquilador/inquilino","direccion del 1",38510742);
		this.inquilinoSinAlquileres = this.sistema.registrarUsuario("Yo no tengo alquiler","no tengo direccion",25897856);
		this.propietarioConProp = this.sistema.registrarUsuario("Tengo algunas para alquilar","muchas direcciones",12456789);
		this.propietarioSinProp = this.sistema.registrarUsuario("no tengo nada para alquilar","depto en el centro", 4587885);
	
		this.lapso1 = new DateLapse(LocalDate.of(2023, 10, 5), LocalDate.of(2023, 10, 15) ); // 5-10 al 15-10
		this.lapso2 = new DateLapse(LocalDate.of(2023, 10, 16), LocalDate.of(2023, 10, 25) ); // 16-10 al 25-10
		this.lapso3 = new DateLapse(LocalDate.of(2023, 10, 24), LocalDate.of(2023, 11, 5) ); // 24-10 al 5-11
		this.lapso4 = new DateLapse(LocalDate.of(2023, 11, 11), LocalDate.of(2023, 11, 20) ); // 11-11 al 20-11
		this.lapso5 = new DateLapse(LocalDate.of(2023, 12, 11), LocalDate.of(2023, 12, 20) ); // 11-12 al 20-12

		this.reserva1 = new Reserva(this.lapso1 , this.prop1); //1000
		this.prop1.agregarReserva(reserva1);
		this.reserva2 = new Reserva(this.lapso2 , this.prop1); //900
		this.prop1.agregarReserva(reserva2);
		//prop 1 usada del 5-10 al 25-10
		this.reserva3 = new Reserva(this.lapso4, this.prop2); //2700
		this.prop2.agregarReserva(reserva3);
		//prop 2 usada del 11-11 al 20-11
		//prop 3 no reservada
		
		this.inquilinoConAlquileres.agregarReserva(reserva1);
		this.inquilinoConAlquileres.agregarReserva(reserva2);
		
		this.propietarioConProp.agregarPropiedad(prop1);
		this.propietarioConProp.agregarPropiedad(prop2);
		this.propietarioConProp.agregarPropiedad(prop3);
	}
	
	@Test
	void testBuscarDisponibilidadEntre(){
		assertEquals(2,this.sistema.buscarDisponiblesEntre(lapso4).size());
		assertEquals(2,this.sistema.buscarDisponiblesEntre(lapso1).size());
		assertEquals(3,this.sistema.buscarDisponiblesEntre(lapso5).size());
	}
	
	@Test
	void testCancelarReserva() {
		assertEquals(2,this.inquilinoConAlquileres.obternerReservas().size());
		this.inquilinoConAlquileres.eliminarReserva(reserva1);
		assertEquals(1,this.inquilinoConAlquileres.obternerReservas().size());
		
		assertEquals(0,this.inquilinoSinAlquileres.obternerReservas().size());	
	}
	
	@Test
	void testIngresosPropietarioEntre() {
		assertEquals(0,this.propietarioSinProp.calcularIngresosEntre(lapso1));
		
		assertEquals(1000,this.propietarioConProp.calcularIngresosEntre(lapso1));
		assertEquals(900,this.propietarioConProp.calcularIngresosEntre(lapso2));
		assertEquals(2700,this.propietarioConProp.calcularIngresosEntre(lapso4));
		assertEquals(900,this.propietarioConProp.calcularIngresosEntre(lapso3));
	}
	
}
