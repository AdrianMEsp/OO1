package ar.edu.unlp.info.oo1.Parcial5;

import java.util.List;

public class OrdenCompra extends Orden {
	
	public OrdenCompra(String patente, List<Repuesto> repuestosUsados) {
		super(patente, repuestosUsados);
	}
	

	@Override
    public double calcularCosto() {
        double costoTotal = 0.0;
        for (Repuesto repuesto : getRepuestos()) {
            costoTotal += repuesto.getCosto();
        }
        return costoTotal;
    }

    @Override
    public double calcularMontoFinal() {
        double costo = calcularCosto();
        double incrementoGanancia = getRepuestos().stream().anyMatch(Repuesto::esAntiguo) ? 0.08 : 0.15;
        return costo + (costo * incrementoGanancia);
    }
    
}
