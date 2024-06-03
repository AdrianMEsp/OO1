package ar.edu.unlp.info.oo1.ejercicio14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import date2.DateLapse2;

class DateLapseTest {
	private DateLapse lapse;
	private DateLapse2 lapse2;
	private LocalDate to;
	private LocalDate from;
	private LocalDate other;
	
	@BeforeEach
	void setUp() throws Exception {
		this.from = LocalDate.of(2022,1,27);
		this.to = LocalDate.of(2023,10,5); 
		this.lapse = new DateLapse(this.from, this.to);
		
		this.lapse2 = new DateLapse2(LocalDate.of(1995,04,19),100); //1995-07-28
	}
	
	@Test
	void testGetFrom() {
		assertEquals(this.from , this.lapse.getFrom());
		
		assertEquals(LocalDate.of(1995, 04, 19),this.lapse2.getFrom());
	}
	
	@Test
	void testGetTo() {
		assertEquals(this.to , this.lapse.getTo());
		
		assertEquals(LocalDate.of(1995, 07, 28),this.lapse2.getTo());
	}
	
	@Test
	void testSizeInDays() {
		assertEquals(616,this.lapse.sizeInDays());
		
		assertEquals(100,this.lapse2.sizeInDays());
	}
	
	@Test
	void testIncludeDates() {
		this.other = LocalDate.of(2023,1,1);
		assertEquals(true, this.lapse.includesDate(other));
		assertEquals(false, this.lapse2.includesDate(other));
		
		
		this.other = LocalDate.of(1995,6,5);
		assertEquals(false, this.lapse.includesDate(other));
		assertEquals(true, this.lapse2.includesDate(other));
		
	}
}
