package io.github.unlp_oo.greenHOOme;

import java.time.LocalDate;

public class OrdenCompra extends Orden {
	private double precioEnvio;
	
	public OrdenCompra(LocalDate fecha, String domicilio, double precioEnvio) {
		super(fecha, domicilio);
		this.precioEnvio = precioEnvio;
	}
	
	public double getPrecioEnvio() {
		return precioEnvio;
	}
	
	@Override
	public double calcular() {
		return getPrecioEnvio();
	}
	
	@Override
	public boolean aplicaDescuento() {
		return cantidadProductos() > 5;
	}
	
}
