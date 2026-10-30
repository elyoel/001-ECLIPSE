package io.github.unlp_oo.greenHOOme;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	private Usuario juanMartinez;
	private OrdenCompra ordenCompra;
	private OrdenServicio ordenServicio;
	private Producto panelSolar, compostera, calefonSolar;
	private Tecnico luciaTecnica;
	
	@BeforeEach
	void setUp() throws Exception {
		juanMartinez = new Usuario("Juan Martinez", "Larrea 5800, La Plata");
		luciaTecnica = new Tecnico("Lucia Iraola", "Instalaciones solares", 4500);
		
		ordenCompra = new OrdenCompra(LocalDate.now(), "Larrea 5800, La Plata", 0);
		ordenServicio = new OrdenServicio(LocalDate.now(), "Larrea 5800, La Plata", "Instalacion de calefon solar", 5);
		
		panelSolar = new Producto("Panel solar", "reciclable", 35000, false);
		compostera = new Producto("Compostera", "biodegradable", 8000, true);
		calefonSolar = new Producto("Calefon solar", "reciclable", 50000, false);
				
		juanMartinez.agregarOrden(ordenCompra);
		juanMartinez.agregarOrden(ordenServicio);
		
	}

	@Test
	void testCalcularCosto_Servicio() {		
		ordenServicio.agregarProducto(calefonSolar);
		ordenServicio.agregarTecnico(luciaTecnica);

		assertEquals(72500.0, ordenServicio.calcularCosto());
	}
	
	@Test
	void testCalcularCosto_Compra() {
		ordenCompra.agregarProducto(panelSolar);
		ordenCompra.agregarProducto(compostera);

		assertEquals(43000.0, ordenCompra.calcularCosto());
	}

}