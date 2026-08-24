package ar.edu.unlp.info.oo1.balanzaElectronica;

public class Producto {
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public Producto(String descripcion, double peso, double precioPorKilo) {
		this.peso = peso;
		this.precioPorKilo = precioPorKilo;
		this.descripcion = descripcion;
	}
	
	public double getPeso() {
		return this.peso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public double getPrecio() {
		return this.precioPorKilo * this.peso;
	}

	public double getPrecioPorKilo() {
		return this.precioPorKilo;
	}

	public void setPrecioPorKilo(double precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}
	
	
}
