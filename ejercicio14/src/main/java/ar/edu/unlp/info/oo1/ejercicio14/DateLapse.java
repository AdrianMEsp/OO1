package ar.edu.unlp.info.oo1.ejercicio14;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import date2.Date;


public class DateLapse implements Date {
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from=from;
		this.to=to;
	}
	
	@Override
	public LocalDate getFrom() {
		return this.from;
	}
	
	@Override
	public LocalDate getTo() {
		return this.to;
	}
	
	@Override
	public int sizeInDays() {
		return (int) ChronoUnit.DAYS.between(from, to);
	}
	
	@Override
	public boolean includesDate(LocalDate other) {
		return other.isAfter(this.from) && other.isBefore(this.to);
	}
}
