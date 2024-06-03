package ar.edu.unlp.info.oo1.ejercicio16;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateLapseTest {
	private DateLapse lapso1;
	private DateLapse lapso2;
	private DateLapse lapso3;
	private DateLapse lapso4;
	
	@BeforeEach
		void setUp() throws Exception {
			this.lapso1 = new DateLapse(LocalDate.of(2023, 10, 5), LocalDate.of(2023, 10, 15));
			this.lapso2 = new DateLapse(LocalDate.of(2023, 10, 15), LocalDate.of(2023, 10, 25));
			this.lapso3 = new DateLapse(LocalDate.of(2023, 10, 6), LocalDate.of(2023, 10, 22));
			this.lapso4 = new DateLapse(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 15));
	}

	@Test
	void testOverlapse(){
		assertTrue(this.lapso1.overlaps(lapso1));
		assertFalse(this.lapso1.overlaps(lapso2));
		assertFalse(this.lapso1.overlaps(lapso4));
		assertTrue(this.lapso2.overlaps(lapso3));
		
	}
}
