package ar.edu.unlp.info.oo1.Parcial1;

import java.time.LocalDate;

public abstract class PagoEscrito {
	private String destinatario;
	private String originante;
	private LocalDate fechaEmision;
	private double monto;
	
	public PagoEscrito(String dest, String ori, LocalDate fechaEmi, double mon) {
		this.destinatario=dest;
		this.originante=ori;
		this.setFechaEmision(fechaEmi);
		this.monto=mon;
	}
	
	public abstract boolean estaVencido();
	
	public abstract double valorLiquido();
	
	//Setters
	
		public void setDestinatario(String des) {
			this.destinatario=des;
		}
		
		public void setOriginante(String ori) {
			this.originante=ori;
		}
	
		public void setFechaEmision(LocalDate fechaEmision) {
			this.fechaEmision = fechaEmision;
		}
		
		public void setMonto(double mont) {
			this.monto=mont;
		}
	
	
	//Getters
	
		public LocalDate getFechaEmision() {
			return fechaEmision;
		}
		
		public String getDestinatario () {
			return this.destinatario;
		}
		
		public String getOriginante () {
			return this.originante;
		}
		
		public double getMonto() {
			return this.monto;
		}

		
}
