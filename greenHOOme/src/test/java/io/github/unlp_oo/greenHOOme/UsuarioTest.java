package io.github.unlp_oo.greenHOOme;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	private Usuario juanMartinez;
	private Orden ordenCompra, ordenServicio;
	private Producto panelSolar, compostera, calefonSolar;
	private List<Tecnico> tecnicos;
	
	@BeforeEach
	void setUp() throws Exception {
		juanMartinez = new Usuario("Juan Martinez", "Larrea 5800, La Plata");
		ordenCompra = new OrdenCompra(LocalDate.now(), "direccion 1", 0);
		tecnicos = new ArrayList<>();
		tecnicos.add(new Tecnico("Lucia Iraola", "Instalaciones solares", 4500));
		ordenServicio = new OrdenServicio(LocalDate.now(), "direccion 2", "Instalacion de calefon solar", 5, tecnicos);
		
		panelSolar = new Producto("Panel solar", "reciclable", 35000, false);
		compostera = new Producto("Compostera", "biodegradable", 8000, true);
		calefonSolar = new Producto("Calefon solar", "reciclable", 50000, false);
		
		ordenCompra.agregarProducto(panelSolar);
		ordenCompra.agregarProducto(compostera);
		
		ordenServicio.agregarProducto(calefonSolar);
		
		
		
	}

	@Test
	void testCalcularCosto_Servicio() {
		assertEquals(72500.0, ordenServicio.calcularCosto());
	}
	
	@Test
	void testCalcularCosto_Compra() {
		assertEquals(43000.0, ordenCompra.calcularCosto());
	}

}