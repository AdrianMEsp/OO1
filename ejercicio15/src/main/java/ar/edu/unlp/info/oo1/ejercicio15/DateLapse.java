package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse (LocalDate from, LocalDate to) {
		this.from = from;
		this.to= to;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return this.to;
	}
	
	public int sizeInDays() {
		return (int) ChronoUnit.DAYS.between(from, to);
	}
	
	public boolean includesDate(LocalDate other) {
		return other.isAfter(this.from) && other.isBefore(this.to);
	}
	
	public boolean overlaps(DateLapse other) {
		return other.includesDate(this.getFrom()) || other.includesDate(this.getTo())
				|| other.equalsFrom(this.getFrom()) || other.equalsTo(this.getTo());
		//si devuelve true es porque se superponen las fechas
	}
	
	public boolean equalsFrom (LocalDate date) {
		return this.getFrom().equals(date);
	}
	
	public boolean equalsTo (LocalDate date) {
		return this.getTo().equals(date);
	}
	
	public boolean despuesDe() {
		return this.getFrom().isAfter(LocalDate.now());
	}
}
