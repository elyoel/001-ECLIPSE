package io.github.unlp_oo.cuentaConGanchos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaDeAhorroTest {
	private Cuenta caja1;
	private Cuenta caja2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.caja1 = new CajaDeAhorro();
		this.caja2 = new CajaDeAhorro();
	}

	@Test
	void testDepositar() {
		caja1.depositar(100);
		
		assertEquals(98.0, caja1.getSaldo());
	}
	
	@Test
	void testExtraer() {
		caja1.depositar(100);
		
		assertTrue(caja1.extraer(50));
		assertEquals(47.0, caja1.getSaldo());
	}
	
	@Test
	void tesTtransferirACuenta() {
		caja1.depositar(100);
		
		assertEquals(98.0, caja1.getSaldo());
		
		assertFalse(caja1.transferirACuenta(98, caja2));
		assertEquals(98.0, caja1.getSaldo());
		assertEquals(0.0, caja2.getSaldo());
		
		assertTrue(caja1.transferirACuenta(50, caja2));
		assertEquals(47.0, caja1.getSaldo());
		assertEquals(49.0, caja2.getSaldo());
		
	}

}
