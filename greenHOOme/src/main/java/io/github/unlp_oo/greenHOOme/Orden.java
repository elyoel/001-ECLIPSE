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
	public String toString() {
		return "Orden [fecha=" + fecha + ", domicilio=" + domicilio + "]";
	}
	public abstract double calcular();
	
	public double calcularCosto() {
		double aux = productos.stream()
				.mapToDouble(p -> p.getCosto())
				.sum();
		
		return aux + calcular();
	}
	
	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}
}
