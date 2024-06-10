package ar.edu.unlp.info.oo1.Parcial1;

import java.time.LocalDate;

public class Pagare extends PagoEscrito{
	private LocalDate fechaVencimiento;
	
	public Pagare(String ori, String dest, LocalDate fechaEmi, double mon,LocalDate fechaV) {
		super(ori,dest,fechaEmi,mon);
		this.fechaVencimiento=fechaV;
	}
	
	public boolean estaVencido() {
		return ( LocalDate.now().isAfter(fechaVencimiento) || 
				LocalDate.now().isEqual(fechaVencimiento)
		);
	}
	
	public double valorLiquido() {
		if (this.estaVencido())
			return this.getMonto();
		return 0;
	}
	
	//Gettes
	
	public LocalDate getFechaVencimiento() {
		return this.fechaVencimiento;
	}
	
	//Setters
	
	public void setFechaVencimiento(LocalDate date) {
		this.fechaVencimiento=date;
	}
}
