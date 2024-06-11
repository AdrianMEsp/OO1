package ar.edu.unlp.info.oo1.Parcial5;

import java.time.LocalDate;
import java.util.*;

public class Sistema {
	private List<Empleado> empleados;
	private List<Repuesto> repuestos;
	private List<Orden> ordenes;
	
	public Sistema () {
		this.empleados = new ArrayList<Empleado>();
		this.repuestos = new ArrayList<Repuesto>();
		this.ordenes = new ArrayList<Orden>();
	}
	
	public Repuesto altaRepuesto(String nombre, LocalDate fechaFabricacion,
			double costo) {
		Repuesto repuesto = new Repuesto(nombre,fechaFabricacion ,costo);
		this.repuestos.add(repuesto);
		return repuesto;
	}
	
	public Empleado registrarEmpleado(String nombre, double valorHora) {
		Empleado emple = new Empleado(nombre, valorHora);
		this.empleados.add(emple);
		return emple;
	}
	
	public Orden registrarOrdenCompra(String patente, List<Repuesto> repuestos) {
		Orden orden = new OrdenCompra(patente,repuestos);
		this.ordenes.add(orden);
		return orden;
	}

	public Orden registrarOrdenReparacion(String patente,String descripcion, int horas,
			List<Empleado> empleados, List<Repuesto> repuestos) {
		Orden orden = new OrdenReparacion(patente,descripcion,horas,repuestos,empleados);
		this.ordenes.add(orden);
		return orden;
	}
	
	 public List<Factura> facturarOrdenes(List<Orden> ordenesAFacturar) {
	        List<Factura> facturas = new ArrayList<>();

	        for (Orden orden : ordenesAFacturar) {
	            double montoFinal = orden.calcularMontoFinal();
	            boolean tieneOtraOrden = ordenes.stream().anyMatch(o -> o.getPatente().equals(orden.getPatente()) && o.getFechaOrden().isAfter(LocalDate.now().minusMonths(12)));
	            double descuento = tieneOtraOrden ? 0.05 : 0.0;

	            if (descuento > 0) {
	                montoFinal -= montoFinal * descuento;
	            }

	            Factura factura = new Factura(orden.getPatente(), montoFinal, descuento);
	            facturas.add(factura);
	        }

	        return facturas;
	    }
	

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public List<Repuesto> getRepuestos() {
		return repuestos;
	}

	public List<Orden> getOrdenes() {
		return ordenes;
	}
	
}
