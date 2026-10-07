package io.github.unlp_oo.VolumenYSuperficie;

public class Esfera extends Pieza {
	private double radio;

	public Esfera(String color, String material, double radio) {
		super(color, material);
	}

	@Override
	public double getSuperficie() {
		return 4 * Math.PI * Math.pow(radio, 2);
	}

	@Override
	public double getVolumen() {
		return (4/3) *  Math.PI * Math.pow(radio, 3);
	}

}
