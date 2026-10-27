package io.github.unlp_oo.clienteDeCorreo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarpetaTest {
	private Carpeta carpeta1, carpeta2;
	private List<Archivo> adjuntos;
	private Email email1, email2;
	
	@BeforeEach
	void setUp() throws Exception {
		adjuntos = new ArrayList<>();
		adjuntos.add(new Archivo("archivo1"));
		adjuntos.add(new Archivo("archivo2"));
		adjuntos.add(new Archivo("archivo3"));
		
		email1 = new Email("Titulo1 de prueba", "Este mail tiene 66 tamaño", adjuntos);
		email2= new Email("Titulo2 de prueba", "Este mail tiene 42 tamaño");
		
		carpeta1 = new Carpeta("Carpeta1");
		carpeta1.agregarMail(email1);
		
		carpeta2 = new Carpeta("Carpeta2");
	}

	@Test
	void testMover() {
		carpeta1.mover(email1, carpeta2);
		assertFalse(carpeta1.getEmails().contains(email1));
		assertTrue(carpeta2.getEmails().contains(email1));
		
		carpeta2.mover(email2, carpeta1);
		assertFalse(carpeta1.getEmails().contains(email2));
		assertFalse(carpeta2.getEmails().contains(email2));
		
	}
	
	@Test
	void testBuscar() {
		assertEquals(email1, carpeta1.buscar("Titulo1"));
		assertEquals(null, carpeta1.buscar("Sin resultados"));
		assertEquals(null, carpeta2.buscar("Sin resultados"));
	}

	@Test
	void testTamaño() {
		assertEquals(66, carpeta1.tamaño());
		assertEquals(0, carpeta2.tamaño());
	}
}
