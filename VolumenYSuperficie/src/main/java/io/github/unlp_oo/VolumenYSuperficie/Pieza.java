package io.github.unlp_oo.VolumenYSuperficie;

public abstract class Pieza {
	private String color;
	private String material;
	
	public Pieza(String color, String material) {
		this.color = color;
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public String getColor() {
		return color;
	}
	
	public abstract double getSuperficie();
	public abstract double getVolumen();
	
}
