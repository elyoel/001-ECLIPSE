package io.github.unlp_oo.greenHOOme;

public class Producto {
	private String nombre;
	private String tipoMaterial;
	private double costo;
	private boolean esBiodefradable;
	public Producto(String nombre, String tipoMaterial, double costo, boolean esBiodefradable) {
		super();
		this.nombre = nombre;
		this.tipoMaterial = tipoMaterial;
		this.costo = costo;
		this.esBiodefradable = esBiodefradable;
	}
	
	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String toString() {
		return "Producto [nombre=" + nombre + ", tipoMaterial=" + tipoMaterial + ", costo=" + costo
				+ ", esBiodefradable=" + esBiodefradable + "]";
	}
	
}
