package ar.edu.unlp.info.oo1.Parcial5;

import java.util.List;

public class OrdenReparacion extends Orden {
	private int horasTrabajo;
	private String descripcion;
	private List<Empleado> empleadosDeOrden;

	public OrdenReparacion(String patente,String descrip, int horas, List<Repuesto> repuestosUsados
			,List<Empleado> empleados) {
		super(patente, repuestosUsados);
		this.descripcion = descrip;
		this.horasTrabajo = horas;
		this.empleadosDeOrden = empleados;
	}

	@Override
    public double calcularCosto() {
        double costoEmpleados = 0.0;
        for (Empleado empleado : empleadosDeOrden) {
            costoEmpleados += empleado.getValorHora() * horasTrabajo;
        }

        double costoRepuestos = 0.0;
        for (Repuesto repuesto : getRepuestos()) {
            costoRepuestos += repuesto.getCosto();
        }

        return costoEmpleados + costoRepuestos;
    }

    @Override
    public double calcularMontoFinal() {
        double costo = calcularCosto();
        return costo + (costo * 0.10);
    }
	
	public int getHorasTrabajo() {
		return horasTrabajo;
	}

	public void setHorasTrabajo(int horasTrabajo) {
		this.horasTrabajo = horasTrabajo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Empleado> getEmpleadosDeOrden() {
		return empleadosDeOrden;
	}
}
