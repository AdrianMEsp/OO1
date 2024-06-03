package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from=from;
		this.to=to;
	}
	
	public boolean includesDate (LocalDate otro) {
		return otro.isAfter(this.from) && otro.isBefore(this.to);
	}
	
	public boolean overlaps(DateLapse other) {
		return other.includesDate(this.getFrom()) || other.includesDate(this.getTo())
				|| other.equalsFrom(this.getFrom()) || other.equalsTo(this.getTo());
	}

	private boolean equalsFrom(LocalDate from) {
		return this.getFrom().equals(from);
	}
	
	private Boolean equalsTo(LocalDate to) {
		return this.getTo().equals(to);
	}
	
	public LocalDate getFrom() {
		return this.from;
	}

	public LocalDate getTo() {
		return this.to;
	}
	
	public int cantDias() {
		return (int) ChronoUnit.DAYS.between(from, to);
	}

	public boolean inicioPosteriorActual() {
		return this.getFrom().isAfter(LocalDate.now());
	}

	
}
