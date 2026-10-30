package io.github.unlp_oo.greenHOOme;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Orden{
	private LocalDate fecha;
	private String domicilio;
	private List<Producto>productos;
	
	public Orden(LocalDate fecha, String domicilio) {
		this.fecha = fecha;
		this.domicilio = domicilio;
		productos = new ArrayList<>();
	}
	
	public int cantidadProductos() {
		return productos.size();
	}
	
	public double calcularCosto() {
		double montoTotal = productos.stream()
				.mapToDouble(p -> p.getCosto())
				.sum() + calcular();
		
		if (aplicaDescuento())
			montoTotal *= 0.9;
		
		return montoTotal;
	}
	
	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}

	public abstract double calcular();
	public abstract boolean aplicaDescuento();

}
