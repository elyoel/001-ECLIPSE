package io.github.unlp_oo.VolumenYSuperficie;

public class Cilindro extends Pieza {
	private double radio;
	private double altura;

	public Cilindro(String color, String material, double radio, double altura) {
		super(color, material);
		this.radio = radio;
		this.altura = altura;
	}

	@Override
	public double getSuperficie() {
		return 2 * Math.PI * radio * altura + 2 * Math.PI * Math.pow(radio, 2);
	}

	@Override
	public double getVolumen() {
		return Math.PI * Math.pow(radio, 2) * altura;
	}

}
