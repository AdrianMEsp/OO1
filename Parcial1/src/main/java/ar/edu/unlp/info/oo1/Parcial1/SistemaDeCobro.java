package ar.edu.unlp.info.oo1.Parcial1;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeCobro {
	private List<PagoEscrito> pago;
	
	public SistemaDeCobro() {
		this.pago = new ArrayList<PagoEscrito>();
	}
	
	public double valorLiquido() {
		return this.pago.stream().mapToDouble(pago -> pago.valorLiquido()).sum();
	}
}
