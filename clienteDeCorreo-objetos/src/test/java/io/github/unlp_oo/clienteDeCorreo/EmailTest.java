package io.github.unlp_oo.clienteDeCorreo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailTest {
	private List<Archivo> adjuntos;
	private Email emailSinAdjuntos, emailConAdjuntos;
	
	@BeforeEach
	void setUp() throws Exception {
		adjuntos = new ArrayList<>();
		adjuntos.add(new Archivo("archivo1"));
		adjuntos.add(new Archivo("archivo2"));
		adjuntos.add(new Archivo("archivo3"));
		
		emailConAdjuntos = new Email("Titulo1 de prueba", "Este mail tiene 66 tamaño", adjuntos);
		emailSinAdjuntos = new Email("Titulo2 de prueba", "Este mail tiene 42 tamaño");
	}

	@Test
	void testTamaño() {
		assertEquals(66, emailConAdjuntos.tamaño());
		assertEquals(42, emailSinAdjuntos.tamaño());
	}
	
	@Test
	void testContieneTexto() {
		//Pruebo con un texto en el titulo y otro en el cuerpo
		assertTrue(emailConAdjuntos.contieneTexto("Titulo1"));
		assertTrue(emailConAdjuntos.contieneTexto("66"));
		
		assertFalse(emailSinAdjuntos.contieneTexto("Titulo1"));
		assertFalse(emailSinAdjuntos.contieneTexto("66"));
	}
	
	@Test
	void testAdjuntos() {
		assertEquals(3, emailConAdjuntos.adjuntos().size());
		assertEquals(0, emailSinAdjuntos.adjuntos().size());
	}

}
