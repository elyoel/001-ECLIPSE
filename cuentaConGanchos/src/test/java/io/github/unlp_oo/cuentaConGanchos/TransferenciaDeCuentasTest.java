package io.github.unlp_oo.cuentaConGanchos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransferenciaDeCuentasTest {
	private CajaDeAhorro cuentaAhorro;
	private CuentaCorriente cuentaCorriente;
	
	@BeforeEach
	void setUp() throws Exception {
		cuentaAhorro = new CajaDeAhorro();
		cuentaCorriente = new CuentaCorriente();		
	}

	@Test
	void testTranferirCuentaCorriente() {
		cuentaAhorro.depositar(100); //saldo 98
		assertTrue(cuentaAhorro.transferirACuenta(50, cuentaCorriente));
		assertEquals(50, cuentaCorriente.getSaldo());
		assertEquals(47.0, cuentaAhorro.getSaldo());

	}
	
	@Test
	void testTransferirCajaAhorro() {
		cuentaCorriente.depositar(100); // saldo 100
		assertTrue(cuentaCorriente.transferirACuenta(50, cuentaAhorro));
		assertEquals(50, cuentaCorriente.getSaldo());
		assertEquals(49, cuentaAhorro.getSaldo());
	}

}
