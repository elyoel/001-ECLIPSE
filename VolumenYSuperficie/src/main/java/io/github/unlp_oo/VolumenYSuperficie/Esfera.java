package io.github.unlp_oo.VolumenYSuperficie;

public class Esfera extends Pieza {
	private double radio;

	public Esfera(String material, String color, double radio) {
		super(color, material);
		this.radio = radio;
	}

	@Override
	public double getSuperficie() {
		return 4 * Math.PI * Math.pow(radio, 2);
	}

	@Override
	public double getVolumen() {
		return (4.0/3.0) *  Math.PI * Math.pow(radio, 3);
	}

}
