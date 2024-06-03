package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateLapseTest {
	private DateLapse lapso1;// 1/10 al 10/10
	private DateLapse lapso2;// 6/10 al 15/10
	private DateLapse lapso3;// 10/10 al 25/10
	private DateLapse lapso4;// 26/10 al 5/11
	
	@BeforeEach
	void setUp() throws Exception {
		this.lapso1 = new DateLapse(LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 10));
		this.lapso2 = new DateLapse(LocalDate.of(2023, 10, 6), LocalDate.of(2023, 10, 15));
		this.lapso3 = new DateLapse(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 25));
		this.lapso4 = new DateLapse(LocalDate.of(2023, 10, 26), LocalDate.of(2023, 11, 5));
	}
	
	@Test
	void testOverlaps() {
		assertTrue(this.lapso1.overlaps(lapso1));
		assertTrue(this.lapso1.overlaps(lapso2));
		assertTrue(this.lapso2.overlaps(lapso3));
		assertFalse(this.lapso3.overlaps(lapso4));
		assertFalse(this.lapso1.overlaps(lapso3));
	}
	
	@Test
	void testDespuesDe() {
		assertFalse(this.lapso1.despuesDe());
		assertFalse(this.lapso2.despuesDe());
		assertFalse(this.lapso3.despuesDe());
		assertTrue(this.lapso4.despuesDe());
	}
}
