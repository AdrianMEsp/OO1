package ar.edu.unlp.info.oo1.Parcial1;

import java.time.LocalDate;

public class Cheque extends PagoEscrito{
	
	public Cheque(String dest, String ori, LocalDate fechaEmi, double mon) {
		super(dest,ori,fechaEmi,mon);
	}
	
	public boolean estaVencido() {
		if (LocalDate.now().isEqual(this.getFechaEmision().plusDays(30)))
			return true;
		return (LocalDate.now().isAfter(this.getFechaEmision().plusDays(30)));
	}
	
	public double valorLiquido() {
		if (this.estaVencido())
			return 0;
		return this.getMonto();
	}

	
}
