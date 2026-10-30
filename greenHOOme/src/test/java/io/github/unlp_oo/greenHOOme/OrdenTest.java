package io.github.unlp_oo.greenHOOme;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrdenTest {

	private Producto p1, p2;
	private Tecnico t1, t2;
    private OrdenCompra ordenCompra;
    private OrdenServicio ordenServicioSinHoras, ordenServicioConHoras;
    
    @BeforeEach
    void setUp() {
        p1 = new Producto("Cable", "Cobre", 150.0, false);
        p2 = new Producto("Caja", "Carton", 50.0, true);
        t1 = new Tecnico("Juan", "Electricista", 2000.0);
        t2 = new Tecnico("Ana", "Ayudante", 1000.0);

        ordenCompra = new OrdenCompra(LocalDate.now(), "Calle 1", 500); 
        ordenServicioSinHoras = new OrdenServicio(LocalDate.now(), "Calle 2", "Revisión", 0);
        ordenServicioConHoras = new OrdenServicio(LocalDate.now(), "Calle 3", "Mantenimiento", 4);
    }

    @Test
    void testOrdenCompra_CeroProductos() {
        assertEquals(500.0, ordenCompra.calcularCosto());
    }

    @Test
    void testOrdenCompra_VariosProductos() {
        ordenCompra.agregarProducto(p1);
        ordenCompra.agregarProducto(p2); 
        
        // Costo = 150 + 50 + 500 = 700
        assertEquals(700.0, ordenCompra.calcularCosto());
    }

    @Test
    void testOrdenServicio_TodoCero() {
        assertEquals(0.0, ordenServicioSinHoras.calcularCosto());
    }

    @Test
    void testOrdenServicio_CeroHorasConProductos() {
        ordenServicioSinHoras.agregarProducto(p1);
        ordenServicioSinHoras.agregarTecnico(t1);
        
        // Costo = 150 + (0 * 2000) = 150
        assertEquals(150.0, ordenServicioSinHoras.calcularCosto());
    }

    @Test
    void testOrdenServicio_ConTecnicosYProductos() {
        ordenServicioConHoras.agregarProducto(p1);
        ordenServicioConHoras.agregarProducto(p2);
        
        ordenServicioConHoras.agregarTecnico(t1);
        ordenServicioConHoras.agregarTecnico(t2);
        
        // Costo prod = 150 + 50 = 200.0
        // Costo tec = 4 horas * (2000 + 1000) = 12000
        // Total = 12200
        assertEquals(12200.0, ordenServicioConHoras.calcularCosto());
    }
}
