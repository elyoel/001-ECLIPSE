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

	public void setPrecioEnvio(double precioEnvio) {
		this.precioEnvio = precioEnvio;
	}

	public double calcular() {
		// TODO Auto-generated method stub
		return getPrecioEnvio();
	}
	
}
