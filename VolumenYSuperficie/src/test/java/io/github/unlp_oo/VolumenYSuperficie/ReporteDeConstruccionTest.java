package io.github.unlp_oo.VolumenYSuperficie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReporteDeConstruccionTest {
	private ReporteDeConstruccion reporte;
	private Cilindro cilindro;
	private Esfera esfera;
	private PrismaRectangular prismaRectangular;

	@BeforeEach
	void setUp() {
		reporte = new ReporteDeConstruccion();
		cilindro = new Cilindro("Hierro", "Rojo", 10, 20);
		esfera = new Esfera("Hierro", "Azul", 8);
		prismaRectangular = new PrismaRectangular("Metal", "Azul", 10, 5, 30);
		
		reporte.agregarPieza(cilindro);
		reporte.agregarPieza(esfera);
		reporte.agregarPieza(prismaRectangular);
	}

	@Test
	void testVolumen() {
		assertEquals(6283.18, cilindro.getVolumen(), 0.1);
		assertEquals(2144.66, esfera.getVolumen(), 0.1);
		assertEquals(1500.00, prismaRectangular.getVolumen(), 0.1);
	}

	@Test
	void testSuperficie() {
		assertEquals(1884.95, cilindro.getSuperficie(), 0.1);
		assertEquals(804.24, esfera.getSuperficie(), 0.1);
		assertEquals(1000.00, prismaRectangular.getSuperficie(), 0.1);
	}

	@Test
	void testVolumenDeMaterial() {
		assertEquals(8427.84, reporte.volumenDeMaterial("Hierro"), 0.1);
		assertEquals(0, reporte.volumenDeMaterial("Diamante"), 0.1);
		assertEquals(0, reporte.volumenDeMaterial(null), 0.1);
	}
	
	@Test
	void testSuperficieDeColor() {
		assertEquals(1804.24, reporte.superficieDeColor("Azul"), 0.1);
		assertEquals(0, reporte.superficieDeColor("Verde"), 0.1);
		assertEquals(0, reporte.superficieDeColor(null), 0.1);
	}
}
