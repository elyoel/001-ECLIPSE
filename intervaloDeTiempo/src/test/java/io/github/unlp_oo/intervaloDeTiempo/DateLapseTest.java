package io.github.unlp_oo.intervaloDeTiempo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DateLapseTest {
	private IDateLapse lapso1, lapso2;
	private LocalDate fechaFuera, fechaDentro;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//lapso de 30 dias
		lapso1 = new DateLapseV1("01/01/2026", "31/01/2026");
		lapso2 = new DateLapseV2("01/01/2026", 30);
		
		fechaDentro = LocalDate.of(2026, 1, 15);
		fechaFuera = LocalDate.of(2026, 2, 1);
		
	}

	@Test
	void testIncludesDate() {
		//Fecha dentro de lapso de tiempo
		assertTrue(lapso1.includesDate(fechaDentro));
		assertTrue(lapso2.includesDate(fechaDentro));
		
		//Fecha fuera del lapso de tiempo
		assertFalse(lapso1.includesDate(fechaFuera));
		assertFalse(lapso2.includesDate(fechaFuera));
		
		//Fechas en valores borde
		assertTrue(lapso1.includesDate(lapso1.getFrom()));
		assertTrue(lapso1.includesDate(lapso1.getTo()));
		
		assertTrue(lapso2.includesDate(lapso2.getFrom()));
		assertTrue(lapso2.includesDate(lapso2.getTo()));
		
	}
	
	@Test
	void testSizeInDays() {
		assertEquals(30, lapso1.sizeInDays());
		
		assertEquals(30, lapso2.sizeInDays());		
	}
}
