package io.github.unlp_oo.cuentaConGanchos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaCorrienteTest {
	private CuentaCorriente cuenta1;
	private CuentaCorriente cuenta2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.cuenta1 = new CuentaCorriente();
		this.cuenta2  = new CuentaCorriente();
	}

	@Test
	void testDepositar() {
		cuenta1.depositar(100);
		
		assertEquals(100, cuenta1.getSaldo());
	}
	@Test
	void testExtraer() {
		cuenta1.setDescubierto(500);
		
		assertTrue(cuenta1.extraer(300));
		assertEquals(-300.0, cuenta1.getSaldo());
		
		cuenta2.setDescubierto(500);
		
		assertFalse(cuenta2.extraer(600));
		assertEquals(0.0, cuenta2.getSaldo());
	
	}
	@Test
	void testTransferirACuenta() {
		cuenta1.setDescubierto(200);
		
		assertFalse(cuenta1.transferirACuenta(300, cuenta2));
		assertEquals(0.0, cuenta1.getSaldo());
		assertEquals(0.0, cuenta2.getSaldo());
		
		assertTrue(cuenta1.transferirACuenta(100, cuenta2));
		assertEquals(-100.0, cuenta1.getSaldo());
		assertEquals(100.0, cuenta2.getSaldo());
	}
	
}
